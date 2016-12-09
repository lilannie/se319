<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Code Colorizer</title>
	<meta name="description" content="A tool for Colorizing code on the web" />
	<meta name="keywords" content="tool, code, color" />
	<meta name="author" content="Zach Newton" />
	<link rel="stylesheet" href="stylesheet.css">
	<script type="text/javascript" src="parsers/htmlParser.js"></script>
	<script type="text/javascript" src="app.js"></script>
</head>
<body>

<main>
	<h2>Code Colorizer</h2>

	<div>
	Use this tool to colorize your code by adding span tags to the input. Span tags will include classes
	that can be used for coloring.
	</div>

	<form>
		<label for="language-select">Language:</label>
		<select id="language-select" name="language">
			<option value="js">JS</option>
			<option value="css">CSS</option>
			<option value="html" selected>HTML</option>
			<option value="php">PHP</option>
		</select>
		<label for="code-input">Code:</label>
		<textarea id="code-input" name="code" placeholder="Paste your code in here..." rows="10"></textarea>
		<button type="button" id="code-submit">Colorize Code</button>

		<label>Result (pretty):</label>
		<pre id="result-pretty"></pre>
		<label>Result (raw):</label>
		<pre id="result-raw"></pre>
	</form>
</main>

</body>
</html>