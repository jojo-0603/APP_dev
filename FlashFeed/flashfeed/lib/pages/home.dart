import 'dart:convert';

import 'package:cached_network_image/cached_network_image.dart';
import 'package:carousel_slider/carousel_slider.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flashfeed/Display_data/data.dart';
import 'package:flashfeed/Display_data/news_data.dart';
import 'package:flashfeed/Display_data/slider_data.dart';
import 'package:flashfeed/components/blogTile.dart';
import 'package:flashfeed/components/catTile.dart';
import 'package:flashfeed/models/article_model.dart';
import 'package:flashfeed/models/catModel.dart';
import 'package:flashfeed/models/slider_model.dart';
import 'package:flashfeed/pages/all_news.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:smooth_page_indicator/smooth_page_indicator.dart';

class MyMain extends StatefulWidget {
  @override
  State<MyMain> createState() => _MyMainPageState();
}

class _MyMainPageState extends State<MyMain> {
  List<CategoryMode> categories = [];
  List<SliderModel> sliders = [];
  List<ArticleModel> article = [];
  bool _loading = true;
  int activeIndex = 0;
  void initState() {
    categories = getCategories();
   getSlider();
    getNews();
    super.initState();
  }

  getNews() async {
    NewsData news1 = NewsData();
    await news1.getNews();
    article = news1.news;
    setState(() {
      _loading = false;
    });
  } 
  getSlider() async {
    SliderData slider = SliderData();
    await slider.getSliders();
    sliders = slider.sliders;
    
  }

  void signOut() async {
    await FirebaseAuth.instance.signOut();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
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
        ),
        actions: [IconButton(onPressed: signOut, icon: Icon(Icons.logout))],
      ),
      body: _loading
          ? Center(child: CircularProgressIndicator())
          : SingleChildScrollView(
              child: Container(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Container(
                      margin: EdgeInsets.only(left: 10),
                      height: 70,
                      child: ListView.builder(
                          shrinkWrap: true,
                          scrollDirection: Axis.horizontal,
                          itemCount: categories.length,
                          itemBuilder: (context, index) {
                            return CatTile(
                              image: categories[index].image,
                              cateName: categories[index].categoryName,
                            );
                          }),
                    ),
                    SizedBox(
                      height: 30,
                    ),
                    Padding(
                      padding: const EdgeInsets.only(left: 15.0, right: 10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text(
                            'CURRENT NEWS',
                            style: TextStyle(
                                fontSize: 20, fontWeight: FontWeight.bold),
                          ),
                          GestureDetector(
                            onTap: (){
                                            Navigator.push(context,
            MaterialPageRoute(builder: (context) => AllNews(news: "CURRENT")));
                            },
                            child: Text(
                              'View All',
                              style: TextStyle(
                                  color: Colors.blueGrey,
                                  fontSize: 16,
                                  fontWeight: FontWeight.w600),
                            ),
                          ),
                        ],
                      ),
                    ),
                    SizedBox(
                      height: 15,
                    ),
                    CarouselSlider.builder(
                        itemCount: 7,
                        itemBuilder: (context, index, realIndex) {
                          String? res = sliders[index].urlToImage;
                          String? name = sliders[index].title;
                          return buildImage(res!, index, name!);
                        },
                        options: CarouselOptions(
                            height: 200,
                            autoPlay: true,
                            enlargeCenterPage: true,
                            enlargeStrategy: CenterPageEnlargeStrategy.height,
                            onPageChanged: (index, reason) {
                              setState(() {
                                activeIndex = index;
                              });
                            })),
                    SizedBox(height: 25),
                    Center(child: buildIndicator()),
                    SizedBox(
                      height: 30,
                    ),
                    Padding(
                      padding: const EdgeInsets.only(left: 15.0, right: 10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text(
                            'RECENT NEWS',
                            style: TextStyle(
                                fontSize: 20, fontWeight: FontWeight.bold),
                          ),
                          GestureDetector(
                            onTap: (){
                              Navigator.push(context,
            MaterialPageRoute(builder: (context) => AllNews(news: "CURRENT")));
      
                            },
                            child: Text(
                              'View All',
                              style: TextStyle(
                                  color: Colors.blueGrey,
                                  fontSize: 16,
                                  fontWeight: FontWeight.w600),
                            ),
                          ),
                        ],
                      ),
                    ),
                    SizedBox(height: 25),
                    Container(
                      child: ListView.builder(
                          shrinkWrap: true,
                          physics: ClampingScrollPhysics(),
                          itemCount: article.length,
                          itemBuilder: (context, index) {
                            return BlogTile(
                                url:article[index].url! ,
                                desc: article[index].description!,
                                imagUrl: article[index].urlToImage!,
                                title: article[index].title!);
                          }),
                    )
                  ],
                ),
              ),
            ),
    );
  }

  Widget buildImage(String urlImage, int index, String Name) => Container(
        margin: EdgeInsets.symmetric(horizontal: 6),
        child: Stack(children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(20),
            child: CachedNetworkImage(
              imageUrl:urlImage,
              height: 250,
              fit: BoxFit.cover,
              width: MediaQuery.of(context).size.width,
            ),
          ),
          Container(
            height: 250,
            padding: EdgeInsets.only(left: 10),
            margin: EdgeInsets.only(top: 130),
            width: MediaQuery.of(context).size.width,
            decoration: BoxDecoration(
                color: Colors.black26,
                borderRadius: BorderRadius.only(
                    bottomLeft: Radius.circular(20),
                    bottomRight: Radius.circular(20))),
            child: Text(
              Name,
              maxLines:2,
              style: TextStyle(
                  color: Colors.white,
                  fontSize: 20,
                  fontWeight: FontWeight.w700),
            ),
          )
        ]),
      );
  Widget buildIndicator() => AnimatedSmoothIndicator(
        activeIndex: activeIndex,
        count: 7,
        effect: WormEffect(),
      );
}
