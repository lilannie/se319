library.controller('libraryController', function($scope, $rootScope){
	$scope.populateLibrary = function (){
		$rootScope.books = [];
		var categories = ['Art', 'Science', 'Sport', 'Literature'];
		for(var r = 0; r < 5; r++){
			var category = categories[Math.floor(Math.random()*4)];
			$rootScope.books.push(new Book('R'+r, category, true));
		}
		for(var o = 0; o < 20; o++){
			category = categories[Math.floor(Math.random()*4)];
			$rootScope.books.push(new Book('O'+o, category, false));
		}
	};
});
library.controller('loginController', function ($scope, $rootScope, $location){
	$scope.username = '';
	$scope.password = '';
	$rootScope.authorization = '';
	$rootScope.username = '';
	$scope.authorize = function(){
		if ($scope.username == 'admin' && $scope.password == 'admin')
		{
			$rootScope.authorization = 'librarian';
			$location.path('librarian');
			$rootScope.username = 'admin';
		}
		else if ($scope.username.substr(0,1) == 'U')
		{
			$rootScope.authorization = 'undergrad';
			$location.path('undergrad');
			$rootScope.username = $scope.username;
		}
		else
		{
			alert('Invalid Login Credentials');
		}
	}
});
library.controller('librarianController', function ($scope, $rootScope){
	$scope.auth = $rootScope.authorization;
	$scope.books = $rootScope.books;

	$scope.form_bookName = '';
	$scope.form_shelf = '';
	$scope.form_reference = false;
	$scope.inspecting = null;

	$scope.showAddForm = function(){

		$scope.form_bookName = '';
		$scope.form_shelf = '';
		$scope.form_reference = false;
	};
	$scope.addBook = function(){
		$rootScope.books.push(new Book($scope.form_bookName, $scope.form_shelf, $scope.form_reference));
		$scope.showAddForm = false;

		$scope.form_bookName = '';
		$scope.form_shelf = '';
		$scope.form_reference = false;
	};
	$scope.inspect = function(book){
		$scope.inspecting = book;
	};

});
library.controller('undergradController', function ($scope, $rootScope){
	$scope.auth = $rootScope.authorization;
	$scope.books = $rootScope.books;

	$scope.inspecting = null;
	$scope.inspect = function(book){
		$scope.inspecting = book;
	};
	$scope.checkUserCheckouts = function(){
		var count = 0;
		for (var i = 0; i < $rootScope.books.length; i++){
			if($rootScope.books[i].borrowedBy == $rootScope.username){
				count++;
			}
		}
		return count < 2;
	};
});


function Book(nam, cat, typ){
	this.type = typ == false ? 'ordinary' : 'reference';
	this.name = nam;
	this.category = cat;
	this.borrowedBy = '';
	this.presence = 1;
}
Book.prototype.checkout = function(user){
	if(this.type != 'reference')
	{
		this.presence = 0;
		this.borrowedBy = user;
	}
};
Book.prototype.return = function(){
	if(this.type != 'reference')
	{
		this.presence = 1;
		this.borrowedBy = '';
	}
};