import 'package:firebase_auth/firebase_auth.dart';
import 'package:flashfeed/pages/home.dart';
import 'package:flashfeed/pages/login&Register/login.dart';
import 'package:flashfeed/pages/login&Register/login_in_register.dart';
import 'package:flutter/material.dart';

 

class AuthPage extends StatelessWidget {
  const AuthPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: StreamBuilder<User?>(
      stream: FirebaseAuth.instance.authStateChanges(),
      builder: (context, snapshot) {
        if (snapshot.hasData) {
          return MyMain();
        } else {
   
          return LoginOrRegister();
        }
      },
    ));
  }
}
