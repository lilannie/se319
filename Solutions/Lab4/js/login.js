function attemptLogin(){
    var username = $('#usernameInput').val();
    var password = $('#passwordInput').val();
    console.log(username + ': ' + password);
    if (username == 'admin' && password == 'admin')
    {
        console.log('Logged in as Librarian');
    }
    else if (username.substr(0,1) == 'U')
    {
        console.log('Logged in as Undregraduate Student');
    } else {
        alert('Not a correct username and password');
    }
}

