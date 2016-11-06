import 'package:angular2/core.dart';

import 'package:dart_portfolio/entities/ActiveMember.dart';

import 'package:dart_portfolio/services/active_service.dart';

@Component(
    selector: 'app-active-form',
    templateUrl: 'templates/active_form_component.html',
    providers: const [ActiveService])
class ActiveFormComponent implements OnInit{

  final ActiveService _activeService;
  ActiveFormComponent(this._activeService);

  List<ActiveMember> activeList = [];

  ActiveMember form_active = new ActiveMember(0, '', '', '', 0, '', '', '', false, [], [], [], [], []);
  String form_major = '';
  String form_minor = '';
  String form_hs_activity = '';
  String form_univ_activity = '';
  String form_interest = '';

  void addMajor(){
    if(this.form_major != ''){
      form_active.majors.add(this.form_major);
    }
    this.form_major = '';
  }
  void addMinor(){
    if(this.form_minor != ''){
      form_active.minors.add(this.form_minor);
    }
    this.form_minor = '';
  }
  void addHsActivity(){
    if(this.form_hs_activity != ''){
      form_active.hsActivities.add(this.form_hs_activity);
    }
    this.form_hs_activity = '';
  }
  void addUnivActivity(){
    if(this.form_univ_activity != ''){
      form_active.univActivities.add(this.form_univ_activity);
    }
    this.form_univ_activity = '';
  }
  void addInterest(){
    if(this.form_interest != ''){
      form_active.interests.add(this.form_interest);
    }
    this.form_interest = '';
  }

  void submitFormMember(){
    _activeService.addActive(this.form_active);
    //reset
    form_active = new ActiveMember(0, '', '', '', 0, '', '', '', false, [], [], [], [], []);
    form_major = '';
    form_minor = '';
    form_hs_activity = '';
    form_univ_activity = '';
    form_interest = '';
  }

  void ngOnInit(){
    //activeList = _activeService.getActives();
  }
}