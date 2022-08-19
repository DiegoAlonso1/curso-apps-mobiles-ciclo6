import 'dart:convert';

class Dish_ {
  String? strMeal;
  String? strMealThumb;
  String? idMeal;

  Dish_({
    this.strMeal,
    this.strMealThumb,
    this.idMeal,
  });

  Map<String, dynamic> toMap() {
    return {
      'strMeal': strMeal,
      'strMealThumb': strMealThumb,
      'idMeal': idMeal,
    };
  }

  factory Dish_.fromJson(Map<String, dynamic> json) {
    return Dish_(
      strMeal: json['strMeal'] as String,
      strMealThumb: json['strMealThumb'] as String,
      idMeal: json['idMeal'] as String,
    );
  }
}
