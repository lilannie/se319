document.addEventListener('DOMContentLoaded', function (e){
	document.getElementById('HTML-example').innerHTML = parse(document.getElementById('HTML-example').innerHTML,htmlParser);
	document.getElementById('CSS-example').innerHTML = parse(document.getElementById('CSS-example').innerHTML,cssParser);
	document.getElementById('JSON-example').innerHTML = parse(document.getElementById('JSON-example').innerHTML, jsonParser);

	document.getElementById('HTML-style-printed').innerHTML = parse(document.getElementById('HTML-style').innerHTML,cssParser);
	document.getElementById('CSS-style-printed').innerHTML = parse(document.getElementById('CSS-style').innerHTML,cssParser);
	document.getElementById('JSON-style-printed').innerHTML = parse(document.getElementById('JSON-style').innerHTML,cssParser);

	var html_color_inputs = document.getElementsByClassName('html-color-input');
	for (var i = 0; i < html_color_inputs.length; i++)
	{
		html_color_inputs[i].addEventListener('change', function(e){
			var html = "#"+document.getElementById('html-main-color').value;
			var html_tag ="#"+ document.getElementById('html-tag-color').value;
			var html_attr = "#"+document.getElementById('html-attr-color').value;
			var html_attr_value = "#"+document.getElementById('html-attr-value-color').value;
			var html_comment = "#"+document.getElementById('html-comment-color').value;
			changeHTMLStyle(html, html_tag, html_attr, html_attr_value, html_comment);
		});
	}
	var css_color_inputs = document.getElementsByClassName('css-color-input');
	for (i = 0; i < css_color_inputs.length; i++)
	{
		css_color_inputs[i].addEventListener('change', function(e){
			var css = "#"+document.getElementById('css-main-color').value;
			var css_tag_selector = "#"+document.getElementById('css-selector-tag-color').value;
			var css_class_selector = "#"+document.getElementById('css-selector-class-color').value;
			var css_id_selector = "#"+document.getElementById('css-selector-id-color').value;
			var css_attr = "#"+document.getElementById('css-attr-color').value;
			var css_comment = "#"+document.getElementById('css-comment-color').value;
			changeCSSStyle(css, css_tag_selector, css_class_selector, css_id_selector, css_attr, css_comment);
		});
	}
	var json_color_inputs = document.getElementsByClassName('json-color-input');
	for (i = 0; i < json_color_inputs.length; i++)
	{
		json_color_inputs[i].addEventListener('change', function(e){
			var json = "#"+document.getElementById('json-main-color').value;
			var json_key = "#"+document.getElementById('json-key-color').value;
			var json_string = "#"+document.getElementById('json-string-color').value;
			var json_number = "#"+document.getElementById('json-number-color').value;
			changeJSONStyle(json, json_key, json_string, json_number);
		});
	}


	var html = "#"+document.getElementById('html-main-color').value;
	var html_tag ="#"+ document.getElementById('html-tag-color').value;
	var html_attr = "#"+document.getElementById('html-attr-color').value;
	var html_attr_value = "#"+document.getElementById('html-attr-value-color').value;
	var html_comment = "#"+document.getElementById('html-comment-color').value;
	changeHTMLStyle(html, html_tag, html_attr, html_attr_value, html_comment);

	var css = "#"+document.getElementById('css-main-color').value;
	var css_tag_selector = "#"+document.getElementById('css-selector-tag-color').value;
	var css_class_selector = "#"+document.getElementById('css-selector-class-color').value;
	var css_id_selector = "#"+document.getElementById('css-selector-id-color').value;
	var css_attr = "#"+document.getElementById('css-attr-color').value;
	var css_comment = "#"+document.getElementById('css-comment-color').value;
	changeCSSStyle(css, css_tag_selector, css_class_selector, css_id_selector, css_attr, css_comment);

	var json = "#"+document.getElementById('json-main-color').value;
	var json_key = "#"+document.getElementById('json-key-color').value;
	var json_string = "#"+document.getElementById('json-string-color').value;
	var json_number = "#"+document.getElementById('json-number-color').value;
	changeJSONStyle(json, json_key, json_string, json_number);
});


function parse(input, parser) {
	try {
		return parser.parse(input);
	} catch (e) {

	}
	return input;
}

function changeHTMLStyle(html,tag,attr,attr_value,comment){
	var style = ""+
".html {"+"\n"+
"	color: " + html + ";"+"\n"+
"}"+"\n"+
".html .html-tag {"+"\n"+
"	color: " + tag + ";"+"\n"+
"}"+"\n"+
".html .html-attr {"+"\n"+
"	color: " + attr + ";"+"\n"+
"}"+"\n"+
".html .html-attr-value {"+"\n"+
"	color: " + attr_value + ";"+"\n"+
"}"+"\n"+
".html .html-comment {"+"\n"+
"	color: " + comment + ";"+"\n"+
"}"+"\n"+
"";
	document.getElementById('HTML-style').innerHTML = style;
	document.getElementById('HTML-style-printed').innerHTML = parse(document.getElementById('HTML-style').innerHTML,cssParser);
}

function changeCSSStyle(css, tag_selector, class_selector, id_selector, attr, comment){
	var style = ""+
".css {"+"\n"+
"	color: "+css+";"+"\n"+
"}"+"\n"+
".css .css-selector-tag {"+"\n"+
"	color: "+tag_selector+";"+"\n"+
"}"+"\n"+
".css .css-selector-class {"+"\n"+
"	color: "+class_selector+";"+"\n"+
"}"+"\n"+
".css .css-selector-id {"+"\n"+
"	color: "+id_selector+";"+"\n"+
"}"+"\n"+
".css .css-attr {"+"\n"+
"	color: "+attr+";"+"\n"+
"}"+"\n"+
".css .css-comment {"+"\n"+
"	color: "+comment+";"+"\n"+
"}"+"\n"+
"";
	document.getElementById('CSS-style').innerHTML = style;
	document.getElementById('CSS-style-printed').innerHTML = parse(document.getElementById('CSS-style').innerHTML,cssParser);
}

function changeJSONStyle(json, key, string, number){
	var style = ""+
".json {"+"\n"+
"	color: "+json+";"+"\n"+
"}"+"\n"+
".json .json-key {"+"\n"+
"	color: "+key+";"+"\n"+
"}"+"\n"+
".json .json-string {"+"\n"+
"	color: "+string+";"+"\n"+
"}"+"\n"+
".json .json-number {"+"\n"+
"	color: "+number+";"+"\n"+
"}"+"\n"+
".json-object {"+"\n"+
"	list-style: none;"+"\n"+
"}"+"\n"+
".json-attribute,"+"\n"+
".json-array > .json-array-value{"+"\n"+
"	padding-left: 1em;"+"\n"+
"	display: list-item;"+"\n"+
"}"+"\n"+
"";
	document.getElementById('JSON-style').innerHTML = style;
	document.getElementById('JSON-style-printed').innerHTML = parse(document.getElementById('JSON-style').innerHTML,cssParser);
}