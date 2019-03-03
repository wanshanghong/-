//打开页面请求数据
function ajax1(huidiao) {
    var xhr = new XMLHttpRequest;
    xhr.open("post","loadAllPost.action");
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("11");
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var json = JSON.parse(xhr.responseText);
            for(var j = 0;j<json.length;j++){
                tiezibox = document.createElement("div");
                tiezibox.className = "tiezibox";
                zuixin.appendChild(tiezibox);
                tiezi = document.createElement("div");
                tiezi.className = "tiezi";
                tiezibox.appendChild(tiezi);
                touxianga = document.createElement("a");
                touxianga.className = "touxiang";
                tiezi.appendChild(touxianga);
                touxiangimg = document.createElement("img");
                touxiangimg.src = json[j].sender_photo;
                touxianga.appendChild(touxiangimg);
                namespan = document.createElement("span");
                namespan.innerHTML = json[j].sender_name;
                tiezi.appendChild(namespan);
                titlea = document.createElement("a");
                titlea.href = "post1.html";
                tiezi.appendChild(titlea);
                title = document.createElement("h1");
                title.innerHTML = json[j].post_name;
                titlea.appendChild(title);
                time = document.createElement("time");
                time.innerHTML = json[j].post_date.year;
                tiezi.appendChild(time);
                content = document.createElement("p");
                content.className = "tiezicontent";
                content.innerHTML = json[j].post_content;
                tiezi.appendChild(content);
                pic = document.createElement("div");
                pic.className = "tupian";
                tiezi.appendChild(pic);
                images = document.createElement("img");
                images.src = json[j].img_path1;
                pic.appendChild(images);
                var tupian = document.getElementsByClassName("tupian");
                for (i = 0; i < tupian.length; i++) {
                    if (tupian[i].children.length === 0) {
                        tupian[i].style.height = "0";
                    }
                }
                // //判断有多少张图片传来

                footer = document.createElement("footer");
                footer.innerHTML = "阅读量:";
                tiezi.appendChild(footer);
                footerspan = document.createElement("span");
                footerspan.innerHTML = "1234";
                footer.appendChild(footerspan);
                footera = document.createElement("a");
                footera.className = "look";
                footera.href = "javascript:void(0);";
                footera.innerHTML = "查看全文";
                footer.appendChild(footera);
                zandiv = document.createElement("div");
                zandiv.className = "zan";
                tiezi.appendChild(zandiv);
                zanul = document.createElement("ul");
                zandiv.appendChild(zanul);
                var Arr1 = ["收藏","分享","点赞","评论"];
                for(var k=0;k<4;k++){
                    zanli = document.createElement("li");
                    zanul.appendChild(zanli);
                    zanli.innerHTML = Arr1[k];
                    zanspan = document.createElement("span");
                    zanspan.innerHTML = "0";
                    zanli.appendChild(zanspan);
                }
                shouqi = document.createElement("a");
                shouqi.className = "unlook";
                shouqi.href = "javascript:void(0);";
                shouqi.style.display = "none";
                shouqi.innerHTML = "收起全文";
                tiezi.appendChild(shouqi);
                huidiao();
            }
        }
    }
}
ajax1(huidiao);
function huidiao() {
    var luntanheadlis = document.getElementById("luntanhead").children[0].children;
    function $(id) {return document.getElementById(id);}
    var zuixin = $("zuixin");
    var remen = $('remen');
    var wenda = $("wenda");
    for(var i = 0;i<luntanheadlis.length;i++) {
        luntanheadlis[i].index = i;
        luntanheadlis[i].onclick = function () {
            for (var j = 0; j < luntanheadlis.length; j++) {
                luntanheadlis[j].style.borderBottom = "0";
            }
            luntanheadlis[this.index].style.borderBottom = "3px solid #f2473d";
            if (this.index === 0) {
                show(zuixin);
                hide(remen);
                hide(wenda);
            }
            else if (this.index === 1) {
                show(remen);
                hide(zuixin);
                hide(wenda);
            }
            else if (this.index === 2) {
                show(wenda);
                hide(zuixin);
                hide(remen);
            }
        }
    }

    //
    function scroll() {
        if (window.pageYOffset != null) {   //兼容ie9+和其他浏览器
            return {
                left: pageXOffset,
                top: pageYOffset
            }
        }
        else if (document.compatMode === "CSS1Compat") {  //如果声明了文档头
            return {
                left: document.documentElement.scrollLeft,
                top: document.documentElement.scrollTop
            }
        }
        return {   //没有声明文档头
            left: document.body.scrollLeft,
            top: document.body.scrollTop
        }
    }


    //发帖btn
    var fatiebtn = document.getElementsByClassName("fatiebtn")[0];
    var luntanbody = document.getElementById("luntanbody");
    fatiebtn.onclick = function () {
        window.scrollTo(0,luntanbody.offsetHeight + 200);
    };


// //上传视频
// var file1 = document.getElementById("uploadvid");
// function uploadvid() {
//     file1.click();
// }
//
// function changevid() {
//         var reads1 = new FileReader();
//         var fd = file1.files[0];
//         reads1.readAsDataURL(fd);
//         reads1.onload = function (ev) {
//
//         }
// }
//查看全文
    var look = document.getElementsByClassName("look");
    var unlook = document.getElementsByClassName("unlook");
    var tupian = document.getElementsByClassName("tupian");
    var tiezicontent = document.getElementsByClassName("tiezicontent");
    var zan = document.getElementsByClassName("zan");
    for (i = 0; i < tupian.length; i++) {
        if (tupian[i].children.length === 0) {
            tupian[i].style.height = "0";
        }
    }
    for (i = 0; i < look.length; i++) {
        look[i].index = i;
        unlook[i].index = i;
        look[i].onclick = function () {
            tupian[this.index].style.height = "auto";
            hide(look[this.index].parentNode);
            unlook[this.index].style.display = "inline";
            tiezicontent[this.index].style.overflow = "visible";
            tiezicontent[this.index].style.whiteSpace = "normal";
            zan[this.index].style.display = "block";
            for(var j = 0;j<tupian[this.index].children.length;j++){
                tupian[this.index].children[j].style.height = "auto";
            }
        };
        unlook[i].onclick = function () {
            if (tupian[this.index].children.length === 0) {
                tupian[this.index].style.height = "0";
            }
            else {
                tupian[this.index].style.height = "120px";
            }
            look[this.index].parentNode.style.display = "inline";
            hide(unlook[this.index]);
            tiezicontent[this.index].style.overflow = "hidden";
            tiezicontent[this.index].style.whiteSpace = "nowrap";
            hide(zan[this.index]);
            for(var j = 0;j<tupian[this.index].children.length;j++){
                tupian[this.index].children[j].style.height = "120px";
            }
            window.scrollTo(0,tiezi[this.index].offsetTop);
        }
    }
    console.log(look,unlook);
//点赞功能
    for(i=0;i<zan.length;i++){
        zan[i].children[0].onclick = function (event) {
            var event = event || window.event;
            if(event.target == "[object HTMLLIElement]"){
                event.target.children[0].innerHTML++;
            }
            else if(event.target == "[object HTMLImageElement]"){
                event.target.parentNode.children[0].innerHTML++;
            }
            else if(event.target == "[object HTMLUListElement]"){

            }
            else{
                event.target.innerHTML++;
            }
        }
    }
//预览图片
    var mask = document.getElementsByClassName("yulan")[0];
    var imgs = document.getElementsByTagName("img");
    for (i = 0; i < imgs.length; i++) {
        imgs[i].index = i;
        imgs[i].onclick = function () {
            mask.children[0].src = imgs[this.index].src;
            show(mask);
        };
    }
    mask.onclick = function () {
        hide(mask);
    };


    //翻页
    // var fanyelis = document.getElementsByClassName("fanyekuang")[0].children[0].children;
    var tiezi = document.getElementsByClassName("tiezi");
    var shouye = document.getElementsByClassName('shouye')[0];
    var shangyiye = document.getElementsByClassName("shangyiye")[0];
    var weiye = document.getElementsByClassName("weiye")[0];
    var xiayiye = document.getElementsByClassName("xiayiye")[0];
    var flag = true;
    var flag2 = false;
    var current = 1;
    if(tiezi.length > 1){
        for(i = 0;i<tiezi.length;i++){
            fanyeli = document.createElement("li");
            fanyeli.innerHTML = i+1;
            document.getElementsByClassName("fanyekuang")[0].children[0].appendChild(fanyeli);
            if(i == 4){
                break;
            }
        }
        document.getElementsByClassName("fanyekuang")[0].children[0].children[0].className = "liang";
    }
    var hidepag = tiezi.length - 3;
    for(j=0;j<hidepag;j++){
        hide(tiezi[3+j]);
    }
    var fanyelis = document.getElementsByClassName("fanyekuang")[0].children[0].children;
    shouye.onclick = function () {
        current = 1;
        for(i=0;i<tiezi.length;i++){
            hide(tiezi[i]);
            show(tiezi[0]);
        }
        for (j = 0; j < fanyelis.length; j++) {
            fanyelis[j].className = "";
            fanyelis[j].innerHTML = j+1;
        }
        fanyelis[0].className = "liang";
        qiehuan();
    };
    shangyiye.onclick = function () {
        current = current - 1;
        for(i=0;i<tiezi.length;i++){
            hide(tiezi[i]);
            show(tiezi[current - 1]);
        }
        for (j = 0; j < fanyelis.length; j++) {
            fanyelis[j].className = "";
        }
        fanyelis[current - 1].className = "liang";
        qiehuan();
    };
    weiye.onclick = function () {
        current = tiezi.length;
        for(i=0;i<tiezi.length;i++){
            hide(tiezi[i]);
            show(tiezi[current - 1]);
        }
        for (j = 0; j < fanyelis.length; j++) {
            fanyelis[j].className = "";
            fanyelis[j].innerHTML = tiezi.length - 4 + j;
        }
        fanyelis[4].className = "liang";
        qiehuan();
    };
    xiayiye.onclick = function () {
        current = current + 1;
        for(i=0;i<tiezi.length;i++){
            hide(tiezi[i]);
            show(tiezi[current - 1]);
        }
        for (j = 0; j < fanyelis.length; j++) {
            fanyelis[j].className = "";
            // if(current > 2 && fanyelis[4].innerHTML < tiezi.length){
            //     fanyelis[j].innerHTML++;
            // }
        }
        fanyelis[current - 1].className = "liang";

        qiehuan();
    };
    for (i = 0; i < fanyelis.length; i++) {
        fanyelis[i].index = i;
        fanyelis[i].onclick = function () {
            for(var k =0;k<tiezi.length;k++){
                hide(tiezi[k]);
                show(tiezi[fanyelis[this.index].innerHTML - 1]);
            }
            for (j = 0; j < fanyelis.length; j++) {
                fanyelis[j].className = "";
                if(this.index > 1 && fanyelis[4].innerHTML < tiezi.length){
                    fanyelis[j].innerHTML++;
                    fanyelis[this.index - 1].className = "liang";
                }
                else if(this.index < 2 && fanyelis[4].innerHTML > fanyelis.length){
                    fanyelis[j].innerHTML--;
                    fanyelis[this.index + 1].className = "liang";
                }
                if(fanyelis[1].className == "liang" || fanyelis[2].className == "liang" || fanyelis[3].className == "liang" || fanyelis[4].className == "liang"){
                    continue;
                }
                else{
                    fanyelis[this.index].className = "liang";
                }
            }
            current = this.index + 1;
            qiehuan();
        };
        // function ishead() {
        //     if(flag){
        //         hide(shouye);
        //         hide(shangyiye);
        //         show(weiye);
        //         show(xiayiye);
        //     }
        //     else if(){
        //
        //     }
        // }
        // function islast() {
        //     if(flag2){
        //         show(shouye);
        //         show(shangyiye);
        //         show(weiye);
        //         show(xiayiye);
        //     }
        // }
        function qiehuan() {
            if(current == 1){
                hide(shouye);
                hide(shangyiye);
                show(weiye);
                show(xiayiye);
            }
            else if(current == tiezi.length){
                hide(weiye);
                hide(xiayiye);
                show(shouye);
                show(shangyiye);
            }
            else if(current != 0 && current != tiezi.length){
                show(shouye);
                show(shangyiye);
                show(weiye);
                show(xiayiye);
            }
        }
        qiehuan();
        }
}
huidiao();
//上传图片
var file = document.getElementById("uploadpic");
var k = 0;
var imgdiv, imgbox, img, span;
var form = document.getElementById('form1');
var Arrimg = [];
var Arradd = [];
var id = 0;

