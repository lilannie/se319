<?php
include_once('renderHelper.php');

$renderHelper = new renderHelper();
?>

<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderBodyStart() ?>
<?= $renderHelper->renderNav() ?>
<?php
//loop through posts.txt and print out html

echo $renderHelper->renderPost('Author', 'This is a test. Please ignore', '10/12/2016');
?>


<?= $renderHelper->renderBodyEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
