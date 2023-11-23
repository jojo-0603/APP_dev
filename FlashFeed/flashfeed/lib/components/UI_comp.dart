import 'package:flutter/material.dart';

class MyTextField extends StatelessWidget {
  final controller;
  final String hintText;
  final bool obscureText;

  const MyTextField({super.key,
  required this.controller,
  required this.hintText,
  required this.obscureText,});

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal:25,vertical: 10),
      child: TextField(
        controller: controller,
        obscureText: obscureText,
        decoration: InputDecoration(
          enabledBorder: OutlineInputBorder(
            borderRadius: BorderRadius.circular(20),
              borderSide:
                  BorderSide(color: Colors.black87, style: BorderStyle.solid)),
          focusedBorder: OutlineInputBorder(
              borderSide: BorderSide(
                  color: Colors.blueGrey, width: 2, style: BorderStyle.solid)),
          fillColor: Colors.white,
          filled: true,
          hintText: hintText
        ),
      ),
    );
  }
}
