import 'package:bestgourmet_olivera/models/category.dart';
import 'package:bestgourmet_olivera/ui/pages/category_detail_page.dart';
import 'package:bestgourmet_olivera/utils/http_helper.dart';
import 'package:flutter/material.dart';

class CategoryPage extends StatefulWidget {
  @override
  State<CategoryPage> createState() => _CategoryPageState();
}

class _CategoryPageState extends State<CategoryPage> {
  List<Category_> categories = [];
  int? categoriesCount;
  bool loading = true;
  HttpHelper? helper;
  ScrollController? _scrollController;

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
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Categories'),
        ),
        body: ListView.builder(
          controller: _scrollController,
          itemCount: categories!.length,
          itemBuilder: (BuildContext context, int index) {
            return CategoryRow(categories![index]);
          },
        ));
  }

  void loadMore() async {
    helper!.getCategories().then((value) {
      categories += value;
      setState(() {
        categoriesCount = categories.length;
        categories = categories;
      });

      if (categories.length % 20 > 0) {
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

class CategoryRow extends StatefulWidget {
  final Category_ category;
  CategoryRow(this.category);

  @override
  State<CategoryRow> createState() => _CategoryRowState(category);
}

class _CategoryRowState extends State<CategoryRow> {
  Category_ category;
  _CategoryRowState(this.category);

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.white,
      elevation: 2.0,
      child: ListTile(
        leading: Hero(
          tag: 'category__' + widget.category.idCategory.toString(),
          child: Image.network(category.strCategoryThumb.toString()),
        ),
        title: Text(widget.category.strCategory.toString()),
        // subtitle: Text(widget.category.strCategoryDescription.toString()),
        onTap: () {
          Navigator.push(
            context,
            MaterialPageRoute(
                builder: (BuildContext context) =>
                    CategoryDetailPage(widget.category)),
          ).then((value) {
            // isFavorite(movie);
          });
        },
      ),
    );
  }
}
