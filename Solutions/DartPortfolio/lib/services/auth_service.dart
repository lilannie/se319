
import 'package:angular2/core.dart';


@Injectable()
class AuthService {
  bool authorized = false;
  bool authorize(String username, String password){
    this.authorized = username == 'admin' && password == 'admin';
    return this.authorized;
  }
  bool getAuth(){
    return this.authorized;
  }
}