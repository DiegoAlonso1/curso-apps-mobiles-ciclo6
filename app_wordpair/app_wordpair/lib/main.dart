import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: RandomWord(),
    );
  }
}

class RandomWord extends StatefulWidget {
  const RandomWord({Key? key}) : super(key: key);

  @override
  State<RandomWord> createState() => _RandomWordState();
}

class _RandomWordState extends State<RandomWord> {
  final List<WordPair> suggestions = <WordPair>[];
  final TextStyle biggerfont = const TextStyle(fontSize: 18);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("StartUp Name Generator!!"),
      ),
      body: buildSuggestions(),
    );
  }

  Widget buildSuggestions() {
    return ListView.builder(
        padding: const EdgeInsets.all(16),
        itemBuilder: (BuildContext context, int i) {
          if (i.isOdd) {
            return const Divider();
          }

          final int index = i ~/ 2;

          if (index >= suggestions.length) {
            suggestions.addAll(generateWordPairs().take(10));
          }

          return buildRow(suggestions[index]);
        });
  }

  Widget buildRow(WordPair pair) {
    return ListTile(title: Text(pair.asPascalCase, style: biggerfont));
  }
}
