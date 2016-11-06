
import 'package:angular2/core.dart';

import 'package:dart_portfolio/entities/ActiveMember.dart';
import 'package:dart_portfolio/services/firebase_service.dart';


@Injectable()
class ActiveService {
  Map<int, ActiveMember> actives;

  ActiveService () {
    this.actives = new Map<int, ActiveMember>();
  }

  Map<int, ActiveMember> getActives() => this.actives;

  bool addActive(ActiveMember active){
    return true;
  }

  bool removeActive(ActiveMember active){
    return true;
  }

  bool ediActive (ActiveMember active) {
    return true;
  }

  ActiveMember getActive (int id) {
    return null;
  }
}