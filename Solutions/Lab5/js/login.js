$(document).ready(function(){
    $('#loginSubmit').click(function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            signnup: false
        };
        $.ajax({
            url: '/php/checkLogin.php',
            method: 'POST',
            data: data,
            dataType: 'json',
            success: function (response, status, xhr) {

            },
            error: function (xhr, status, error) {

            }
        });
    });
});