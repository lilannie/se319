<?php
include_once('php/renderHelper.php');
$renderHelper = new renderHelper();

echo $renderHelper->renderPageStart();
echo $renderHelper->renderNav(true, '');
echo $renderHelper->renderContentStart();


echo $renderHelper->renderContentEnd();
echo $renderHelper->renderPageEnd();