import 'dart:convert';

class ActiveMember {
  int id = 0;
  String firstName = '';
  String lastName = '';
  String email = '';
  String phoneNumber = '';
  int year = 0;
  String hometownCity = '';
  String hometownState = '';
  String hometownHs = '';
  bool admin = false;
  List<String> majors = [];
  List<String> minors = [];
  List<String> hsActivities = [];
  List<String> univActivities = [];
  List<String> interests = [];

  //new ActiveMember(0, '', '', '', 0, '', '', '', false, [], [], [], [], []);

  ActiveMember(int id,
      String firstName,
      String lastName,
      String phoneNumber,
      int year,
      String hometownCity,
      String hometownState,
      String hometownHs,
      bool admin,
      List<String> majors,
      List<String> minors,
      List<String> hsActivities,
      List<String> univActivities,
      List<String> interests){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.year = year;
    this.hometownCity = hometownCity;
    this.hometownState = hometownState;
    this.hometownHs = hometownHs;
    this.admin = admin;
    this.majors = majors;
    this.minors = minors;
    this.hsActivities = hsActivities;
    this.univActivities = univActivities;
    this.interests = interests;
  }

  String toJson() {
    return JSON.encode([{
        'id': this.id,
        'firstName': this.firstName,
        'lastName': this.lastName,
        'phoneNumber': this.phoneNumber,
        'year': this.year,
        'hometownCity': this.hometownCity,
        'hometownState': this.hometownState,
        'hometownHs': this.hometownHs,
        'admin': this.admin,
        'majors': this.majors,
        'minors': this.minors,
        'hsActivities': this.hsActivities,
        'univActivities': this.univActivities,
        'interests': this.interests
    }]);
  }
}