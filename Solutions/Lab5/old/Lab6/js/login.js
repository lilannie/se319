$(document).ready(function(){
    $('#loginSubmit').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        var data = {
            'username': username,
            'password': password,
            'isSignUp': 'false'
        };
        if (data.username != '' && data.password != '')
        {
            var res;
            $.ajax({
                url: './php/checkLogin.php',
                method: 'POST',
                data: data,
                dataType: 'json',
                contentType: "application/json",
                success: function (response, status, xhr) {
                    console.log("Success");
                    console.log(response);
                    console.log(JSON.parse(response));
//                        if (response.data.logged_in == true) {
//                            console.log("LOGGED IN");
//                            var form = document.createElement('form');
//                            document.body.appendChild(form);
//                            form.method = 'POST';
//                            form.action = './php/viewPosts.php';
//                            form.submit();
//                        }
//                        else
//                        {
//                            $('#loginError').show();
//                        }
                },
                error: function (xhr, status, error) {
                    console.log("Error");
                    console.log(xhr.responseType);
                    console.log(xhr.responseText);
                    alert(error);
                }
            });
        }
    });
});