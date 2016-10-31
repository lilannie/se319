<?php
include_once('./database.php');
database::init();

include_once('./renderHelper.php');
session_start();
$renderHelper = new renderHelper();

?>

<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in'] : false, isset($_SESSION['username']) ? $_SESSION['username'] : 'Anon') ?>
<?= $renderHelper->renderContentStart() ?>

<div class="container">
    <div class="col-md-5">
        <div class="form-area">
            <div id="error" class="alert alert-danger" hidden="hidden">
                <strong>Error: </strong> Unable to create book. Either uncompleted form or too many books. Only 20 books per shelf.
            </div>
            <form role="form" method="post" action="<?php echo $_SERVER['PHP_SELF']?>">
                <br style="clear:both">
                <h3 class="hidden" style="margin-bottom: 25px; text-align: center;">Add Book to Shelf</h3>
                <h3 style="margin-bottom: 25px; text-align: center;">Add Book to Shelf</h3>
                <div class="form-group">
                    <label>Title</label>
                    <input id="title" type="text" class="form-control" name="bookTitle" placeholder="Title" required>
                </div>
                <div class="form-group">
                    <label>Author</label>
                    <input id="author" type="text" class="form-control"name="author" placeholder="Author" required>
                </div>
                <div class="form-group">
                    <label>Shelf</label>
                    <select id="shelf" class="form-control"name="shelf" required>
                        <option value="art">Art</option>
                        <option value="science">Science</option>
                        <option value="sport">Sport</option>
                        <option value="literature">Literature</option>
                    </select>
                </div>

                <button type="button" id="addSubmit" name="submit" class="btn btn-primary pull-right">Submit</button>
            </form>
        </div>
    </div>
</div>


<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>

<script type="text/javascript">
    $(document).ready(function () {
        $('#addSubmit').click(function () {
            var data = {
                title: $('#title').val(),
                author: $('#author').val(),
                shelf: $('#shelf').val()
            };
            if (data.title != '' && data.author != '') {

                $.ajax({
                    url: './addBook.php',
                    method: 'POST',
                    data: data,
                    dataType: 'json',
                    contentType: "application/json",
                    success: function (response, status, xhr) {
                        console.log("Response Success");
                        console.log(response);
                        if (response.data.success == "1") {
                            var form = document.createElement('form');
                            document.body.appendChild(form);
                            form.method = 'POST';
                            form.action = './dashboard.php';
                            form.submit();
                        }
                        else {
                            $('#error').show();
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
