<?php
include_once('php/renderHelper.php');

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderBodyStart() ?>
<?= $renderHelper->renderNav() ?>
<div class="container">
    <h2>Create Account</h2>
    <div>
        <div class="form-inline">
            <label for="username">Username:</label>
            <input id="username" name="username" type="text" class="form-control">
        </div>
        <div class="form-inline">
            <label for="password">Password:</label>
            <input id="password" name="password" type="password" class="form-control">
        </div>
        <button id="signUpSubmit" class="btn btn-primary">Sign Up</button>
    </div>
</div>
<?= $renderHelper->renderBodyEnd() ?>
<?= $renderHelper->renderPageEnd() ?>