function uploadpic() {
    file.click();
}

function changepic() {
    var imgparent = document.getElementsByClassName("imgbox");
    var f = file.files;
    if (f.length + imgparent.length > 9) {
        alert("最多上传9张图片");
    }
    else {
        for (i = 0; i < f.length + imgparent.length; i++) {
            Arrimg[id] = f[i];
            Arradd[id] = URL.createObjectURL(f[i]);
            id++;
            var reads = new FileReader();
            reads.readAsDataURL(f[i]);
            reads.onload = function (ev) {
                if (k === 0) {
                    imgdiv = document.createElement("div");
                    imgdiv.className = "img";
                    form.insertBefore(imgdiv, submit);
                    imgbox = document.createElement("div");
                    imgbox.className = "imgbox";
                    imgdiv.appendChild(imgbox);
                    img = document.createElement("img");
                    img.src = this.result;
                    imgbox.appendChild(img);
                    span = document.createElement("span");
                    imgbox.appendChild(span);
                    span.innerHTML = "X";
                    k++;
                }
                else {
                    var imgbox = document.createElement("div");
                    imgbox.className = "imgbox";
                    imgdiv.appendChild(imgbox);
                    img = document.createElement("img");
                    img.src = this.result;
                    imgbox.appendChild(img);
                    span = document.createElement("span");
                    imgbox.appendChild(span);
                    span.innerHTML = "X";
                }
                img.onclick = function () {
                    var imgboxs = document.getElementsByClassName("imgbox");
                    for (j = 0; j < imgboxs.length; j++) {
                        imgboxs[j].style.position = "static";
                        hide(imgboxs[j].children[1]);
                    }
                    mask.children[0].src = this.src;
                    show(mask);
                    // img.parentNode.style.position = "";
                };
                mask.onclick = function () {
                    var imgboxs = document.getElementsByClassName("imgbox");
                    hide(mask);
                    for (j = 0; j < imgboxs.length; j++) {
                        imgboxs[j].style.position = "relative";
                        show(imgboxs[j].children[1]);
                    }
                };
                span.onclick = function () {
                    var del = this.parentNode;
                    var box = document.getElementsByClassName("imgbox");
                    for (i = 0; i < Arrimg.length; i++) {
                        if (box[i] == del) {
                            Arradd.splice(i, 1);
                        }
                    }
                    del.removeChild(del.children[0]);
                    del.parentNode.removeChild(del);
                };
            };
        }
    }
}
//发帖ajax
function ajax() {
    var fd = new FormData(form);
    for (i = 0; i < Arrimg.length - 1; i++) {
        fd.append("images", Arrimg[i]);
    }
    var title = fd.get("title");
    var content = fd.get("content");
    var xhr = new XMLHttpRequest;
    xhr.open("post", "sendpost1.action");
    xhr.setRequestHeader('Content-Type', 'multipart/form-data');
    xhr.send(fd);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            alert("接受成功");
            console.log(title,content,Arrimg);
        }
        else if(xhr.readyState == 4 && xhr.status != 200){
            alert("接受失败");
        }
    }
}
