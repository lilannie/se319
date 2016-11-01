
import 'package:angular2/core.dart';

import 'package:dart_portfolio/entities/PNM.dart';

@Injectable()
class PnmService {
  List<PNM> pnms = [
    new PNM(0, 'Becky', 'Smith', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []),
    new PNM(1, 'Nydia', 'Pavoni', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []),
    new PNM(2, 'Encarna', 'Owen', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []),
    new PNM(3, 'Haukea', 'Piatek', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []),
    new PNM(4, 'Mpho', 'Michaud', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []),
    new PNM(5, 'Micaela', 'Chan', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []),
    new PNM(6, 'Fakhriyya', 'Nazario', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []),
  ];

  List<PNM> getPnms() => pnms;
}