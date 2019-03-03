function $(id) {return document.getElementById(id);}
function show(obj){obj.style.display = "block"}
function hide(obj) {obj.style.display = "none";
}
function scroll() {
    if(window.pageYOffset != null){   //兼容ie9+和其他浏览器
        return {
            left:pageXOffset,
            top:pageYOffset
        }
    }
    else if(document.compatMode === "CSS1Compat"){  //如果声明了文档头
        return {
            left:document.documentElement.scrollLeft,
            top: document.documentElement.scrollTop
        }
    }
    return {   //没有声明文档头
        left:document.body.scrollLeft,
        top:document.body.scrollTop
    }
}
function client() {
    if(window.innerWidth != null){
        return {
            width:window.innerWidth,
            height:window.innerHeight
        }
    }
    else if(document.compatMode === "CSS1Compat"){
        return {
            width:document.documentElement.clientWidth,
            height:document.documentElement.clientHeight
        }
    }
    return {
        width:document.body.clientWidth,
        height:document.body.clientHeight
    }
}
var fenlei = $("fenlei");
var mask = $("mask");
fenlei.onmousemove = function (ev) {
    mask.style.display = "block";
};
fenlei.onmouseout = function (ev) {
    mask.style.display = "none";
};
mask.onmousemove = function (ev2) {
    mask.style.display = "block";
    fenlei.className = "fenlei bd2";
};
mask.onmouseout = function (ev) {
    mask.style.display = "none";
    fenlei.className = "fenlei";
};




