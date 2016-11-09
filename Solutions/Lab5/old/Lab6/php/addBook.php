<?php
ob_start();
include_once('database.php');
database::init();

$input = file_get_contents("php://input");
$post = [];
parse_str($input, $post);

if (isset($post['title']) && isset($post['author']))
{
    $title = $post['title'];
    $author = $post['author'];
    $shelf = $post['shelf'];

    if (database::addBook($title, $author, $shelf)) {
        $success = "1";
    } else {
        $success = "0";
    }

}

ob_clean();
if (!headers_sent()) {
    header('Content-Type: application/json; charset=UTF8');
    header('Expires: Thu, 19 Nov 2017 08:52:00 GMT');
}
echo json_encode(array(
    'data' => [
        'success' => ''.$success,
    ]
));
ob_end_flush();