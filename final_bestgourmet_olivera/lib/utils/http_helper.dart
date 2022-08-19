import 'package:bestgourmet_olivera/models/category.dart';
import 'package:bestgourmet_olivera/models/dish.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'dart:io';

class HttpHelper {
  // • Para el listado de las categorías de platos:
  // https://www.themealdb.com/api/json/v2/9973533/categories.php
  // • Para el listado de platos por categoría
  // https://www.themealdb.com/api/json/v2/9973533/filter.php?c=seafood

  final String urlBase = 'https://www.themealdb.com/api/json/v2/9973533';
  final String urlCategories = '/categories.php';
  final String urlByCategory = '/filter.php?c=';

  Future<List<Category_>> getCategories() async {
    final String categoriesEndpoint = urlBase + urlCategories;
    print(categoriesEndpoint);
    http.Response result = await http.get(Uri.parse(categoriesEndpoint));

    if (result.statusCode == HttpStatus.ok) {
      final jsonResponse = json.decode(result.body);
      final categoriesMap = jsonResponse['categories'];
      // print(categoriesMap);
      // categoriesMap.map<void>((i) => print('ACA TA: ' + i));

      List<Category_> categories =
          categoriesMap.map<Category_>((i) => Category_.fromJson(i)).toList();

      return categories;
    } else {
      print(result.body);
      return null!;
    }
  }

  Future<List<Dish_>> getDishByCategory(String category) async {
    final String dishByCategoryEndpoint = urlBase + urlByCategory + category;
    print(dishByCategoryEndpoint);
    http.Response result = await http.get(Uri.parse(dishByCategoryEndpoint));

    if (result.statusCode == HttpStatus.ok) {
      final jsonResponse = json.decode(result.body);
      final categoriesMap = jsonResponse['meals'];

      List<Dish_> dishesByCategory =
          categoriesMap.map<Dish_>((i) => Dish_.fromJson(i)).toList();

      return dishesByCategory;
    } else {
      print(result.body);
      return null!;
    }
  }
}
