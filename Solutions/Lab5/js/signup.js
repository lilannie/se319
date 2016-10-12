$(document).ready(function(){
    $('#signUpSubmit').click(function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            signnup: true
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