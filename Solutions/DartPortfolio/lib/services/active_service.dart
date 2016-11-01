
import 'package:angular2/core.dart';

import 'package:dart_portfolio/entities/ActiveMember.dart';

@Injectable()
class ActiveService {
  List<ActiveMember> actives = [
    new ActiveMember(0, 'Filippa', 'Spiros', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(1, 'Dora', 'Michel', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(2, 'Efimia', 'Floros', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(3, 'Natasa', 'Xanthopoulos', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(4, 'Elene', 'Iordanou', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(5, 'Pelagia', 'Pachis', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(6, 'Marina', 'Giannopoulos', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(7, 'Kyriake', 'Kokinos', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(8, 'Agathe', 'Michelakos', '', 0, '', '', '', false, [], [], [], [], []),
    new ActiveMember(9, 'Efthymia', 'Katsaros', '', 0, '', '', '', false, [], [], [], [], []),
  ];

  List<ActiveMember> getActives() => actives;
}