<?php
session_start();

ob_start();
include_once('database.php');
database::init();

database::returnBook($_GET['id'], $_SESSION['id']);

ob_clean();
header('Location: ../dashboard.php');
ob_end_flush();