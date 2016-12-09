

document.addEventListener('DOMContentLoaded', function(e){


	document.getElementById('code-submit').addEventListener('click', function(e){

		parser = eval(parserSource);

		displayResult(document.getElementById('code-input').value, document.getElementById('language-select').value, parser)
	});
});

function displayResult(input,language, parser) {
	console.log(input);
	document.getElementById('result').innerHTML = parse(input, parser);
}

function parse(input, parser) {
	try {
		return parser.parse(input);
	} catch (e) {

	}
	return 'error';
}