

document.addEventListener('DOMContentLoaded', function(e){


	document.getElementById('code-input').addEventListener('input', function(e){

		displayResult(document.getElementById('code-input').value, document.getElementById('language-select').value)
	});
	document.getElementById('language-select').addEventListener('change', function(e){

		displayResult(document.getElementById('code-input').value, document.getElementById('language-select').value)
	});
});

function displayResult(input,language) {
	var parser = null;
	switch(language) {
		case "js":
			parser=jsParser;
			break;
		case "css":
			parser=cssParser;
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