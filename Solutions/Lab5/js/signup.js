$(document).ready(function(){
    $('#signUpSubmit').click(function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            isSignUp: true
        };
        if(data.username != '' && data.password != '') {
            $.ajax({
                url: '/php/checkLogin.php',
                method: 'POST',
                data: data,
                dataType: 'json',
                success: function (response, status, xhr) {
                    console.log(response);
                    if(response.data.logged_in) {
                        var form = document.createElement('form');
                        document.body.appendChild(form);
                        form.method = 'POST';
                        form.action = '/php/viewPosts.php';
                        form.submit();
                    }
                    else
                    {
                        $('#signupError').show();
                    }
                },
                error: function (xhr, status, error) {
                    console.log(error);
                }
            });
        }
    });
});