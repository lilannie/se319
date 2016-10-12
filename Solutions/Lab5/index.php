<?php
include_once('php/renderHelper.php');

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderBodyStart() ?>
<?= $renderHelper->renderNav() ?>
<!-- stuff here -->
<?= $renderHelper->renderBodyEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
