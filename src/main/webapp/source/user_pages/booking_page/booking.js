const formOpenButton = document.querySelector(".wallet_show"),
subMenu = document.getElementById("subMenu"),
home = document.querySelector(".test1"),
formCloseButton = document.querySelector(".form_close");
notiMenu = document.getElementById("notificationMenu");
notiItem = document.querySelector(".notification_item");
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
        notiMenu.style.height = 'auto';
        notiMenu.style.opacity = 1;
        down = true;
    }
}