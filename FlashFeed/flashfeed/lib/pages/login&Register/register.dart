import 'package:firebase_auth/firebase_auth.dart';
import 'package:flashfeed/components/UI_comp.dart';
import 'package:flashfeed/components/buttons.dart';
import 'package:flashfeed/components/tile.dart';
import 'package:flashfeed/pages/login&Register/services.dart';

import 'package:flutter/material.dart';

class MyRegisterationPage extends StatefulWidget {
  final Function()? onTap;
  const MyRegisterationPage({super.key, required this.onTap});
  @override
  State<MyRegisterationPage> createState() => _MyRegisterationPageState();
}

class _MyRegisterationPageState extends State<MyRegisterationPage>
    with TickerProviderStateMixin {
  final usernameController = TextEditingController();
  final passwordController = TextEditingController();
  final confirmPasswordController = TextEditingController();

  void displayerrorpass(String mssg) {
    showDialog(
        context: context,
        builder: (context) {
          return AlertDialog(
            title: Text(mssg),
          );
        });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: SafeArea(
      child: Container(
        width: double.infinity,
        height: double.infinity,
        decoration: const BoxDecoration(
            image: DecorationImage(
                image: AssetImage('lib/assests/login.jpg'),
                colorFilter: ColorFilter.mode(Colors.grey, BlendMode.hardLight),
                fit: BoxFit.fill)),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            children: [
              SizedBox(height: 90),
              Text("REGISTER",
                  style: TextStyle(fontSize: 50, fontWeight: FontWeight.bold)),
              SizedBox(height: 10),
              MyTextField(
                controller: usernameController,
                hintText: 'Username',
                obscureText: false,
              ),
                MyTextField(
                controller: passwordController,
                hintText: 'Password',
                obscureText: false,
              ),
              MyTextField(
                controller: confirmPasswordController,
                hintText: 'Confirm Password',
                obscureText: false,
              ),
            
              SizedBox(height: 30),
              CustomButton(text: 'Register', onTap: signUserUp),
              SizedBox(height: 20),
              Row(
                children: [
                  Expanded(
                    child: Divider(
                      thickness: 0.65,
                      color: Colors.grey,
                    ),
                  ),
                  Text(
                    "Or Login With",
                    style: TextStyle(color: Colors.grey),
                  ),
                  Expanded(
                    child: Divider(
                      thickness: 0.65,
                      color: Colors.grey,
                    ),
                  ),
                ],
              ),
              SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CustomTile(
                    onTap:()=>FirebaseService.signInwithGoogle(context),
                    imagePath: 'lib/assests/devicon_google.png'),
                  SizedBox(width: 40),
                  CustomTile(
                    onTap: ()=>{},
                    imagePath: 'lib/assests/devicon_facebook.png'),
                  SizedBox(width: 40),
                  CustomTile(
                    onTap: ()=>{},
                    imagePath: 'lib/assests/bi_github.png')
                ],
              ),
              SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    'Already a Reader ? ',
                    style: TextStyle(color: Colors.grey),
                  ),
                  SizedBox(width: 4),
                  GestureDetector(
                    onTap: widget.onTap,
                    child: Text('Login Now! ',
                        style: TextStyle(color: Colors.blueAccent)),
                  ),
                ],
              )
            ],
          ),
        ),
      ),
    ));
  }

  signUserUp() async {
    try {
      if (confirmPasswordController.text == passwordController.text) {
        final credential =
            await FirebaseAuth.instance.createUserWithEmailAndPassword(
          email: usernameController.text,
          password: passwordController.text,
        );
      } else {
        showDialog(
        context: context,
        builder: (context) {
          return AlertDialog(
            title: Text("Confirm Password and Password Do not match"),
          );
        });
      }
    } on FirebaseAuthException catch (e) {
      displayerrorpass(e.code);
    }
  }
}
