import 'dart:ffi';

import 'package:bestgourmet_olivera/models/category.dart';
import 'package:bestgourmet_olivera/models/dish.dart';
import 'package:bestgourmet_olivera/utils/http_helper.dart';
import 'package:flutter/material.dart';

class CategoryDetailPage extends StatefulWidget {
  final Category_ category;
  CategoryDetailPage(this.category);

  @override
  State<CategoryDetailPage> createState() => _CategoryDetailPageState(category);
}

class _CategoryDetailPageState extends State<CategoryDetailPage> {
  final Category_ category;

  List<Dish_> dishes = [];
  int? dishesCount;
  bool loading = true;
  HttpHelper? helper;
  ScrollController? _scrollController;

  _CategoryDetailPageState(this.category);

  Future initialize() async {
    loadMore();
    initScrollController();
  }

  @override
  void initState() {
    super.initState();
    helper = HttpHelper();
    initialize();
  }

  @override
  void setState(fn) {
    if (mounted) {
      super.setState(fn);
    }
  }

  @override
  Widget build(BuildContext context) {
    double height = MediaQuery.of(context).size.height;

    return Scaffold(
      appBar: AppBar(
        title: Text(category.strCategory.toString()),
      ),
      body: SingleChildScrollView(
        child: Center(
          child: Container(
            padding: EdgeInsets.all(8),
            child: Column(
              children: [
                Hero(
                  tag: 'category_${category.idCategory.toString()}',
                  child: Image.network(
                    category.strCategoryThumb.toString(),
                    height: height / 1.5,
                  ),
                ),
                Text(category.strCategoryDescription.toString(),
                    style: TextStyle(fontSize: 16)),
                SizedBox(
                  height: 30,
                ),
                Text(
                  'Meals',
                  style: TextStyle(fontSize: 20),
                ),
                SizedBox(
                  height: 10,
                ),
                ListView.builder(
                  scrollDirection: Axis.vertical,
                  shrinkWrap: true,
                  controller: _scrollController,
                  itemCount: dishes!.length,
                  itemBuilder: (BuildContext context, int index) {
                    return DishRow(dishes![index]);
                  },
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void loadMore() async {
    helper!
        .getDishByCategory(category.strCategory.toString().toLowerCase())
        .then((value) {
      dishes += value;
      setState(() {
        dishesCount = dishes.length;
        dishes = dishes;
      });

      if (dishes.length % 20 > 0) {
        loading = false;
      }
    });
  }

  void initScrollController() {
    _scrollController = ScrollController();
    _scrollController!.addListener(() {
      if ((_scrollController!.position.pixels ==
              _scrollController!.position.maxScrollExtent) &&
          loading) {
        loadMore();
      }
    });
  }
}

class DishRow extends StatefulWidget {
  final Dish_ dish;
  DishRow(this.dish);

  @override
  State<DishRow> createState() => _DishRowState(dish);
}

class _DishRowState extends State<DishRow> {
  Dish_ dish;
  _DishRowState(this.dish);

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.white,
      elevation: 2.0,
      child: ListTile(
        leading: Hero(
          tag: 'poster_' + widget.dish.idMeal.toString(),
          child: Image.network(dish.strMealThumb.toString()),
        ),
        title: Text(widget.dish.strMeal.toString()),
        // subtitle: Text(widget.category.strCategoryDescription.toString()),
      ),
    );
  }
}
