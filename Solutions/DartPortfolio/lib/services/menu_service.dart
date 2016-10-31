import 'dart:async';
import 'package:angular2/core.dart';

@Injectable()
class MenuService {
  List<String> navLinks = [
    'Phones',
    'Tablets',
    'Wear',
    'TV',
    'Auto',
    'One',
    'Play',
  ];

  List<String> menuItems = [
    '5.0 Lollipop',
    '4.4 KitKat',
    '4.3 Jelly Bean',
    'Android History',
  ];

  List<String> getNavLinks() => navLinks;
  List<String> getMenuItems() => menuItems;
}
