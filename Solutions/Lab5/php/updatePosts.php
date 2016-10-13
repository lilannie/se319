<?php
session_start();

function getPosts()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file);

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
            'posts' => $posts,
        ]
    ]);
}
function createPost()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file);
    $posts[] = [
        'id' => (!empty($posts) ? $posts[count($posts)-1]+1 : 0),
        'title' => $_POST['title'],
        'content' => $_POST['content'],
        'author' => $_SESSION['username'],
        'date' => date('n/d/Y'),
    ];
    file_put_contents('../database/posts.txt',json_encode($posts));

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
        ]
    ]);
}
function updatePost()
{

}

if($_SERVER['REQUEST_METHOD'] == 'GET')
{
    getPosts();
}
elseif ($_SERVER['REQUEST_METHOD'] == 'POST')
{
    createPost();
}
elseif ($_SERVER['REQUEST_METHOD'] == 'PUT')
{
    updatePost();
}
else
{
    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'failure - invalid http request',
        ]
    ]);
}