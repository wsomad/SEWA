// MenuToggle
toggle = document.querySelector('.toggle');
nav = document.querySelector('.nav');
main = document.querySelector('.main-div');
subMenu = document.getElementById("subMenu"),

toggle.onclick = function(){
    nav.classList.toggle('active');
    main.classList.toggle('active');
}
function toggleMenu(){subMenu.classList.toggle("open-menu");}

