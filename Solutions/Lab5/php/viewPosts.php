<?php
include_once('renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>
<div>
    <div class="form-group">
<!--        <label for="postTitle">Title</label>-->
        <input id="postTitle" name="postTitle" type="text" class="form-control" placeholder="Title">
    </div>
    <div class="form-group">
<!--        <label for="postContent">Post</label>-->
        <input id="postContent" name="postContent" type="text" class="form-control" placeholder="Post content...">
    </div>
    <button id="postSubmit" class="btn btn-primary btn-block">Post</button>
</div>
<hr>
<div id="posts"></div>
<div id="postsError" class="alert alert-danger" hidden="hidden">
    <strong>Error:</strong> Posts did not load properly. <a href="#" onclick="getPosts()">Try again?</a>
</div>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
