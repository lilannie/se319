document.addEventListener('DOMContentLoaded', function (e){
	document.getElementById('HTML-example').innerHTML = parse(document.getElementById('HTML-example').innerHTML,htmlParser);
	document.getElementById('CSS-example').innerHTML = parse(document.getElementById('CSS-example').innerHTML,cssParser);
	document.getElementById('JSON-example').innerHTML = parse(document.getElementById('JSON-example').innerHTML, jsonParser);

	document.getElementById('HTML-style-printed').innerHTML = parse(document.getElementById('HTML-style').innerHTML,cssParser);
	document.getElementById('CSS-style-printed').innerHTML = parse(document.getElementById('CSS-style').innerHTML,cssParser);
	document.getElementById('JSON-style-printed').innerHTML = parse(document.getElementById('JSON-style').innerHTML,cssParser);

	var html = "#324D5C";
	var html_tag = "#46B29D";
	var html_attr = "#E37B40";
	var html_attr_value = "#DE5B49";
	var html_comment = "#aaa";
	changeHTMLStyle(html, html_tag, html_attr, html_attr_value, html_comment);

	var css = "#324D5C";
	var css_tag_selector = "#DE5B49";
	var css_class_selector = "#E37B40";
	var css_id_selector = "#F0CA4D";
	var css_attr = "#46B29D";
	var css_comment = "#aaa";
	changeCSSStyle(css, css_tag_selector, css_class_selector, css_id_selector, css_attr, css_comment);
//TODO
	changeJSONStyle(json, key, string, number);
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
"	padding-left: 2em;"+"\n"+
"	display: list-item;"+"\n"+
"}"+"\n"+
"";
	document.getElementById('JSON-style').innerHTML = style;
	document.getElementById('JSON-style-printed').innerHTML = parse(document.getElementById('JSON-style').innerHTML,cssParser);
}