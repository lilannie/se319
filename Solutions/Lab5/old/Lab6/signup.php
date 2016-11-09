<?php
include_once('php/renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderIndexPageStart() ?>
<?= $renderHelper->renderIndexNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>
<script type="text/javascript" src="./js/signup.js"></script>

<h2>Create Account</h2>
<div id="signupError" class="alert alert-danger" hidden="hidden">
    <strong>Sorry:</strong> Error with Signing Up. <a href="login.php">Log in?</a>
</div>
<div>
    <div class="form-group">
        <label for="username">Username:</label>
        <input id="username" name="username" type="text" class="form-control" autofocus required>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input id="password" name="password" type="password" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="passwordConfirm">Confirm Password:</label>
        <input id="passwordConfirm" name="passwordConfirm" type="password" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="email">Email:</label>
        <input id="email" name="email" type="text" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="phone">
            Phone Number:
            xxx-­‐xxx-­‐xxxx or xxxxxxxxxx</label>
        <input id="phone" name="phone" type="text" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="lib">Are you a librarian?</label>
        <input id="lib" name="lib" type="checkbox" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="first">First Name:</label>
        <input id="first" name="first" type="text" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="last">Last Name:</label>
        <input id="last" name="last" type="text" class="form-control" required>
    </div>

    <button id="signUpSubmit" class="btn btn-primary">Sign Up</button>
</div>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>