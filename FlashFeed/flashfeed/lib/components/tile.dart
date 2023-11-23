
import 'package:flutter/material.dart';

class CustomTile extends StatelessWidget {
  final String imagePath;
   final Function()? onTap;
  
 const  CustomTile({super.key,required this.imagePath,required this.onTap});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child: Container(
        padding: EdgeInsets.all(15),
        decoration: BoxDecoration(
          border: Border.all(color: Colors.black12.withOpacity(0.7)),
          borderRadius: BorderRadius.circular(15),
          color: Color.fromARGB(255, 228, 221, 221)
        ),
        child: Image.asset(
          imagePath,
          height: 40,
          
        ),
      ),
    );
  }
}