import 'package:cached_network_image/cached_network_image.dart';
import 'package:flashfeed/Display_data/news_data.dart';
import 'package:flashfeed/Display_data/slider_data.dart';
import 'package:flashfeed/models/article_model.dart';
import 'package:flashfeed/models/slider_model.dart';
import 'package:flashfeed/pages/article_view.dart';
import 'package:flutter/material.dart';

class AllNews extends StatefulWidget {
  String news;
  AllNews({required this.news});

  @override
  State<AllNews> createState() => _AllNewsState();
}

class _AllNewsState extends State<AllNews> {
  List<SliderModel> sliders = [];
  List<ArticleModel> articles = [];
  void initState() {
    getSlider();
    getNews();
    super.initState();
  }

  getNews() async {
    NewsData newsclass = NewsData();
    await newsclass.getNews();
    articles = newsclass.news;
    setState(() {
      
    });
  }

  getSlider() async {
    SliderData slider = SliderData();
    await slider.getSliders();
    sliders = slider.sliders;
    setState(() {
      
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          widget.news + " NEWS",
          style: TextStyle(color: Colors.blue, fontWeight: FontWeight.bold),
        ),
        centerTitle: true,
        elevation: 0.0,
      ),
      body: Container(
        margin: EdgeInsets.symmetric(horizontal: 10.0),
        child: ListView.builder(
            shrinkWrap: true,
            physics: ClampingScrollPhysics(),
            itemCount:
                widget.news == "CURRENT" ? sliders.length : articles.length,
            itemBuilder: (context, index) {
        
              return AllNewsSection(
                  Image: widget.news == "CURRENT"
                      ? sliders[index].urlToImage!
                      : articles[index].urlToImage!,
                  desc: widget.news == "CURRENT"
                      ? sliders[index].description!
                      : articles[index].description!,
                  title: widget.news == "CURRENT"
                      ? sliders[index].title!
                      : articles[index].title!,
                  url: widget.news == "CURRENT"
                      ? sliders[index].url!
                      : articles[index].url!);
            }),
      ),
    );
  }
}

class AllNewsSection extends StatelessWidget {
  String Image, desc, title, url;
  AllNewsSection(
      {required this.Image,
      required this.desc,
      required this.title,
      required this.url});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(context,
            MaterialPageRoute(builder: (context) => ArticleView(bloglUrl: url)));
      },
      child: Container(
        child: Column(
          children: [
            ClipRRect(
              borderRadius: BorderRadius.circular(10),
              child: CachedNetworkImage(
                imageUrl: Image,
                width: MediaQuery.of(context).size.width,
                height: 200,
                fit: BoxFit.cover,
              ),
            ),
            SizedBox(
              height: 5.0,
            ),
            Text(
              title,
              maxLines: 2,
              style: TextStyle(
                  color: Colors.black,
                  fontSize: 18.0,
                  fontWeight: FontWeight.bold),
            ),
            Text(
              desc,
              maxLines: 3,
            ),
            SizedBox(
              height: 20.0,
            ),
          ],
        ),
      ),
    );
  }
}