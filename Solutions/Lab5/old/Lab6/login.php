<?php
include_once('./php/database.php');
database::init();

include_once('php/renderHelper.php');
session_start();

$renderHelper = new renderHelper();
?>
<?= $renderHelper->renderIndexPageStart() ?>
<?= $renderHelper->renderIndexNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in'] : false, isset($_SESSION['username']) ? $_SESSION['username'] : 'Anon') ?>
<?= $renderHelper->renderContentStart() ?>

<h2>Log In</h2>
<div id="loginError" class="alert alert-danger" hidden="hidden">
    <strong>Login failed:</strong> Incorrect username or password. <a href="./signup.php">Create new account?</a>
</div>
<div>
    <div class="form-group">
        <label for="username">Username:</label>
        <input id="username" name="username" type="text" class="form-control" autofocus>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <input id="password" name="password" type="password" class="form-control">
    </div>
    <button id="loginSubmit" class="btn btn-primary">Log In</button>
</div>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>

<script type="text/javascript">
    $(document).ready(function () {
        $('#loginSubmit').click(function () {
            var data = {
                username: $('#username').val(),
                password: $('#password').val(),
                isSignUp: false
            };
            if (data.username != '' && data.password != '') {
                $.ajax({
                    url: './php/checkLogin.php',
                    method: 'POST',
                    data: data,
                    dataType: 'json',
                    contentType: "application/json",
                    success: function (response, status, xhr) {
                        console.log("Response Success");
                        console.log(response);
                        if (response.data.logged_in == true) {
                            var form = document.createElement('form');
                            document.body.appendChild(form);
                            form.method = 'POST';
                            form.action = './php/dashboard.php';
                            form.submit();
                        }
                        else {
                            $('#loginError').show();
                        }
                    },
                    error: function (xhr, status, error) {
                        console.log("Response Error");
                        console.log(xhr);
                    }
                });
            }
        });
    });
</script>

