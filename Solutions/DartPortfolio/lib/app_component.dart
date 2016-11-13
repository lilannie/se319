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
<div class="">
  <app-navbar></app-navbar>

  <app-drawer></app-drawer>

  <main>
    <router-outlet></router-outlet>
  </main>
  <app-footer></app-footer>
</div>
      ''',
    directives: const [ROUTER_DIRECTIVES,DrawerComponent,FooterComponent,NavbarComponent],
    providers: const [ROUTER_PROVIDERS])
class AppComponent {
}