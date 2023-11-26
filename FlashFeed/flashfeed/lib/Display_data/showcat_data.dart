import 'package:flashfeed/models/show_cat.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
class ShowCatNews {
  List<ShowCatModel> cat = [];
  Future<void> getCatNews(String category) async {
    String url ="https://newsapi.org/v2/top-headlines?country=us&category=$category&apiKey=f895906240c14ac098c065b2f38c79ed";
    var response = await http.get(Uri.parse(url));

    var jsonData = jsonDecode(response.body);
    if (jsonData['status'] == 'ok') {
      jsonData['articles'].forEach((element) {
        if (element['urlToImage'] != null && element['description'] != null) {
          ShowCatModel catModel = ShowCatModel(
            title: element['title'],
            description: element['description'],
            url: element['url'],
            urlToImage: element['urlToImage'],
            content: element['content'],
          );
          cat.add(catModel);
        }
      });
       }
  }
}