$(document).ready(function(){
    getMessages();
    $('#messageSend').click(function () {
        var messageToElement = $('#messageTo');
        var messageContentElement = $('#messageContent');
        var data = {
            to: messageToElement.val(),
            content: messageContentElement.val()
        };
        messageToElement.css('border-color', '#ccc');
        messageContentElement.css('border-color', '#ccc');
        if (data.to != '' && data.content != '')
        {
            $.ajax({
                url: '/php/sendMessage.php',
                method: 'POST',
                data: data,
                dataType: 'json',
                success: function (response, status, xhr) {
                    console.log(response);
                    messageToElement.val('');
                    messageContentElement.val('');
                },
                error: function (xhr, status, error) {
                    console.log(xhr);
                }
            });
        }
        else
        {
            if (data.to == '')
            {
                messageToElement.css('border-color', '#c00');
            }
            if (data.content == '')
            {
                messageContentElement.css('border-color', '#c00');
            }
        }
    });
});

function getMessages(){
    $.ajax({
        url: '/php/sendMessage.php',
        method: 'GET',
        dataType: 'json',
        success: function (response, status, xhr) {
            console.log(response);
            var messagesElement = $('#messages');
            var messagesErrorElement = $('#messagesError');
            if (response.data.messages && response.data.messages.length > 0) {
                messagesErrorElement.hide();
                messagesElement.html('');
                for(var i = response.data.messages.length-1; i >= 0; i--){
                    var message = document.createElement('div');
                    message.className = 'panel panel-default';
                    message.id = response.data.messages[i].id;

                    var heading = document.createElement('div');
                    heading.className = 'panel-heading';
                    var title = document.createElement('h3');
                    title.className = 'panel-title';
                    title.innerHTML = '<span>'+response.data.messages[i].from+'</span> said';
                    heading.appendChild(title);
                    message.appendChild(heading);

                    var body = document.createElement('div');
                    body.className = 'panel-body';
                    body.innerText = response.data.messages[i].content;
                    message.appendChild(body);

                    var foot = document.createElement('div');
                    foot.className = 'panel-footer';
                    foot.appendChild(document.createTextNode(''+response.data.messages[i].date+''));
                    message.appendChild(foot);

                    messagesElement.append(message);
                }
            }
            else
            {
                messagesErrorElement.show();
            }
        },
        error: function (xhr, status, error) {
            console.log(xhr);
        }
    });
}