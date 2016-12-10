document.addEventListener('DOMContentLoaded', function (e){
	document.getElementById('HTML-example').innerHTML = parse(document.getElementById('HTML-example').innerHTML,htmlParser);
	document.getElementById('CSS-example').innerHTML = parse(document.getElementById('CSS-example').innerHTML,cssParser);
	document.getElementById('JSON-example').innerHTML = parse(document.getElementById('JSON-example').innerHTML, jsonParser);

	document.getElementById('HTML-style-printed').innerHTML = parse(document.getElementById('HTML-style').innerHTML,cssParser);
	document.getElementById('CSS-style-printed').innerHTML = parse(document.getElementById('CSS-style').innerHTML,cssParser);
	document.getElementById('JSON-style-printed').innerHTML = parse(document.getElementById('JSON-style').innerHTML,cssParser);
});


function parse(input, parser) {
	try {
		return parser.parse(input);
	} catch (e) {

	}
	return input;
}