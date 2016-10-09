function Library(){
    this.allBooks = [];
    for(var i = 0; i < 5; i++){
        this.allBooks.push(new Book('R',i+1)); //Math.floor(Math.random() * 1000)
    }
    for(i = 0; i < 20; i++){
        this.allBooks.push(new Book('B',i+1)); //Math.floor(Math.random() * 1000)
    }

    this.shelves = [];
    this.shelves.push(new Shelf('Art',0));
    this.shelves.push(new Shelf('Science',1));
    this.shelves.push(new Shelf('Sport',2));
    this.shelves.push(new Shelf('Literature',3));

    for(i = 0; i < this.allBooks.length; i++){
        for(var s = 0; s < this.shelves.length; s++){
            this.shelves[s].addBook(this.allBooks[i]);
        }
    }

    this.currentAuthorization = 'none';

    this.begin();
}
Library.prototype.attemptLogin = function(){
    var username = $('#usernameInput').val();
    var password = $('#passwordInput').val();
    // console.log(username + ': ' + password);
    if (username == 'admin' && password == 'admin')
    {
        console.log('Logged in as Librarian');
        this.currentAuthorization = 'librarian';
    }
    else if (username.substr(0,1) == 'U')
    {
        console.log('Logged in as Undregraduate Student');
        this.currentAuthorization = 'student';
    } else {
        alert('Not a correct username and password');
    }
};
Library.prototype.render = function(){
    var html = '<table><tbody>';
    for(var s = 0; s < this.shelves.length; s++){
        var shelf = this.shelves[s];
        html += '<tr class="shelf"><th>'+shelf.name+'</th>';
        for(var b = 0; b < shelf.books.length; b++){
            var book = shelf.books[b];
            html += '<td id="'+book.type+book.id+'" class="book '+ (book.presence ? '' : 'borrowed') +'">';
            html += book.type + book.id;
            html += '</td>';
        }
        html += '</tr>';
    }
    html += '</tbody></table>';
    $('#view').html(html);
};
Library.prototype.begin = function(){
    this.attemptLogin();
    if(this.currentAuthorization != 'none')
    {
        $('#login').hide();
        this.render();
    }
};

function Book(type, id){
    this.type = type;
    this.id = id;
    this.borrowedBy = '';
    this.presence = 1;
}
Book.prototype.borrow = function(borrower){
    if(this.type != 'R' && this.presence == 1){
        this.borrowedBy = borrower;
        this.presence = 0;
    }
};
Book.prototype.return = function(){
    this.borrowedBy = '';
    this.presence = 1;
};

function Shelf(name, category){
    this.name = name;
    this.category = category; // BookID%4 = this.category
    this.books = [];
}
Shelf.prototype.addBook = function(book){
    if(book.id % 4 == this.category){
        this.books.push(book);
    }
};
