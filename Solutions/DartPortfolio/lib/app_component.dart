import 'package:angular2/core.dart';
import 'package:angular2/router.dart';
import 'package:dart_portfolio/components/drawer_component.dart';
import 'package:dart_portfolio/components/footer_component.dart';
import 'package:dart_portfolio/components/navbar_component.dart';

import 'package:dart_portfolio/components/main_component.dart';

@RouteConfig(const [
  const Route(path: '/', name: 'Home', component: MainComponent)
])
@Component(
    selector: 'app',
    template: '''
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  <app-navbar class="android-header mdl-layout__header mdl-layout__header--waterfall"></app-navbar>

  <app-drawer class="android-drawer mdl-layout__drawer"></app-drawer>

  <div class="android-content mdl-layout__content">
    <router-outlet></router-outlet>

    <app-footer class="android-footer mdl-mega-footer"></app-footer>
  </div>
</div>
      ''',
    directives: const [ROUTER_DIRECTIVES,DrawerComponent,FooterComponent,NavbarComponent],
    providers: const [ROUTER_PROVIDERS])
class AppComponent {
}