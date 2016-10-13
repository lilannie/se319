<?php
include_once('renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>

<div id="posts"></div>
<div id="postsError" class="alert alert-danger" hidden="hidden">
    <strong>Error:</strong> Posts did not load properly. <a href="#" onclick="getPosts()">Try again?</a>
</div>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
