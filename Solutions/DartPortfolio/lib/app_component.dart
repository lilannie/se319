import 'package:angular2/core.dart';
import 'package:angular2_quickstart/navbar_component.dart';
import 'package:angular2_quickstart/drawer_component.dart';
import 'package:angular2_quickstart/content_component.dart';
import 'package:angular2_quickstart/footer_component.dart';
@Component(
    selector: 'my-app',
    template: '''
    <navbar></navbar>

    <drawer></drawer>

    <content></content>

    <custom-footer></custom-footer>
    ''',
    directives: const [NavbarComponent,DrawerComponent,ContentComponent,FooterComponent])
class AppComponent {}