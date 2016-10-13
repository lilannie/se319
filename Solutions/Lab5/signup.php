<?php
include_once('php/renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>
<script type="text/javascript" src="/js/signup.js"></script>

<h2>Create Account</h2>
<div id="signupError" class="alert alert-danger" hidden="hidden">
    <strong>Sorry:</strong> That username is already taken. <a href="login.php">Log in?</a>
</div>
<div>
    <div class="form-group">
        <label for="username">Username:</label>
        <input id="username" name="username" type="text" class="form-control" autofocus>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input id="password" name="password" type="password" class="form-control">
    </div>
    <button id="signUpSubmit" class="btn btn-primary">Sign Up</button>
</div>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>