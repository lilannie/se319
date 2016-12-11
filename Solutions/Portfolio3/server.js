var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var firebase = require('firebase');

app.use(express.static('./public'));
app.use(bodyParser.urlencoded({ extended: false }));

app.get('/', function (req, res) {
   res.send("./" + "index.html");
})

app.get('/theme', function(req, res) {
	var options = {
    	root: __dirname + '/public/',
    };
	res.sendFile("theme.html");
})

var server = app.listen(8081, function () {
   var host = server.address().address;
   var port = server.address().port;
   
   console.log("Example app listening at http://%s:%s", host, port);
})