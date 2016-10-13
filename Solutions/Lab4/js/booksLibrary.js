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
    this.currentUser = '';

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
        this.currentUser = username;
    }
    else if (username.substr(0,1) == 'U')
    {
        console.log('Logged in as Undregraduate Student');
        this.currentAuthorization = 'student';
        this.currentUser = username;
    } else {
        alert('Not a correct username and password');
    }
};
Library.prototype.render = function(){
    var table = document.createElement('table');
    for(var s = 0; s < this.shelves.length; s++){
        var shelf = this.shelves[s];
        var row = document.createElement('tr');
        row.className = 'shelf';
        var header = document.createElement('th');
        header.innerHTML = shelf.name;
        row.appendChild(header);
        // html += '<tr class="shelf"><th>'+shelf.name+'</th>';
        for(var b = 0; b < shelf.books.length; b++){
            var book = shelf.books[b];
            var cell = document.createElement('td');
            cell.className = 'book ' + (book.presence ? '' : 'borrowed');
            cell.id = book.type+'_'+book.id;
            cell.onclick = book.clickFunction(this.currentAuthorization, this.currentUser);
            cell.innerHTML = book.type + book.id;
            row.appendChild(cell);
        }
        if (this.currentAuthorization == 'librarian')
        {
            var add = document.createElement('td');
            add.className = 'add';
            add.id = shelf.name + 'Add';
            add.onclick = shelf.addBookFormShow();
            add.innerHTML = '+ Add Book';
            row.appendChild(add);
        }
        table.appendChild(row);
    }
    document.getElementById('view').appendChild(table);
    $('#view').slideDown();
};
Library.prototype.begin = function(){
    this.attemptLogin();
    if(this.currentAuthorization != 'none')
    {
        $('#login').slideUp();
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
    var that = this;
    return function() {
        if (that.type != 'R' && that.presence) {
            console.log(borrower + ' borrowed ' + that.type + that.id);
            document.getElementById(that.type + '_' + that.id).classList.add('borrowed');
            that.borrowedBy = borrower;
            that.presence = 0;
            $('#info').slideUp();
            $('#info-content').html('');
        }
    }
};
Book.prototype.return = function(){
    var that = this;
    return function() {
        console.log(that.type + that.id + ' returned');
        document.getElementById(that.type + '_' + that.id).classList.remove('borrowed');
        that.borrowedBy = '';
        that.presence = 1;
        $('#info').slideUp();
        $('#info-content').html('');
    }
};
Book.prototype.clickFunction = function(auth, user){
    var that = this;
    return function(){
        $('#info-content').html('');
        if(auth == 'librarian')
        {
            var bookInfo = [
                'Type: ' + that.type,
                '<br>',
                'ID: ' + that.id,
                '<br>',
                'Borrowed By: ' + (that.presence ? 'No One' : that.borrowedBy),
                '<br>'
            ];
            $('#info-content').html(bookInfo.join(''));
            $('#info').slideDown();
        }
        else if (auth == 'student' && that.type != 'R')
        {
            if(that.presence)
            {
                var borrowButton = document.createElement('button');
                borrowButton.disabled = !that.presence;
                borrowButton.onclick = that.borrow(user);
                borrowButton.innerHTML = 'Borrow '+that.type+that.id;
                // var borrowHtml = '<button '+(that.presence ? '' : 'disabled')+' onclick="'+that.borrow(user)+'">Borrow'+that.type+that.id+'</button>';
                $('#info-content').append(borrowButton);
                $('#info').slideDown();
            }
            else
            {
                var returnButton = document.createElement('button');
                returnButton.disabled = that.presence || that.borrowedBy != user;
                returnButton.onclick = that.return();
                returnButton.innerHTML = 'Return '+that.type+that.id;
                // var returnHtml = '<button disabled="'+((!that.presence && that.borrowedBy == user) ? 'false' : 'true')+'" onclick="'+that.return()+'">Return</button>';
                $('#info-content').append(returnButton);
                $('#info').slideDown();
            }
        }
    }
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
Shelf.prototype.addBookFormShow = function(){
    var that = this;
    return function() {
        var submit = document.createElement('button');
        submit.onclick = that.addBookFromForm();
        submit.innerHTML = 'Add Book';
        $('#bookAdd').html('');
        $('#bookAdd').append(submit);
        $('#typeInput').val('B');
        $('#idInput').val('');
        $('#addBookForm').slideDown();
    }
};
Shelf.prototype.addBookFromForm = function(){
    var that = this;
    return function(){
        var type = $('#typeInput').val();
        var id = $('#idInput').val();
        console.log(type+id);
        if(type != '' && id != '') {
            var book = new Book(type, id);
            that.books.push(book);
            var cell = document.createElement('td');
            cell.className = 'book ' + (book.presence ? '' : 'borrowed');
            cell.id = book.type + '_' + book.id;
            cell.onclick = book.clickFunction('librarian', 'admin');
            cell.innerHTML = book.type + book.id;
            $(cell).insertBefore('#' + that.name + 'Add');
        }
        $('#addBookForm').slideUp();
    }
};
