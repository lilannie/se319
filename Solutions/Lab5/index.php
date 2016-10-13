<?php
include_once('php/renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>
<!-- stuff here -->
<?php if(isset($_SESSION['logged_in']) && $_SESSION['logged_in']): ?>
    <h2>Oh hi there!</h2>
    <h4>You look lost... <a href="/php/viewPosts.php">Try here!</a></h4>
<?php else: ?>
    <h2>Welcome!</h2>
    <h4>Please, feel free to <a href="/login.php">log in</a> or perhaps <a href="signup.php">sign up!</a></h4>
<?php endif; ?>
<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
