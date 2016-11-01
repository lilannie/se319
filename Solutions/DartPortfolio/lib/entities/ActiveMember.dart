class ActiveMember {
  int id = 0;
  String firstName = '';
  String lastName = '';
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
}