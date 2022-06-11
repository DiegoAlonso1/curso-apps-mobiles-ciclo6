import 'package:flutter/material.dart';
import 'package:app_market/utils/dbhelper.dart';
import 'package:app_market/models/list_items.dart';
import 'package:app_market/models/shopping_list.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    DbHelper helper = DbHelper();
    helper.testDB();

    return MaterialApp(
        theme: ThemeData(
          primarySwatch: Colors.blueGrey,
        ),
        home: Scaffold(
          appBar: AppBar(
            title: Text('Shopping List'),
          ),
          body: ShowList(),
        ));
  }
}

class ShowList extends StatefulWidget {
  @override
  State<ShowList> createState() => _ShowListState();
}

class _ShowListState extends State<ShowList> {
  DbHelper helper = DbHelper();

  @override
  Widget build(BuildContext context) {
    return Container();
  }
}
