bg = document.getElementById("main");
firstImg = document.getElementById("firstImg");
firstImgText = document.getElementById("firstImgText");
secondImgText = document.getElementById("secondImgText");
thirdmgText = document.getElementById("thirdImgText");
forthdmgText = document.getElementById("forthImgText");
commandDiv = document.getElementById("commandDiv");
footer = document.getElementById("footer");
footer2 = document.getElementById("footer2");
hold = document.getElementById("holdTag");
body = document.getElementsByName("body");

let isOpen = false;

function command() {
  commandDiv.style.visibility = "visible";
  commandDiv.style.zIndex = "2";
  main.style.opacity = "50%";
  isOpen = true;
}

function hideCommand() {
  if (!isOpen) {
    commandDiv.style.visibility = "hidden";
    main.style.opacity = "100%";
  }
  else
  isOpen = false;
}

function size() {
  firstImgText.style.transition = "0.5s all";
  firstImgText.style.marginLeft = "22%";
}

function size2() {
  secondImgText.style.transition = "0.5s all";
  secondImgText.style.marginLeft = "35%";
}

function size3() {
  thirdImgText.style.transition = "0.5s all";
  thirdImgText.style.marginLeft = "35%";
}

function size4() {
  forthImgText.style.transition = "0.5s all";
  forthImgText.style.marginLeft = "35%";
}

function resize() {
  firstImgText.style.marginLeft = "19%";
}
function resize2() {
  secondImgText.style.marginLeft = "33%";
}
function resize3() {
  thirdImgText.style.marginLeft = "33%";
}
function resize4() {
  forthImgText.style.marginLeft = "33%";
}

function giveStyle() {
  footer2.classList.add("emptySpace");
  holdTag.classList.add("holding");
  holdTag.classList.remove("notHolding");
}

function returnStyle() {
  footer2.classList.remove("emptySpace");
  holdTag.classList.remove("holding");
  holdTag.classList.add("notHolding");
}
