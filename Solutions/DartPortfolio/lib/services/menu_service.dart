
import 'package:angular2/core.dart';

import 'package:dart_portfolio/Link.dart';

@Injectable()
class MenuService {
  List<Link> navLinks = [
    new Link('Login', '#',''),
    new Link('Actives', '#',''),
    new Link('Potentials', '#',''),
  ];

  List<Link> menuItems = [
    new Link('About', '',''),
  ];

  List<Link> getNavLinks() => navLinks;
  List<Link> getMenuItems() => menuItems;
}
