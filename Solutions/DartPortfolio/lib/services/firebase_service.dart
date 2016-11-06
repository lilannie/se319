import 'package:angular2/core.dart';
import 'package:dart_portfolio/entities/ActiveMember.dart';
import 'package:dart_portfolio/entities/PNM.dart';
import 'dart:async';
import 'package:http/http.dart';
import 'package:http/testing.dart';

@Injectable()
class FirebaseService {
  final Client _http;

  FirebaseService(this._http);

  bool createActive (ActiveMember active) {
    var body = active.toJson();
    _http.put('https://myrecruiter-9d526.firebaseio.com/');
    return true;
  }

  bool deleteActive (ActiveMember active) {
    return true;
  }

  bool updateActive (ActiveMember active) {
    return true;
  }

  bool getActive (ActiveMember active) {
    return true;
  }
}