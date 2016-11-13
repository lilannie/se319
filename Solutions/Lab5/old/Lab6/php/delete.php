<?php
ob_start();
include_once('database.php');
database::init();

database::delete($_GET['id']);

ob_clean();
header('Location: ../dashboard.php');
ob_end_flush();