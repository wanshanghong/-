var show = document.getElementById("show");
var mask = document.getElementById("mask");
show.onmousemove = function (ev) {
    mask.style.display = "block";
};
show.onmouseout = function (ev) {
    mask.style.display = "none";
};
mask.onmousemove = function (ev2) {
    mask.style.display = "block";
};
mask.onmouseout = function (ev) {
    mask.style.display = "none";
};
