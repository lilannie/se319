<?php
session_start();

function getPosts()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file,true);

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
            'posts' => $posts,
            'user' => $_SESSION['username'],
        ]
    ]);
}
function createPost()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file, true);
    $id = 0;
    foreach ($posts as $post){
        $id = $post['id'];
    }
    $posts[] = [
        'id' => $id+1,
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
            'posts' => $posts,
        ]
    ]);
}
function updatePost()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file, true);
    $returnPost = null;
    foreach ($posts as $key => $post){
        if ($post['id'] == $_POST['id'])
        {
            $returnPost = [
                'id' => $_POST['id'],
                'title' => $_POST['title'],
                'content' => $_POST['content'],
                'author' => $_SESSION['username'],
                'date' => date('n/d/Y'),
            ];
            $posts[$key] = $returnPost;
        }
    }
    file_put_contents('../database/posts.txt',json_encode($posts));

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
            'post' => $returnPost,
        ]
    ]);
}
function deletePost()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file, true);
    $returnPosts = [];
    foreach ($posts as $post){
        if ($post['id'] != $_POST['id'])
        {
            $returnPosts[] = $post;
        }
    }
    file_put_contents('../database/posts.txt',json_encode($returnPosts));

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
            'posts' => $returnPosts,
        ]
    ]);
}

if($_SERVER['REQUEST_METHOD'] == 'GET')
{
    getPosts();
}
elseif ($_SERVER['REQUEST_METHOD'] == 'POST' && !isset($_POST['id']))
{
    createPost();
}
elseif ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['id']) && isset($_POST['title']) && isset($_POST['content']))
{
    updatePost();
}
elseif ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['id']) && isset($_POST['delete']))
{
    deletePost();
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