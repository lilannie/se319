
import 'package:angular2/core.dart';

import 'package:dart_portfolio/entities/PNM.dart';

@Injectable()
class PnmService {
  Map<int, PNM> pnms;

  PnmService() {
    this.pnms = new Map<int, PNM>();
  }

  Map<int, PNM> getPnms() => this.pnms;

  bool addPnm(PNM pnm){
    return true;
  }
  bool removePnm(PNM pnm){
    return true;
  }
}