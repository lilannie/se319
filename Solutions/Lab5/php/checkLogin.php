<?php

session_start();

$username = $_POST['username'];
$password = $_POST['password'];

if (isset($_POST['isSignUp']) && isset($_POST['username']) && isset($_POST['password']))
{
    if ($_POST['isSignUp'])
    {
        //create new user (format-- username:password:public_key:private_key)
        //"Login" by setting session username and password
        $_SESSION['username'] = $username;
        $_SESSION['password'] = $password;
        $_SESSION['logged_in'] = true;
        //redirect to viewPosts.php
    }
    else
    {
        //loop through users in ../database/users.txt
        //if match username and password
            //"Login" by setting session username and password
        $_SESSION['username'] = $username;
        $_SESSION['password'] = $password;
        $_SESSION['logged_in'] = true;
            //redirect to viewPosts.php
        //end loop
        //if no match
            //return error json
    }
} else
{
    $_SESSION['username'] = '';
    $_SESSION['password'] = '';
    $_SESSION['logged_in'] = false;
}

//for testing purposes
header('Content-Type: application/json');
echo json_encode([
    'data' => [
        'error' => 'success',
        'logged_in' => $_SESSION['logged_in'],
    ]
]);