$(document).ready(function(){
    //CSS Effects
    $('#toggleBackgroundColor').click(function () {
        if(this.style.backgroundColor == 'blue'){
            this.style.backgroundColor = 'red';
        } else {
            this.style.backgroundColor = 'blue';
        }
    });
    $('#toggleFontSize').click(function () {
        if(this.style.fontSize == '12px'){
            this.style.fontSize = '24px';
        } else {
            this.style.fontSize = '12px';
        }
    });
    $('#toggleDisplayStyle').click(function () {
        if(this.style.display == 'block'){
            this.style.display = 'inline-block';
        } else {
            this.style.display = 'block';
        }
    });
    $('#toggleTextColor').click(function () {
        if(this.style.color == 'blue'){
            this.style.color = 'red';
        } else {
            this.style.color = 'blue';
        }
    });
    $('#togglePadding').click(function () {
        if(this.style.padding == '10px'){
            this.style.padding = '3px';
        } else {
            this.style.padding = '10px';
        }
    });
    //JQuery Effects
    $('#hide').click(function(){
        $(this).hide();
    });
    $('#show').click(function(){
        $('#hide').show();
    });
    $('#slideUp').click(function(){
        $(this).slideUp();
    });
    $('#slideDown').click(function(){
        $(this).slideDown();
    });
    $('#fadeOut').click(function(){
        $(this).fadeOut();
    });
    //JQuery Events
    $('#fadeInOnReady').hide();
    setTimeout(function(){$('#fadeInOnReady').fadeIn()},500);
    $('#opacityOnHover').hover(function(){
        this.style.opacity = '0.5';
    },function(){
        this.style.opacity = '1';
    });
    $('#hideOnDoubleClick').dblclick(function(){$(this).hide()});
    $('#disableOnFocus').focus(function(){setTimeout(function(){$('#disableOnFocus').prop('disabled',true)},500)});
    $('#disableOnFocus').blur(function(){this.disabled = false});
    $(window).resize(function(){
        $('#colorOnResize').css('background-color', 'rgb(100,200,255)');
    });
});
