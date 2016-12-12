var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var firebase = require('firebase');
var router = express.Router();

var db = firebase.initializeApp({
    apiKey: "AIzaSyDtQ_NKVgypWNhreYxl36a0yRMazntsq6c",
    authDomain: "myrecruiter-9d526.firebaseapp.com",
    databaseURL: "https://myrecruiter-9d526.firebaseio.com",
    storageBucket: "myrecruiter-9d526.appspot.com",
    messagingSenderId: "416574837620"
 });
var auth = db.auth();

//app.use(express.static('./public'));
//app.use(bodyParser.urlencoded({ extended: false }));

app.get('/', function (req, res) {
	var user = auth.currentUser;

	if (user) {
		console.log("User");
		console.log(user);
   		res.send("./" + "index.html");
	} else {
		console.log("Not logged in");
		res.redirect("/login");
	}
})
app.get('/login', function(req, res) {
	var user = auth.currentUser;

	if (user) {
		res.redirect("/");
	} else {
		console.log("Not logged in");
	}
})
app.post('/login', function(req, res) {
	console.log(req);
	res.redirect("/");
})
app.get('/theme', function(req, res) {
	var options = {
    	root: __dirname + '/public/',
    };
	res.sendFile("theme.html");
})

var server = app.listen(8080, function () {
   console.log("Listening at http://localhost:8080");
})