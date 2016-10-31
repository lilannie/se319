
import 'package:angular2/core.dart';

import 'package:dart_portfolio/Link.dart';
import 'package:dart_portfolio/services/menu_service.dart';
@Component(
    selector: 'app-drawer',
    templateUrl: 'templates/drawer_component.html',
    providers: const [MenuService])
class DrawerComponent implements OnInit{

  final MenuService _menuService;
  DrawerComponent(this._menuService);


  List<Link> navLinks = [];
  List<Link> menuItems = [];

  void ngOnInit(){
    navLinks = _menuService.getNavLinks();
    menuItems =  _menuService.getMenuItems();
  }
}