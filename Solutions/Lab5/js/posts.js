$(document).ready(function () {
    getPosts();
});

function getPosts(){
    $.ajax({
        url: '/php/updatePosts.php',
        method: 'GET',
        dataType: 'json',
        success: function (response, status, xhr) {
            console.log(response);
            if (response.data.posts) {
                for(var i = response.data.posts.length-1; i >= 0; i--){
                    var post = document.createElement('div');
                    post.className = 'panel panel-default';

                    var heading = document.createElement('div');
                    heading.className = 'panel-heading';
                    var title = document.createElement('h3');
                    title.className = 'panel-title';
                    title.innerHTML = response.data.posts[i].title;
                    heading.appendChild(title);
                    heading.appendChild(document.createTextNode(response.data.posts[i].author));
                    post.appendChild(heading);

                    var body = document.createElement('div');
                    body.className = 'panel-body';
                    body.innerText = response.data.posts[i].content;
                    post.appendChild(body);

                    var foot = document.createElement('div');
                    foot.className = 'panel-footer';
                    foot.innerHTML = response.data.posts[i].date;
                    post.appendChild(foot);

                    $('#posts').append(post);
                }
            }
            else
            {
                $('#postsError').show();
            }
        },
        error: function (xhr, status, error) {
            console.log(xhr);
        }
    });
}