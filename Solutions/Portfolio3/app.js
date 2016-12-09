

document.addEventListener('DOMContentLoaded', function(e){


	document.getElementById('code-submit').addEventListener('click', function(e){

		displayResult(document.getElementById('code-input').value, document.getElementById('language-select').value)
	});
});

function displayResult(input,language) {
	var parser = null;
	switch(language) {
		case "js":
			parser=null;
			break;
		case "css":
			parser=null;
			break;
		case "html":
			parser = htmlParser;
			break;
		case "php":
			parser = null;
			break;
	}

	if(parser == null) return;
	document.getElementById('result-pretty').className = language;
	document.getElementById('result-pretty').innerHTML = parse(input, parser);
	document.getElementById('result-raw').innerHTML = parse(document.getElementById('result-pretty').innerHTML, htmlParser);
}

function parse(input, parser) {
	try {
		return parser.parse(input);
	} catch (e) {

	}
	return 'error';
}