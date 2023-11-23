import 'dart:convert';

import 'package:flashfeed/models/article_model.dart';
import 'package:http/http.dart' as http;

class NewsData {
  List<ArticleModel> news = [];
  Future<void> getNews() async {
    String url =
        "https://newsapi.org/v2/everything?q=tesla&from=2023-10-23&sortBy=publishedAt&apiKey=f895906240c14ac098c065b2f38c79ed";
    var response = await http.get(Uri.parse(url));

    var jsonData = jsonDecode(response.body);
    if (jsonData['status'] == 'ok') {
      jsonData['articles'].forEach((element) {
        if (element['urlToImage'] != null && element['description'] != null) {
          ArticleModel articleModel = ArticleModel(
            title: element['title'],
            description: element['description'],
            url: element['url'],
            urlToImage: element['urlToImage'],
            content: element['content'],
          );
          news.add(articleModel);
        }
      });
    }
  }
}
