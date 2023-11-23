import 'package:flashfeed/models/catModel.dart';

List<CategoryMode> getCategories() {
  List<CategoryMode> categories = [];
  CategoryMode categoryMode = new CategoryMode();

  categoryMode.categoryName = 'Business';
  categoryMode.image = 'lib/assests/business.jpg';
  categories.add(categoryMode);
  categoryMode = new CategoryMode();

  categoryMode.categoryName = 'Entertainment';
  categoryMode.image = 'lib/assests/entertainment.jpg';
  categories.add(categoryMode);
  categoryMode = new CategoryMode();

  categoryMode.categoryName = 'General';
  categoryMode.image = 'lib/assests/general.jpg';
  categories.add(categoryMode);
  categoryMode = new CategoryMode();

  categoryMode.categoryName = 'Health';
  categoryMode.image = 'lib/assests/health.jpg';
  categories.add(categoryMode);
  categoryMode = new CategoryMode();

  categoryMode.categoryName = 'Sports';
  categoryMode.image = 'lib/assests/sport.jpg';
  categories.add(categoryMode);
  categoryMode = new CategoryMode();

  return categories;
}
