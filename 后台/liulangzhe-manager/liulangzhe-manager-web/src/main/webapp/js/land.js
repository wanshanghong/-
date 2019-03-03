var land = document.getElementById("land");
var zhuce = document.getElementById("zhuce");
var zhucetable = document.getElementById("zhucetable");
var landtable = document.getElementById("landtable");
var err = document.getElementById("err");
var zhanghao = document.getElementById("zhanghao");
var mima = document.getElementById("mima");
land.onclick = function (ev) {
    land.className = "land bd";
    zhuce.className = "zhuce";
    zhucetable.style.display = "none";
    landtable.style.display = "block";
    window.getSelection?window.getSelection().removeAllRanges():document.selection.empty();
    document.title = "登陆 - 流浪者";
};
zhuce.onclick = function (ev) {
    zhuce.className = "zhuce bd";
    land.className = "land";
    zhucetable.style.display = "block";
    landtable.style.display = "none";
    window.getSelection?window.getSelection().removeAllRanges():document.selection.empty();
    document.title = "注册 - 流浪者"
};
var x,y;
zhanghao.oninput = function (ev) {
    x = zhanghao.value;
};
mima.oninput = function (ev) {
    y = mima.value;
};
function login() {
    var xhr = new XMLHttpRequest;
    xhr.open("post","login.action");
    xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
    xhr.send('username=zhangsan&password=123456');
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4 && xhr.status == 200 && xhr.responseText == false){
            err.style.display = "block";
        }
        else if(xhr.readyState == 4 && xhr.status == 200 && xhr.responseText == true){
            window.location.href='index.html';
        }
    }
}











