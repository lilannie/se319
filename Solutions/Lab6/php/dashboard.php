<?php
session_start();

include_once('./database.php');
database::init();

include_once('./renderHelper.php');
$renderHelper = new renderHelper();

?>
<?= $renderHelper->renderPageStart() ?>
<?= $renderHelper->renderNav(isset($_SESSION['logged_in']) ? $_SESSION['logged_in'] : false, isset($_SESSION['username']) ? $_SESSION['username'] : 'Anon') ?>
<?= $renderHelper->renderContentStart() ?>


<? foreach (database::getShelves() as $shelf): ?>
    <div class="row">
        <div class="panel panel-info">

            <div class="panel-heading">
                <? if ($_SESSION['librarian']): ?>
                    <a href="./add.php" class="btn btn-primary pull-right" role="botton">Add Book</a>
                <? endif ?>
                <h2 style="margin-left: 10px"><?= $shelf['name'] ?></h2>
            </div>


            <div class="panel-body">
                <? foreach ($shelf['books'] as $book): ?>
                    <div class="col-sm-4 col-md-4">

                        <div class="panel panel-default">

                            <div class="panel-heading" data-toggle="collapse"
                                 data-target="#collapse<?= $book['bookId'] ?>">
                                <h3><?= $book['bookTitle'] ?></h3>
                            </div>

                            <div id="collapse<?= $book['bookId'] ?>" class="panel-collapse collapse fade">
                                <div class="panel-body">
                                    <p>Author: <?= $book['author'] ?></p>
                                    <? if ($_SESSION['librarian']): ?>
                                        <p>
                                            <a href="./delete.php/?id=<?= $book['bookId'] ?>" class="btn btn-primary"
                                              role="button">Delete</a>
                                        </p>
                                    <? else: ?>
                                        <? if (!$book['availability']): ?>
                                            <p>
                                                <a href="./return.php/?id=<?= $book['bookId'] ?>" class="btn btn-primary" role="button">Return</a>
                                            </p>
                                        <? else: ?>
                                            <p>
                                                <a href="./borrow.php/?id=<?= $book['bookId'] ?>" class="btn btn-primary" role="button">Borrow</a>
                                            </p>
                                        <? endif ?>

                                    <? endif; ?>
                                </div>
                            </div>

                        </div>
                    </div>
                <? endforeach ?>
            </div>
        </div>
    </div>
<? endforeach ?>

<? if ($_SESSION['librarian']): ?>

<h2>Loan History</h2>
<table class="table">
    <thead>
    <tr>
        <th>User</th>
        <th>Due Date</th>
        <th>Return Date</th>
        <th>Book Name</th>
    </tr>
    </thead>
    <tbody>
    <? foreach (database::getHistory() as $loan): ?>
        <tr>
            <th scope="row"><?= $loan['username'] ?></th>
            <td><?= $loan['dueDate'] ?></td>
            <td><?= $loan['returnDate'] ?></td>
            <td><?= $loan['bookname'] ?></td>
        </tr>
    <? endforeach ?>
    </tbody>
</table>

<? endif; ?>

<?= $renderHelper->renderContentEnd() ?>
<?= $renderHelper->renderPageEnd() ?>
