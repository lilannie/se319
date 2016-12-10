var http = require("http");
var fs = require('fs');

fs.readFile('./index.php', function(err, html) {
	if (err) {
		response.writeHead(404);
      	response.write("Not Found!");
		throw err;
	}

	http.createServer(function (request, response) {
	   // Send the HTTP header 
	   // HTTP Status: 200 : OK
	   // Content Type: text/plain
	   response.writeHead(200, {'Content-Type': 'html'});
	   
	   response.write(html);
	   // Send the response body as "Hello World"
	   response.end();
	}).listen(8081);
});


// Console will print the message
console.log('Server running at http://127.0.0.1:8081/');