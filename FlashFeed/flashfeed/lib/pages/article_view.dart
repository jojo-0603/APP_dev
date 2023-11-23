import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

class ArticleView extends StatefulWidget {
  String? bloglUrl;
  ArticleView({required this.bloglUrl});
  @override
  State<ArticleView> createState() => _ArticleViewPageState();
}

class _ArticleViewPageState extends State<ArticleView> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar:AppBar(
      title: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Flash"),
            Text(
              'Feed',
              style: TextStyle(
                  color: Colors.blueAccent, fontWeight: FontWeight.bold),
            ),
          ],
        ),),
      body:Container(
         child: WebView(
          initialUrl: widget.bloglUrl,
          javascriptMode: JavascriptMode.unrestricted,
               ),
       ),
    );
  }
}
