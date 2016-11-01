import 'package:angular2/core.dart';

import 'package:dart_portfolio/entities/PNM.dart';

import 'package:dart_portfolio/services/pnm_service.dart';

@Component(
    selector: 'app-pnm-form',
    templateUrl: 'templates/pnm_form_component.html',
    providers: const [PnmService])
class PnmFormComponent implements OnInit {

  final PnmService _pnmService;
  PnmFormComponent(this._pnmService);

  List<PNM> pnmList = [];

  PNM form_pnm = new PNM(0, '', '', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []);
  String form_major = '';
  String form_minor = '';
  String form_hs_activity = '';
  String form_univ_activity = '';
  String form_interest = '';

  void addMajor(){
    if(this.form_major != ''){
      form_pnm.majors.add(this.form_major);
    }
    this.form_major = '';
  }
  void addMinor(){
    if(this.form_minor != ''){
      form_pnm.minors.add(this.form_minor);
    }
    this.form_minor = '';
  }
  void addHsActivity(){
    if(this.form_hs_activity != ''){
      form_pnm.hsActivities.add(this.form_hs_activity);
    }
    this.form_hs_activity = '';
  }
  void addUnivActivity(){
    if(this.form_univ_activity != ''){
      form_pnm.univActivities.add(this.form_univ_activity);
    }
    this.form_univ_activity = '';
  }
  void addInterest(){
    if(this.form_interest != ''){
      form_pnm.interests.add(this.form_interest);
    }
    this.form_interest = '';
  }

  void submitActiveMember(){

  }

  void ngOnInit(){
    pnmList = _pnmService.getPnms();
  }
}