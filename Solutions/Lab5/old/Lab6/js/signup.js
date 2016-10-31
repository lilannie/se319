$(document).ready(function(){
    $('#signUpSubmit').click(function () {
        var data = {
            username: $('#username').val(),
            password: $('#password').val(),
            email: $('#email').val(),
            phone: $('#phone').val(),
            lib: $('#lib').val() == "on" ? 1 : 0,
            firstname: $('#first').val(),
            lastname: $('#last').val(),
            isSignUp: true
        };
        console.log(data.password == $('#passwordConfirm').val() && isValidEmail(data.email)
            && isValidPhoneNumber(data.phone) && isValid(data.firstname && isValid(data.lastname)));

        if ( isValid(data.lastname) ) {

                console.log("sending request");
                $.ajax({
                    url: './php/checkLogin.php',
                    method: 'POST',
                    data: data,
                    dataType: 'json',
                    success: function (response, status, xhr) {
                        console.log(response);
                        if(response.data.logged_in) {
                            var form = document.createElement('form');
                            document.body.appendChild(form);
                            form.method = 'POST';
                            form.action = './php/dashboard.php';
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
        else {
            $('#signupError').show();
        }
    });
});

function isValidEmail(email) {
    var split1 = email.split('@');
    if (split1.length == 2 && isValid(split1[0])) {
        var split2 = split1[1].split('.');
        if (split2.length == 2 && isValid(split2[0])
            && isValid(split2[1])) {
            return true;
        }
    }
    return false;
}
function isValidPhoneNumber(phoneNumber) {
    var split = phoneNumber.split("-");
    if (split.length == 1) {
        return isValid(phoneNumber);
    }
    else {
        for (var string in split) {
            if (!isValid(string)) {
                return false;
            }
        }
        return true;
    }
}
function isValid(str) {
//        str.trim();
//        var alphanumeric = /^[a-z0-9]+$/i;
//        console.log(str + " : " + alphanumeric.test(str));
//        return alphanumeric.test(str);
    return isNaN(str) || $.isNumeric(str);
}