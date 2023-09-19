import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.amber,
      ),
      home: const MyScrollPage(title: ''),
    );
  }
}

class MyScrollPage extends StatefulWidget {
  const MyScrollPage({super.key, required this.title});

  final String title;

  @override
  State<MyScrollPage> createState() => _MyScrollPageState();
}

class _MyScrollPageState extends State<MyScrollPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.green,
          title: Text(widget.title),
        ),
        body: Padding(
          padding: const EdgeInsets.all(20.0),
          child: SingleChildScrollView(
            child: Column(
              children: [
                Padding(
                  padding: const EdgeInsets.only(bottom: 8.0),
                  child: SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                    child: Row(
                      children: [
                        Container(
                          height: 200,
                          width: 200,
                          color: Color.fromARGB(31, 223, 213, 12),
                          margin: EdgeInsets.only(right: 10),
                        ),
                        Container(
                          height: 200,
                          width: 200,
                          color: const Color.fromARGB(31, 195, 33, 33),
                          margin: EdgeInsets.only(right: 10),
                        ),
                        Container(
                          height: 200,
                          width: 200,
                          color: Color.fromARGB(31, 24, 166, 86),
                          margin: EdgeInsets.only(right: 10),
                        ),
                        Container(
                          height: 200,
                          width: 200,
                          color: Color.fromARGB(31, 130, 100, 225),
                          margin: EdgeInsets.only(right: 10),
                        ),
                        Container(
                          height: 200,
                          width: 200,
                          color: Color.fromARGB(31, 186, 79, 203),
                          margin: EdgeInsets.only(right: 10),
                        ),
                        Container(
                          height: 200,
                          width: 200,
                          color: Color.fromARGB(31, 198, 136, 187),
                          margin: EdgeInsets.only(right: 10),
                        ),
                        Container(
                          height: 200,
                          width: 200,
                          color: Color.fromARGB(31, 197, 236, 113),
                          margin: EdgeInsets.only(bottom: 10),
                        ),
                      ],
                    ),
                  ),
                ),
                Container(
                  height: 200,
                  color: Colors.blue,
                  margin: EdgeInsets.only(bottom: 10),
                ),
                Container(
                  height: 200,
                  color: Colors.greenAccent,
                  margin: EdgeInsets.only(bottom: 10),
                ),
                Container(
                  height: 200,
                  color: Colors.amberAccent,
                  margin: EdgeInsets.only(bottom: 10),
                ),
                Container(
                  height: 200,
                  color: Colors.red,
                  margin: EdgeInsets.only(bottom: 10),
                ),
                Container(
                  height: 200,
                  color: Colors.purple,
                  margin: EdgeInsets.only(bottom: 10),
                ),
                Container(
                  height: 200,
                  color: Colors.deepPurple,
                  margin: EdgeInsets.only(bottom: 10),
                )
              ],
            ),
          ),
        ));
  }
}
