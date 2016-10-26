import 'package:angular2/core.dart';
import 'package:angular2_quickstart/components/navbar_component.dart';
import 'package:angular2_quickstart/components/drawer_component.dart';
import 'package:angular2_quickstart/components/content_component.dart';
import 'package:angular2_quickstart/components/footer_component.dart';
@Component(
    selector: 'my-app',
    template: '''
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  <app-navbar class="android-header mdl-layout__header mdl-layout__header--waterfall"></app-navbar>

  <app-drawer class="android-drawer mdl-layout__drawer"></app-drawer>

  <div class="android-content mdl-layout__content">
    <app-content></app-content>

    <app-footer class="android-footer mdl-mega-footer"></app-footer>
  </div>
</div>
''',
    directives: const [NavbarComponent,DrawerComponent,ContentComponent,FooterComponent])
class AppComponent {}