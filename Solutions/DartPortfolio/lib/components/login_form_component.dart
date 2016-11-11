import 'package:angular2/core.dart';

import 'package:dart_portfolio/services/auth_service.dart';

@Component(
    selector: 'app-login-form',
    templateUrl: 'templates/login_form_component.html',
    providers: const [AuthService])
class LoginFormComponent implements OnInit{

  final AuthService _authService;
  LoginFormComponent(this._authService);
  String username = '';
  String password = '';
  bool authorized = false;

  void login(){
    _authService.authorize(this.username, this.password);
  }

  void ngOnInit(){
    this.authorized = _authService.getAuth();
  }
}