const formOpenButton = document.querySelector(".wallet_show"),
subMenu = document.getElementById("subMenu"),
home = document.querySelector(".home"),
formCloseButton = document.querySelector(".form_close");
notiMenu = document.getElementById("notificationMenu");
down = false;

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formCloseButton.addEventListener("click", () => home.classList.remove("show"));

function toggleMenu() {
    subMenu.classList.toggle("open-menu");
}

function toggleNotification() {
    if(down) {
        notiMenu.style.height = '0px';
        notiMenu.style.opacity = 0;
        down = false;
    }
    else {
        notiMenu.style.height = '400px';
        notiMenu.style.opacity = 1;
        down = true;
    }
}