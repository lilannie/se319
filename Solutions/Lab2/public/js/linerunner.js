var c = document.getElementById("linerunner");
var ctx = c.getContext("2d");
// 0 = >
// 1 = v
// 2 = <
// 3 = ^
var dir = 0;
var start = false;
var x = 5;
var y = 100;
var vel = 1;

function toggleStart(){
    var play_pause = document.getElementById('playpause');
    if(start){
        console.log('stop');
        play_pause.innerHTML = '<i class="fa fa-play"></i>Start';
        start = !start;
    } else {
        console.log('start');
        play_pause.innerHTML = '<i class="fa fa-stop"></i>Stop';
        start = !start;
        run();
    }
}

function turnRight(){
    if(dir < 3) {
        dir++;
    } else {
        dir = 0;
    }
}
function turnLeft(){
    if(dir > 0){
        dir--;
    }
    else {
        dir = 3;
    }
}

function run(){
    setInterval(draw, 50);
}


function draw(){
    if(start) {
        ctx.fillStyle = '#f00';
        ctx.fillRect(x, y, 5, 5);
        switch (dir) {
            case 0:
                x += vel;
                break;
            case 1:
                y += vel;
                break;
            case 2:
                x -= vel;
                break;
            case 3:
                y -= vel;
                break;
        }
    }
}
