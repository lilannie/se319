$(document).ready(function(){
    $('#signUpSubmit').click(function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            isSignUp: true
        };
        $.ajax({
            url: '/php/checkLogin.php',
            method: 'POST',
            data: data,
            dataType: 'json',
            success: function (response, status, xhr) {
                console.log(response);
                var form = document.createElement('form');
                document.body.appendChild(form);
                form.method='POST';
                form.action='/php/checkLogin.php';
                form.submit();
            },
            error: function (xhr, status, error) {
                console.log(error);
            }
        });
    });
});