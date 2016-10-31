# CREATE DATABASE lab6;
CREATE TABLE lab6.users (
  userId    INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  userName  VARCHAR(255),
  password  VARCHAR(255),
  email     VARCHAR(255),
  phone     INT(10),
  librarian TINYINT,
  firstName VARCHAR(255),
  lastName  VARCHAR(255)
);
CREATE TABLE lab6.books (
  bookId       INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  bookTitle    VARCHAR(255),
  author       VARCHAR(255),
  availability TINYINT
);
CREATE TABLE lab6.loanHistory (
  loanId     INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  userId     INT(10),
  dueDate    DATE,
  returnDate DATE,
  bookId     INT(10)
);
CREATE TABLE lab6.shelves (
  shelvesId INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  shelfName VARCHAR(255),
  bookId    INT(10)
);