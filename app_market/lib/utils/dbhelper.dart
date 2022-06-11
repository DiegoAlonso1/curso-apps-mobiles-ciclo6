import "package:sqflite/sqflite.dart";
import "package:path/path.dart";
import 'package:app_market/models/list_items.dart';
import 'package:app_market/models/shopping_list.dart';

class DbHelper {
  final int version = 1;
  Database? db;

  Future<Database> openDb() async {
    if (db == null) {
      db = await openDatabase(join(await getDatabasesPath(), 'shoppV2.db'),
          onCreate: (database, version) {
        database.execute(
            'CREATE TABLE list(id INTEGER PRIMARY KEY, name TEXT, priority INTEGER)');

        database.execute(
            'CREATE TABLE items(id INTEGER PRIMARY KEY, idList INTEGER, '
            'name TEXT, quantity TEXT, note TEXT, FOREIGN KEY(idList) REFERENCES list(id))');
      }, version: version);
    }

    return db!;
  }

  Future testDB() async {
    db = await openDb();

    await db!.execute('INSERT INTO list(name, priority) values ("Fruits", 2)');
    await db!.execute(
        'INSERT INTO items(idList, name, quantity, note) values (0, "Naranjas", "2 kgs", "Para jugar")');

    List list = await db!.rawQuery('SELECT * FROM list');
    List item = await db!.rawQuery('SELECT * FROM items');

    print(list[0]);
    print(item[0]);
  }

  // insert a new list
  Future<int> insertList(ShoppingList list) async {
    int id = await this.db!.insert('list', list.toMap(),
        conflictAlgorithm: ConflictAlgorithm.replace);

    return id;
  }

  // insert a new item
  Future<int> insertItem(ListItem item) async {
    int id = await this.db!.insert('items', item.toMap(),
        conflictAlgorithm: ConflictAlgorithm.replace);

    return id;
  }
}
