import 'package:flashfeed/pages/login&Register/login.dart';
import 'package:flashfeed/pages/login&Register/register.dart';
import 'package:flutter/material.dart';

class LoginOrRegister extends StatefulWidget {
  const LoginOrRegister({super.key});

  @override
  State<LoginOrRegister> createState() => _LoginOrRegisterPageState();
}

class _LoginOrRegisterPageState extends State<LoginOrRegister> {
  bool showLoginPage = true;
  void togglePage() {
    setState(() {
      showLoginPage = !showLoginPage;
    });
  }

  @override
  Widget build(BuildContext context) {
    if (showLoginPage) {
      return MyLoginPage(
        onTap:togglePage ,
      );
    } else {
     return MyRegisterationPage(
      onTap: togglePage,
     );
     
    }
  }
}
