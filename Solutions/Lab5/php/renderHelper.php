<?php

class renderHelper {

    public function renderPageStart(){
        return <<<HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <script type="text/javascript" src="/lib/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/lib/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/lib/css/bootstrap.min.css">
    <link rel="stylesheet" href="/lib/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/stylesheet.css">
    <link rel="icon" href="/lib/favicon-html5.ico">
    <script type="text/javascript" src="/js/signup.js"></script>
    <script type="text/javascript" src="/js/login.js"></script>
</head>
HTML;
    }

    public function renderBodyStart(){
        return <<<HTML
<body>
HTML;
    }
    public function renderBodyEnd(){
        return <<<HTML
</body>
HTML;
    }
    public function renderPageEnd(){
        return <<<HTML
</html>
HTML;
    }

    public function renderNav(){
        return <<<HTML
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header"><button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
            <a class="navbar-brand" href="/index.php">Dat App</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login.php">Log in</a></li>
                <li><a href="/signup.php">Sign up</a></li>
                <li><a href="/login.php">Log out</a></li>
            </ul>
        </div>
    </div>
</nav>
HTML;

    }


    public function renderPost($author, $content, $date){
        return <<<HTML
<div class="panel panel-default">
    <div class="panel-heading"><h3 class="panel-title">{$author}</h3> said</div>
    <div class="panel-body">
        {$content}
    </div>
    <div class="panel-footer">{$date}</div>
</div>
HTML;
    }
}