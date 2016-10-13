<?php
include_once('php/renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>

<h2>Log In</h2>
<div id="loginError" class="alert alert-danger" hidden="hidden">
    <strong>Login failed:</strong> Incorrect username or password. <a href="/signup.php">Create new account?</a>
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
    <button id="loginSubmit" class="btn btn-primary">Log In</button>
</div>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>