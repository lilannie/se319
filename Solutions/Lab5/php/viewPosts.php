<?php
include_once('renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in']:false, isset($_SESSION['username']) ? $_SESSION['username']:'Anon') ?>
<?= $renderHelper->renderContentStart() ?>

<?php
//loop through posts.txt and print out html
echo $renderHelper->renderPost('Author', 'This is a test. Please ignore', '10/12/2016');
echo $renderHelper->renderPost('Author', 'Another test', '10/12/2016');
?>


<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
