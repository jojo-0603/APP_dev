import 'package:flashfeed/pages/home.dart';
import 'package:flashfeed/pages/login&Register/auth.dart';
import 'package:flashfeed/pages/login&Register/login.dart';
import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'firebase_options.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'FlashFeed',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

 

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Container(
            width: double.infinity,
            height: double.infinity,
            decoration: const BoxDecoration(
              
                image: DecorationImage(
                  opacity: 0.7,
                    image: AssetImage('lib/assests/splashscreen.jpg'),
                    fit: BoxFit.fill,
                    )),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [Center(
                child: Text("      Welcome News Reader\nLets Get The Reading Started",style: TextStyle(color: Colors.black,fontSize: 30,fontWeight:FontWeight.bold
                
                ),),
              ),
              SizedBox(height: 30),
                Container(
                  width: 300,
                  height: 100,
                  child: ElevatedButton(
                    
                      onPressed: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => AuthPage(), // put authPage() here
                          ),
                        );
                      },
                      child: Text("Lets Go",style: TextStyle(color: Colors.black87,fontSize: 25,fontWeight: FontWeight.w800
                      ))),
                ),
              ],
            )));

    // This trailing comma makes auto-formatting nicer for build methods.
  }
}
