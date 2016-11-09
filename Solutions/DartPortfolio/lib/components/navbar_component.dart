
import 'package:angular2/core.dart';

import 'package:dart_portfolio/Link.dart';
import 'package:dart_portfolio/services/menu_service.dart';
@Component(
    selector: 'app-navbar',
    templateUrl: 'templates/navbar_component.html',
    providers: const [MenuService])
class NavbarComponent implements OnInit{

  final MenuService _menuService;
  NavbarComponent(this._menuService);


  List<Link> navLinks = [];
  List<Link> menuItems = [];


  void ngOnInit(){
    navLinks = _menuService.getNavLinks();
    menuItems = _menuService.getMenuItems();
  }
}