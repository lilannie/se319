<?php
session_start();
include_once('renderHelper.php');
$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>
<script type="text/javascript" src="/js/message.js"></script>

<?php
$file = fopen("../database/users.txt","r");
$users=[];
while (! feof($file))
{
    $line = explode(":",trim(fgets($file)));
    if($line[0] != '' && $line[0] != $_SESSION['username'])
        $users[] = $line[0];
}
fclose($file);
?>
<div>
    <div class="form-group">
        <label for="messageTo">To:</label>
        <select id="messageTo" name="messageTo" class="form-control">
            <option value="" selected></option>
            <?php foreach ($users as $user): ?>
                <option value="<?= $user ?>"><?= $user ?></option>
            <?php endforeach; ?>
        </select>
    </div>
    <div class="form-group">
<!--        <label for="messageContent">Message: </label>-->
        <input id="messageContent" name="messageContent" type="text" class="form-control" placeholder="Message body...">
    </div>
    <button id="messageSend" class="btn btn-primary btn-block">Send</button>
</div>
<hr>
<div id="messages"></div>
<div id="messagesError" class="alert alert-info" hidden="hidden">
    <strong>Shucks:</strong> There are no messages in your inbox
</div>
<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>