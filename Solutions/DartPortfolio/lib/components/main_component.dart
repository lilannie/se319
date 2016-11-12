import 'package:angular2/core.dart';

import 'package:dart_portfolio/components/pnm_form_component.dart';
import 'package:dart_portfolio/components/active_form_component.dart';
import 'package:dart_portfolio/components/login_form_component.dart';

import 'package:dart_portfolio/services/auth_service.dart';

@Component(
    selector: 'app-main',
    templateUrl: 'templates/main_component.html',
    directives: const[PnmFormComponent,ActiveFormComponent, LoginFormComponent],
    providers: const[AuthService])
class MainComponent implements OnInit{

  final AuthService _authService;
  MainComponent(this._authService);
  bool authorized = false;

  void ngOnInit(){
    authorized = _authService.getAuth();
  }
}