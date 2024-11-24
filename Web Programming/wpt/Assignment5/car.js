var counter = 0;
var quearr = new Array();
var runcarID;
function start() {
  debugger;
  var f = document.getElementById("car");
  runcarID = window.setInterval(runcar, 25);
}
var initmargin=0;
var degree=0;
var topmargin=0;
var xaxis = document.getElementById("x");
var yaxis = document.getElementById("y");

function carDropped() {
  var ctext = document.getElementById("carText");
  ctext.style.display = "block";
  var fir = document.getElementById("crash");
  fir.style.display = "block";
  var f = document.getElementById("car");
  f.style.display = "none";
}

function runcar() {
  initmargin = initmargin + 5;

  var f = document.getElementById("car");
  f.style.marginLeft = initmargin + "px";
  x.value = initmargin;

  if (initmargin > 500) {
    degree = degree + 9;
    topmargin = topmargin + 10;

    f.style.marginTop = topmargin + "px";
    f.style.rotate = degree + "deg";
    y.value = topmargin;
  }
  if (topmargin > 380) {
    stop();
    carDropped();
  }
}

function stop() {
  window.clearInterval(runcarID);
}
