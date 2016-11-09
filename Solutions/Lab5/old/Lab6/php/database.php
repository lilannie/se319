<?php

class database
{
    static $username = "root";
    static $password = "annie";
    static $dbServer = "127.0.0.1";
    static $dbName = "lab6";
    static $mysqli = null;

    static $artCount = 0;
    static $scienceCount = 0;
    static $sportCount = 0;
    static $literatureCount = 0;

    static function init()
    {
        if (self::$mysqli == null) {
            self::$mysqli = new mysqli(self::$dbServer, self::$username, self::$password, self::$dbName);
            // Check connection
//            if (self::$mysqli->connect_error) {
//                die("Connection failed: " . self::$mysqli->connect_error);
//            }

            if ($result = self::$mysqli->query("SELECT shelvesId FROM shelves WHERE shelfName ='art';")) {
                self::$artCount = $result->num_rows;
            }
            if ($result = self::$mysqli->query("SELECT shelvesId FROM shelves WHERE shelfName ='science';")) {
                self::$scienceCount = $result->num_rows;
            }
            if ($result = self::$mysqli->query("SELECT shelvesId FROM shelves WHERE shelfName ='sport';")) {
                self::$sportCount = $result->num_rows;
            }
            if ($result = self::$mysqli->query("SELECT shelvesId FROM shelves WHERE shelfName ='literature';")) {
                self::$literatureCount = $result->num_rows;
            }
        }
    }

    static function isLibrarian($username)
    {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("SELECT librarian FROM users WHERE userName='" . $username . "';")) {
                if ($result->num_rows == 1) {
                    if ($row = mysqli_fetch_assoc($result)) {
                        return $row["librarian"];
                    }
                }
                return false;
            }
        }
        return false;
    }

    static function checkLogin($username, $password)
    {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("SELECT userName, password FROM users WHERE userName='" . $username . "';")) {
                if ($result->num_rows == 1) {
                    if ($row = mysqli_fetch_assoc($result)) {
                        if ($row["password"] == $password) {

                            return 1;
                        }
                    }
                }
                return false;
            }
//            else {
//                printf("Error: %s\n", self::$mysqli->error);
//                return false;
//            }
        }
        return false;
    }

    static function createUser($username, $password, $email, $phone, $lib, $first, $last)
    {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("INSERT INTO users (userName, password, email, phone, librarian, firstName, lastName) VALUES ('" . $username
                . "', '" . $password . "', '" . $email . "', '" . $phone . "', '" . $lib . "', '".$first."', '".$last."');")) {
//                printf("Error: %s\n", self::$mysqli->error);
                return self::$mysqli->insert_id;
            }
            return 0;
        }
        return 0;
    }

    static function addBook($title, $author, $shelf)
    {
        if (self::$mysqli != null) {
            switch ($shelf) {
                case 'art': {
                    if (self::$artCount >= 20) return false;
                    break;
                }
                case 'science': {
                    if (self::$scienceCount >= 20) return false;
                    break;
                }
                case 'sport': {
                    if (self::$sportCount >= 20) return false;
                    break;
                }
                case 'literature': {
                    if (self::$literatureCount >= 20) return false;
                    break;
                }
            }
            if ($result = self::$mysqli->query("INSERT INTO books (bookTitle, author, availability) VALUES ('" . $title . "', '" . $author . "', '1');")) {
                if ($result = self::$mysqli->query("INSERT INTO shelves (shelfName, bookId) VALUES ('" . $shelf . "', '" . self::$mysqli->insert_id . "');")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    static function delete($id)
    {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("DELETE FROM books WHERE bookId='" . $id . "';")) {
                printf("Error: %s\n", self::$mysqli->error);

                if ($result = self::$mysqli->query("DELETE FROM shelves WHERE bookId='" . $id . "';")) {
                    printf("Error: %s\n", self::$mysqli->error);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    static function borrow($id, $userId)
    {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("UPDATE books SET availability='0' WHERE bookId='" . $id . "';")) {
                if ($result = self::$mysqli->query("INSERT INTO loanHistory (userId, dueDate, bookId) VALUES ('" . $userId . "', '" . (new \DateTime())->modify('+2weeks')->format('Y-m-d H:i:s') . "', '" . $id . "');")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    static function returnBook($id, $userId)
    {
        echo "here 3";
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("UPDATE books SET availability='1' WHERE bookId='" . $id . "';")) {
                if ($result = self::$mysqli->query("UPDATE loanHistory SET returnDate=" . (new \DateTime())->format('Y-m-d H:i:s') . " WHERE bookId='" . $id . "' AND userId='" . $userId . "';")) {
                    return true;
                }
            }
            printf("Error: %s\n", self::$mysqli->error);
            return false;
        }
        echo "here 4";
        return false;
    }

    static function isUserBook($bookId, $userId)
    {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("SELECT * FROM loanHistory WHERE bookId='" . $bookId . "' AND userId='" . $userId . "';")) {
                if ($result->num_rows > 0)
                    return true;
            }
            return false;
        }
        return false;
    }

    static function getShelves()
    {
        $shelves = [];
        $art = [];
        $science = [];
        $sport = [];
        $literature = [];

        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("SELECT * FROM shelves;")) {
                if ($rows = mysqli_fetch_all($result)) {
                    foreach ($rows as $row) {
                        if ($result = self::$mysqli->query("SELECT * FROM books WHERE bookId=" . $row[2] . ";")) {
                            $bookArr = [];

                            if ($result->num_rows == 1) {
                                if ($book = mysqli_fetch_assoc($result)) {
                                    $bookArr = [
                                        'bookId' => $book['bookId'],
                                        'bookTitle' => $book['bookTitle'],
                                        'author' => $book['author'],
                                        'availability' => $book['availability'],
                                    ];
                                }
                            }

                            switch ($row[1]) {
                                case 'art': {
                                    array_push($art, $bookArr);
                                    break;
                                }
                                case 'science': {
                                    array_push($science, $bookArr);
                                    break;
                                }
                                case 'sport': {
                                    array_push($sport, $bookArr);
                                    break;
                                }
                                case 'literature': {
                                    array_push($literature, $bookArr);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            $shelves = [
                [
                    'name' => 'art',
                    'books' => $art,
                ],
                [
                    'name' => 'science',
                    'books' => $science
                ],
                [
                    'name' => 'sport',
                    'books' => $sport,
                ],
                [
                    'name' => 'literature',
                    'books' => $literature,
                ],
            ];

        }
        return $shelves;
    }

    static function getHistory()
    {
        $loans = [];
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("SELECT * FROM loanHistory;")) {
                if ($rows = mysqli_fetch_all($result)) {
                    foreach ($rows as $row) {
                        $username = '';
                        if ($result = self::$mysqli->query("SELECT userName FROM users WHERE userId='" . $row[1] . "';")) {
                            if ($result->num_rows == 1) {
                                if ($user = mysqli_fetch_assoc($result)) {
                                    $username = $user['userName'];
                                }
                            }
                        }

                        $bookname = '';
                        if ($result = self::$mysqli->query("SELECT bookTitle FROM books WHERE bookId='" . $row[4] . "';")) {
                            if ($result->num_rows == 1) {
                                if ($book = mysqli_fetch_assoc($result)) {
                                    $bookname = $book['bookTitle'];
                                }
                            }
                        }
                        $loan = [
                            'username' => $username,
                            'dueDate' => $row[2],
                            'returnDate' => $row[3],
                            'bookname' => $bookname
                        ];

                        $loans[] = $loan;
                    }
                }
            }
        }
        return $loans;
    }
}