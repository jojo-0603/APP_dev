import 'package:flutter/material.dart';

class CatTile extends StatelessWidget {
  final image, cateName;

  const CatTile({super.key, this.image, this.cateName});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.only(right: 16),
      child: Stack(
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(8),
            child: Image.asset(
              image,
              width: 120,
              height: 75,
              fit: BoxFit.cover,
            ),
          ),
          Container(
            width: 120,
            height: 75,
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(8),
              color: Colors.black38,
            ),
            child: Center(
                child: Text(
              cateName,
              style: TextStyle(
                  color: Colors.white,
                  fontSize: 14,
                  fontWeight: FontWeight.w500),
            )),
          )
        ],
      ),
    );
  }

 
}
