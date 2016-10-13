<?php

class renderHelper {

    public function __construct()
    {
    }

    public function renderPageStart(){
        return <<<HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dat App</title>
    <script type="text/javascript" src="/lib/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/lib/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/lib/css/bootstrap.min.css">
    <link rel="stylesheet" href="/lib/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/stylesheet.css">
    <link rel="icon" href="/lib/favicon-html5.ico">
</head>
<body>
HTML;
    }

    public function renderContentStart(){
        return <<<HTML
<div class="container">
HTML;
    }
    public function renderContentEnd(){
        return <<<HTML
</div>
HTML;
    }
    public function renderPageEnd(){
        return <<<HTML
</body>
</html>
HTML;
    }

    public function renderNav($loggedIn,$user){
        $loginSignUp = "
                <li><a href=\"/signup.php\">Sign up</a></li>
                <li><button class=\"btn btn-primary navbar-btn\" onclick=\""."window.location='/php/login.php'\""."><i class=\"fa fa-sign-in\"></i> Log in</button></li>"
                ;
        $logout = "
                <li><p class=\"navbar-text\">Hello, ".$user."</p></li>
                <li><button class=\"btn btn-danger navbar-btn\" onclick=\""."window.location='/php/logout.php'\""."><i class=\"fa fa-sign-out\"></i> Log out</button></li>";
        $actions = $loggedIn ? $logout : $loginSignUp;

        $inbox = $loggedIn ? "<li><a href=\"/php/inbox.php\"><i class=\"fa fa-inbox\"></i> Inbox</a></li>":'';

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
            <ul class="nav navbar-nav navbar-left">
                {$inbox}
            </ul>
            <ul class="nav navbar-nav navbar-right">
                {$actions}
            </ul>
        </div>
    </div>
</nav>
HTML;

    }


    public function renderMessage($sender, $content, $date){
        return <<<HTML
<div class="panel panel-default">
    <div class="panel-heading"><h3 class="panel-title">{$sender} said</h3></div>
    <div class="panel-body">
        {$content}
    </div>
    <div class="panel-footer">{$date}</div>
</div>
HTML;
    }
}