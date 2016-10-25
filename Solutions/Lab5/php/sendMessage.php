<?php
$path = 'phpseclib';
    set_include_path(get_include_path() . PATH_SEPARATOR . $path);
    include_once('Crypt/RSA.php');

//Function for encrypting with RSA
function rsa_encrypt($string, $public_key)
{
    //Create an instance of the RSA cypher and load the key into it
    $cipher = new Crypt_RSA();
    $cipher->loadKey($public_key);
    //Set the encryption mode
    $cipher->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
    //Return the encrypted version
    return $cipher->encrypt($string);
}

session_start();
include_once('renderHelper.php');
$renderHelper = new renderHelper();

function sendMessage()
{
    $file = file_get_contents('../database/messages.txt');
    $messages = json_decode($file, true);
    $messages = $messages ? $messages : [];
    $id = 0;
    foreach ($messages as $message){
        $id = $message['id'];
    }
    $newMessage = [
        'id' => $id+1,
        'to' => $_POST['to'],
        'content' => rsa_encrypt($_POST['content'], $renderHelper->$public_key),
        'from' => $_SESSION['username'],
        'date' => date('n/d/Y'),
    ];
    $messages[] = $newMessage;
    file_put_contents('../database/messages.txt',json_encode($messages));

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
            'message' => $newMessage,
        ]
    ]);
}
function getMessages()
{

    $file = file_get_contents('../database/messages.txt');
    $messages = json_decode($file, true);
    $messages = $messages ? $messages : [];
    $returnMessages = [];
    foreach($messages as $message){
        if ($message['to'] == $_SESSION['username'])
        {
            $returnMessages[] = $message;
        }
    }

    header('Content-Type: application/json');
    echo json_encode([
        'data' => [
            'error' => 'success',
            'messages' => $returnMessages,
        ]
    ]);
}

if(isset($_POST['to']) && $_POST['to']!='' && isset($_POST['content']) && $_POST['content']!='')
{
    sendMessage();
}
else
{
    getMessages();
}