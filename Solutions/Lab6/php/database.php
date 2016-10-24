<?php

class database
{
    static $username = "root";
    static $password = "annie";
    static $dbServer = "127.0.0.1";
    static $dbName = "lab6";
    static $mysqli = null;

    static function init() {
        if (self::$mysqli == null) {
            self::$mysqli = new mysqli(self::$dbServer, self::$username, self::$password, self::$dbName);
            // Check connection
            if (self::$mysqli->connect_error) {
//                die("Connection failed: " . self::$mysqli->connect_error);
            }
        }
    }

    static function checkLogin($username, $password) {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("SELECT userName, password FROM users WHERE userName=".$username.";")) {
                if ($result->num_rows == 1) {
                    if ($row = mysqli_fetch_assoc($result)) {
                        if ($row["password"] == $password) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
//                printf("Error: %s\n", self::$mysqli->error);
                return false;
            }
        }
        return false;
    }

    static function createUser($username, $password) {
        if (self::$mysqli != null) {
            if ($result = self::$mysqli->query("INSERT INTO users (userName, password) VALUES (".$username.", ".$password.");")) {
//                printf("Error: %s\n", self::$mysqli->error);
                return false;
            }
            return true;
        }
        return false;
    }
}