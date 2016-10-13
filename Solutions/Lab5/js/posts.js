$(document).ready(function () {
    getPosts();
    $('#postSubmit').click(function () {
        var postTitleElement = $('#postTitle');
        var postContentElement = $('#postContent');
        var data = {
            title: postTitleElement.val(),
            content: postContentElement.val()
        };
        postTitleElement.css('border-color', '#ccc');
        postContentElement.css('border-color', '#ccc');
        if (data.title != '' && data.content != '')
        {
            $.ajax({
                url: '/php/updatePosts.php',
                method: 'POST',
                data: data,
                dataType: 'json',
                success: function (response, status, xhr) {
                    console.log(response);
                    getPosts();
                    postTitleElement.val('');
                    postContentElement.val('');
                },
                error: function (xhr, status, error) {
                    console.log(xhr);
                }
            });
        }
        else
        {
            if (data.title == '')
            {
                postTitleElement.css('border-color', '#c00');
            }
            if (data.content == '')
            {
                postContentElement.css('border-color', '#c00');
            }
        }
    });
});

function getPosts(){
    $.ajax({
        url: '/php/updatePosts.php',
        method: 'GET',
        dataType: 'json',
        success: function (response, status, xhr) {
            console.log(response);
            var postsElement = $('#posts');
            var postsErrorElement = $('#postsError');
            if (response.data.posts) {
                postsErrorElement.hide();
                postsElement.html('');
                for(var i = response.data.posts.length-1; i >= 0; i--){
                    var post = document.createElement('div');
                    post.className = 'panel panel-default';
                    post.id = response.data.posts[i].id;

                    var heading = document.createElement('div');
                    heading.className = 'panel-heading';
                    var title = document.createElement('h3');
                    title.className = 'panel-title';
                    title.innerHTML = '<span>'+response.data.posts[i].title+'</span>';
                    if (response.data.user == response.data.posts[i].author)
                    {
                        var editButton = document.createElement('button');
                        editButton.className = 'btn btn-default btn-xs editPostButton';
                        editButton.innerHTML = '<i class="fa fa-pencil"></i> Edit';
                        editButton.setAttribute('data-toggle', 'modal');
                        editButton.setAttribute('data-target', '#editPostModal');
                        editButton.style.marginLeft = '10px';
                        editButton.onclick = editHandler(response.data.posts[i]);
                        title.appendChild(editButton);
                    }
                    heading.appendChild(title);
                    post.appendChild(heading);

                    var body = document.createElement('div');
                    body.className = 'panel-body';
                    body.innerText = response.data.posts[i].content;
                    post.appendChild(body);

                    var foot = document.createElement('div');
                    foot.className = 'panel-footer';
                    foot.appendChild(document.createTextNode('-'+response.data.posts[i].author));
                    foot.appendChild(document.createTextNode(' ('+response.data.posts[i].date+')'));
                    post.appendChild(foot);

                    postsElement.append(post);
                }
            }
            else
            {
                postsErrorElement.show();
            }
        },
        error: function (xhr, status, error) {
            console.log(xhr);
        }
    });
}

function editHandler(post){
    return function(){
        $('#editPostTitle').val(post.title);
        $('#editPostContent').val(post.content);
        $('#editPostSubmit').click(saveEdit(post.id));
    }
}

function saveEdit(id){
    return function(){
        var postTitleElement = $('#editPostTitle');
        var postContentElement = $('#editPostContent');
        var data = {
            title: postTitleElement.val(),
            content: postContentElement.val(),
            id: id
        };
        postTitleElement.css('border-color', '#ccc');
        postContentElement.css('border-color', '#ccc');
        if (data.title != '' && data.content != '')
        {
            $.ajax({
                url: '/php/updatePosts.php',
                method: 'POST',
                data: data,
                dataType: 'json',
                success: function (response, status, xhr) {
                    console.log(response);
                    postTitleElement.val('');
                    postContentElement.val('');

                    var post = document.createElement('div');
                    post.className = 'panel panel-default';
                    post.id = response.data.post.id;

                    var heading = document.createElement('div');
                    heading.className = 'panel-heading';
                    var title = document.createElement('h3');
                    title.className = 'panel-title';
                    title.innerHTML = '<span>'+response.data.post.title+'</span>';
                    var editButton = document.createElement('button');
                    editButton.className = 'btn btn-default btn-xs editPostButton';
                    editButton.innerHTML = '<i class="fa fa-pencil"></i> Edit';
                    editButton.setAttribute('data-toggle', 'modal');
                    editButton.setAttribute('data-target', '#editPostModal');
                    editButton.style.marginLeft = '10px';
                    editButton.onclick = editHandler(response.data.post);
                    title.appendChild(editButton);
                    heading.appendChild(title);
                    post.appendChild(heading);

                    var body = document.createElement('div');
                    body.className = 'panel-body';
                    body.innerText = response.data.post.content;
                    post.appendChild(body);

                    var foot = document.createElement('div');
                    foot.className = 'panel-footer';
                    foot.appendChild(document.createTextNode('-'+response.data.post.author));
                    foot.appendChild(document.createTextNode(' ('+response.data.post.date+')'));
                    post.appendChild(foot);

                    $('#'+response.data.post.id).html('');
                    $('#'+response.data.post.id).html(post.innerHTML);
                },
                error: function (xhr, status, error) {
                    console.log(xhr);
                }
            });
        }
        else
        {
            if (data.title == '')
            {
                postTitleElement.css('border-color', '#c00');
            }
            if (data.content == '')
            {
                postContentElement.css('border-color', '#c00');
            }
        }
    }
}