library.config(function ($routeProvider) {
	$routeProvider.when('/login',{
		controller: 'loginController',
		templateUrl: 'login.html'
	});
	$routeProvider.when('/librarian',{
		controller: 'librarianController',
		templateUrl: 'librarian.html'
	});
	$routeProvider.when('/undergrad',{
		controller: 'undergradController',
		templateUrl: 'undergrad.html'
	});
});