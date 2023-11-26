import 'package:flashfeed/main.dart';
import 'package:flashfeed/pages/login&Register/auth.dart';
import 'package:flutter/material.dart';
import 'package:page_transition/page_transition.dart';

class ShimmerArrow extends StatefulWidget {
  @override
  State<ShimmerArrow> createState() => _ShimmerArrowState();
}

class _ShimmerArrowState extends State<ShimmerArrow>
    with SingleTickerProviderStateMixin {
  late final AnimationController animationController;

  void initState() {
    super.initState();
    animationController = AnimationController.unbounded(vsync: this)
      ..repeat(min: -0.5, max: 1.5, period: Duration(seconds: 1));
  }

  @override
  Widget build(BuildContext context) {
    return AnimatedBuilder(
        animation: animationController,
        builder: (context, child) {
          return ShaderMask(
            shaderCallback: (bounds) => LinearGradient(
                    begin: Alignment.topCenter,
                    end: Alignment.bottomCenter,
                    transform: SlideGradientTransform(
                        precent: animationController.value),
                    colors: [Colors.white10, Colors.white, Colors.white10])
                .createShader(bounds),
            child: GestureDetector(
              onTap: () {
                Navigator.push(context, PageTransition(type: PageTransitionType.bottomToTopJoined, child: AuthPage(),childCurrent:MyApp() ));
              },
              child: Column(
                children: [
                  Align(
                    heightFactor: .4,
                    child: Icon(
                      Icons.keyboard_arrow_up,
                      color: Colors.white,
                      size: 90,
                    ),
                  ),
                  Align(
                    heightFactor: .4,
                    child: Icon(
                      Icons.keyboard_arrow_up,
                      color: Colors.white,
                      size: 50,
                    ),
                  ),
                  Align(
                    heightFactor: .4,
                    child: Icon(
                      Icons.keyboard_arrow_up,
                      color: Colors.white,
                      size: 20,
                    ),
                  ),
                ],
              ),
            ),
          );
        });
  }
}

class SlideGradientTransform extends GradientTransform {
  final double precent;
  SlideGradientTransform({required this.precent});
  Matrix4? transform(Rect bounds, {TextDirection? textDirection}) {
    return Matrix4.translationValues(0, -bounds.height * precent, 0);
  }
}
