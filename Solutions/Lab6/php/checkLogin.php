<?php
ob_start();
include_once('database.php');
session_start();

$_SESSION['username'] = '';
$_SESSION['password'] = '';
$_SESSION['logged_in'] = false;

if (isset($_POST['isSignUp']) && isset($_POST['username']) && isset($_POST['password']))
{
    $username = $_POST['username'];
    $password = $_POST['password'];
    if ($_POST['isSignUp'] == 'true')
    {
        //create new user (format-- username:password:public_key:private_key)
        if (database::createUser($username, $password)) {
            //"Login" by setting session username and password
            $_SESSION['username'] = $username;
            $_SESSION['password'] = $password;
            $_SESSION['logged_in'] = true;
        }
        //redirect to viewPosts.php
    }
    else
    {
        if (database::checkLogin($username, $password)) {
            //"Login" by setting session username and password
            $_SESSION['username'] = $username;
            $_SESSION['password'] = $password;
            $_SESSION['logged_in'] = true;
        }
    }
}
echo "Contents before: <br/>";
var_dump(ob_get_contents());
ob_end_flush();

ob_start();
ob_clean();
if (!headers_sent()) {
    header('Content-Type: application/json; charset=UTF8');
    header('Expires: Thu, 19 Nov 2017 08:52:00 GMT');
    var_dump(headers_list());
}
else {
    var_dump(headers_list());
}

echo "After: <br/>";
echo json_encode(array(
    'data' => [
        'error' => 'success',
        'logged_in' => (string)$_SESSION['logged_in']
    ]
));

var_dump(ob_get_contents());
ob_end_flush();

//for testing purposes