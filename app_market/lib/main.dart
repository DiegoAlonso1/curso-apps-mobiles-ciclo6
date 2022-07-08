import 'package:app_market/ui/items_screen.dart';
import 'package:app_market/ui/shopping_list_dialog.dart';
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
        home: ShowList());
  }
}

class ShowList extends StatefulWidget {
  @override
  State<ShowList> createState() => _ShowListState();
}

class _ShowListState extends State<ShowList> {
  DbHelper helper = DbHelper();
  List<ShoppingList> shoppingLists = [];

  ShoppingListDialog? dialog;

  @override
  void initState() {
    dialog = ShoppingListDialog();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    showData();
    return Scaffold(
      appBar: AppBar(
        title: const Text('Shopping Lists!'),
      ),
      body: ListView.builder(
        itemCount: (shoppingLists != null) ? shoppingLists.length : 0,
        itemBuilder: (BuildContext context, int index) {
          return ListTile(
            title: Text(shoppingLists[index].name!),
            leading: CircleAvatar(
              child: Text(shoppingLists[index].priority.toString()),
            ),
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => ItemsScreen(shoppingLists[index]),
                ),
              );
            },
            trailing: Row(
              children: [
                IconButton(
                  icon: const Icon(Icons.edit),
                  onPressed: () {
                    showDialog(
                        context: context,
                        builder: (BuildContext context) => dialog!
                            .buildDialog(context, shoppingLists[index], false));
                  },
                ),
                IconButton(
                  icon: const Icon(Icons.delete),
                  onPressed: () {
                    helper.deleteList(shoppingLists[index].id!);
                    setState(() {
                      shoppingLists.removeAt(index);
                    });
                  },
                ),
              ],
            ),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showDialog(
              context: context,
              builder: (BuildContext context) =>
                  dialog!.buildDialog(context, ShoppingList(0, '', 0), true));
        },
        child: const Icon(Icons.add),
        backgroundColor: Colors.green,
      ),
    );
  }

  Future showData() async {
    List<ShoppingList> lists = await helper.getLists();
    setState(() {
      shoppingLists = lists;
    });
  }
}
