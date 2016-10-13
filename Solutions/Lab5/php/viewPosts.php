<?php
include_once('renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>
<script type="text/javascript" src="/js/posts.js"></script>
<div>
    <div class="form-group">
        <input id="postTitle" name="postTitle" type="text" class="form-control" placeholder="Title">
    </div>
    <div class="form-group">
        <input id="postContent" name="postContent" type="text" class="form-control" placeholder="Post content...">
    </div>
    <button id="postSubmit" class="btn btn-primary btn-block">Post</button>
</div>
<hr>
<div id="posts"></div>
<div id="postsError" class="alert alert-info" hidden="hidden">
    <strong>Huh:</strong> Posts did not load properly or there are no posts to display. <a href="#" onclick="getPosts()">Try again?</a>
</div>

<div class="modal fade" id="editPostModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit Post</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="editPostTitle">Title</label>
                    <input id="editPostTitle" name="editPostTitle" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="editPostContent">Post</label>
                    <input id="editPostContent" name="editPostContent" type="text" class="form-control">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button id="editPostSubmit" type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>
            </div>
        </div>
    </div>
</div>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
