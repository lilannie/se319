import 'package:angular2/core.dart';

import 'package:dart_portfolio/components/pnm_form_component.dart';
import 'package:dart_portfolio/components/active_form_component.dart';

@Component(
    selector: 'app-main',
    templateUrl: 'templates/main_component.html',
    directives: const[PnmFormComponent,ActiveFormComponent])
class MainComponent {}