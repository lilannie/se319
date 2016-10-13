<?php

session_start();

$_SESSION['username'] = '';
$_SESSION['password'] = '';
$_SESSION['logged_in'] = false;
$filestuff = [];
if (isset($_POST['isSignUp']) && isset($_POST['username']) && isset($_POST['password']))
{
    $username = $_POST['username'];
    $password = $_POST['password'];
    if ($_POST['isSignUp'] == 'true')
    {

        //create new user (format-- username:password:public_key:private_key)
        file_put_contents('../database/users.txt', $username.':'.$password."\r\n", FILE_APPEND);
        //"Login" by setting session username and password
        $_SESSION['username'] = $username;
        $_SESSION['password'] = $password;
        $_SESSION['logged_in'] = true;
        //redirect to viewPosts.php
    }
    else
    {
        //loop through users in ../database/users.txt
        $file = fopen("../database/users.txt","r");
        while (! feof($file))
        {
            $line = explode(":",trim(fgets($file)));
            $filestuff[] = $line;
            $line_user = $line[0];
            $line_password = $line[1];
            //if match username and password
            if($line_user == $username && $line_password == $password)
            {
                //"Login" by setting session username and password
                $_SESSION['username'] = $username;
                $_SESSION['password'] = $password;
                $_SESSION['logged_in'] = true;
                break;
            }
        }
        fclose($file);
    }
}

//for testing purposes
header('Content-Type: application/json');
echo json_encode([
    'data' => [
        'error' => 'success',
        'logged_in' => $_SESSION['logged_in'],
        'file' => $filestuff
    ]
]);