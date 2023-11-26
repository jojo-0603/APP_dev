import 'package:cached_network_image/cached_network_image.dart';
import 'package:flashfeed/Display_data/showcat_data.dart';
import 'package:flashfeed/models/show_cat.dart';
import 'package:flashfeed/pages/article_view.dart';
import 'package:flutter/material.dart';

class CatNews extends StatefulWidget {
  String catname;
  CatNews({required this.catname});
  @override
  State<CatNews> createState() => _CatNewsState();
}

class _CatNewsState extends State<CatNews> {
   List<ShowCatModel> cate = [];
   void initState() {
  
    getNews();
    super.initState();
  }
   bool _loading = true;
 getNews() async {
    ShowCatNews news1 = ShowCatNews();
    await news1.getCatNews(widget.catname.toLowerCase());
    cate = news1.cat;
    setState(() {
      _loading = false;
    });
  } 


  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Text(
              widget.catname,
              style: TextStyle(
                  color: Colors.blueAccent, fontWeight: FontWeight.bold),
            ),
          ],
        ),
      ),
      body:   Container(
        margin: EdgeInsets.symmetric(horizontal:10 ),
                      child: ListView.builder(
                          shrinkWrap: true,
                          physics: ClampingScrollPhysics(),
                          itemCount: cate.length,
                          itemBuilder: (context, index) {
                            return ShowCat(
                               Image:cate[index].urlToImage! ,
                               desc:cate[index].description!,
                               title: cate[index].title!,
                               url: cate[index].url!,
                                );
                          }),
                    )
    );
  }
}

class ShowCat extends StatelessWidget {
  final String Image, desc, title,url;
  const ShowCat({super.key,required this.Image,required this.desc,required this.title,required this.url});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: (){
        Navigator.push(context,
            MaterialPageRoute(builder: (context) =>ArticleView(bloglUrl: url) ));
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
            SizedBox(height: 5),
            Text(title,
            maxLines: 2,
            style: TextStyle(color: Colors.black,fontSize: 10,fontWeight: FontWeight.w700),),
            Text(desc,maxLines: 3,),
            SizedBox(height: 15),
            ],
        ),
      ),
    );
  }
}
