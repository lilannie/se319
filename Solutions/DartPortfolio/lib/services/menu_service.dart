
import 'package:angular2/core.dart';

import 'package:dart_portfolio/Link.dart';

@Injectable()
class MenuService {
  List<Link> navLinks = [
    new Link('Phone', '#',''),
    new Link('Tablets', '#',''),
    new Link('Wear', '#',''),
    new Link('TV', '#',''),
    new Link('Auto', '#',''),
    new Link('One', '#',''),
    new Link('Play', '#','')
  ];

  List<Link> menuItems = [
    new Link('5.0 Lollipop', '',''),
    new Link('4.4 KitKat', '',''),
    new Link('4.3 Jelly Bean', '',''),
    new Link('Android History', '','')
  ];

  List<Link> getNavLinks() => navLinks;
  List<Link> getMenuItems() => menuItems;
}
