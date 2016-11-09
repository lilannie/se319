class PNM {
  int id = 0;
  String firstName = '';
  String lastName = '';
  String phoneNumber = '';
  int year = 0;
  String hometownCity = '';
  String hometownState = '';
  String hometownHs = '';
  double hsGpa = 0.0;
  bool reference = false;
  bool legacy = false;
  List<String> majors = [];
  List<String> minors = [];
  List<String> hsActivities = [];
  List<String> univActivities = [];
  List<String> interests = [];

  //new PNM(0, '', '', '', 0, '', '', '', 0.0, false, false, [], [], [], [], []);

  PNM(int id,
      String firstName,
      String lastName,
      String phoneNumber,
      int year,
      String hometownCity,
      String hometownState,
      String hometownHs,
      double hsGpa,
      bool reference,
      bool legacy,
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
    this.hsGpa = hsGpa;
    this.reference = reference;
    this.legacy = legacy;
    this.majors = majors;
    this.minors = minors;
    this.hsActivities = hsActivities;
    this.univActivities = univActivities;
    this.interests = interests;
  }
}