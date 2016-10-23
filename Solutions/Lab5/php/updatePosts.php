<?php
session_start();

function getPosts()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file,true);
    $posts = $posts ? $posts : [];

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
    $posts = $posts ? $posts : [];
    $id = 0;
    foreach ($posts as $post){
        $id = $post['id'];
    }
    $posts[] = [
        'id' => $id+1,
        'title' => $_POST['title'],
        'content' => $_POST['content'],
        'author' => $_SESSION['username'],
        'likes' => [],
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
    $posts = $posts ? $posts : [];
    $returnPost = null;
    foreach ($posts as $key => $post){
        if ($post['id'] == $_POST['id'])
        {
            $returnPost = [
                'id' => $_POST['id'],
                'title' => $_POST['title'],
                'content' => $_POST['content'],
                'author' => $_SESSION['username'],
                'likes' => $post['likes'],
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
    $posts = $posts ? $posts : [];
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
function likePost()
{
    $file = file_get_contents('../database/posts.txt');
    $posts = json_decode($file, true);
    $posts = $posts ? $posts : [];
    $returnPosts = [];
    $likes = 0;
    foreach ($posts as $post){
        if ($post['id'] == $_POST['id']) {
            if (!in_array($_SESSION['username'], $post['likes']))
            {
                $post['likes'][] = $_SESSION['username'];
            }
            else
            {
                array_splice($post['likes'], array_search($_SESSION['username'], $post['likes']));
            }
            $likes = count($post['likes']);
        }
        $returnPosts[] = $post;
    }
    file_put_contents('../database/posts.txt',json_encode($returnPosts));

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
            'likes' => $likes,
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
elseif ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['id']) && isset($_POST['like']))
{
    likePost();
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