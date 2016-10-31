<?php
ob_start();
include_once('database.php');
database::init();
session_start();

$_SESSION['username'] = '';
$_SESSION['password'] = '';
$_SESSION['logged_in'] = false;

$input = file_get_contents("php://input");
$post = [];
parse_str($input, $post);

if (isset($post['isSignUp']) && isset($post['username']) && isset($post['password']))
{
    $username = $post['username'];
    $password = $post['password'];

    if ($post['isSignUp'] == 'true')
    {
        $email = $post['email'];
        $phone = $post['phone'];
        $lib = $post['lib'];
        $first = $post['firstname'];
        $last = $post['lastname'];
        //create new user (format-- username:password:public_key:private_key)
        $id = database::createUser($username, $password, $email, $phone, $lib, $first, $last);
        if ($id > 0) {
            //"Login" by setting session username and password
            $_SESSION['username'] = $username;
            $_SESSION['password'] = $password;
            $_SESSION['id'] = $id;
            $_SESSION['librarian'] = database::isLibrarian($username);
            $_SESSION['logged_in'] = true;

        }
        //redirect to viewPosts.php
    }
    else
    {
        $id = database::checkLogin($username, $password);
        if ($id > 0) {
            //"Login" by setting session username and password
            $_SESSION['username'] = $username;
            $_SESSION['password'] = $password;
            $_SESSION['id'] = $id;
            $_SESSION['librarian'] = database::isLibrarian($username);
            $_SESSION['logged_in'] = true;
        }
    }
}

ob_clean();
if (!headers_sent()) {
    header('Content-Type: application/json; charset=UTF8');
    header('Expires: Thu, 19 Nov 2017 08:52:00 GMT');
}
echo json_encode(array(
    'data' => [
        'error' => 'success',
        'logged_in' => $_SESSION['logged_in'] ? '1' : '0',
        'username' => $_SESSION['username'] ."",
        'password' => $_SESSION['password']."",
    ]
));
ob_end_flush();