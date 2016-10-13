<?php
session_start();


$file = file_get_contents('../database/posts.txt');
$posts = json_decode($file);

header('Content-Type: application/json');
echo json_encode([
    'data' => [
        'error' => 'success',
        'posts' => $posts,
    ]
]);