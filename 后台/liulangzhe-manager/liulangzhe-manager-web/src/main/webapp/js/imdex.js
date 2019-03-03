function $(id) {return document.getElementById(id);}
var lis = $("main-l").children[0].children;
for (var i = 0; i<lis.length; i++){
    lis[i].index = i;
    lis[i].onclick = function () {
        for (var j = 0; j < lis.length; j++) {
            lis[j].className = "";
        }
        lis[this.index].className = "bd1";
    };
}