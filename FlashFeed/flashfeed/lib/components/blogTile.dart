import 'package:cached_network_image/cached_network_image.dart';
import 'package:flashfeed/pages/article_view.dart';
import 'package:flutter/material.dart';

class BlogTile extends StatelessWidget {
  final String imagUrl, title, desc, url;
  BlogTile(
      {required this.desc,
      required this.imagUrl,
      required this.title,
      required this.url});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(
            context,
            MaterialPageRoute(
                builder: (context) => ArticleView(bloglUrl: url)));
      },
      child: Container(
        margin: EdgeInsets.only(bottom: 10),
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 10),
          child: Material(
            elevation: 3.0,
            borderRadius: BorderRadius.circular(10),
            child: Padding(
              padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 10),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Container(
                    child: ClipRRect(
                        borderRadius: BorderRadius.circular(15),
                        child: CachedNetworkImage(
                          imageUrl: imagUrl,
                          height: 100,
                          width: 100,
                          fit: BoxFit.cover,
                        )),
                  ),
                  SizedBox(width: 10),
                  Column(
                    children: [
                      Container(
                        width: MediaQuery.of(context).size.width / 1.59,
                        child: Text(
                          title,
                          maxLines: 2,
                          style: TextStyle(
                              color: Colors.black,
                              fontSize: 14,
                              fontWeight: FontWeight.w900),
                        ),
                      ),
                      SizedBox(height: 10),
                      Container(
                        width: MediaQuery.of(context).size.width / 1.59,
                        child: Text(
                          desc,
                          maxLines: 4,
                          style: TextStyle(
                              color: Colors.grey,
                              fontSize: 10,
                              fontWeight: FontWeight.w800),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ),
        ),
      ),
    );
  }
}
