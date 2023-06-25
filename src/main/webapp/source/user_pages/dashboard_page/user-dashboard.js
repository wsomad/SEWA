const formOpenButton = document.querySelector(".wallet_show"),
formOpenButton2 = document.querySelector("#open_topup"),
home = document.querySelector(".home"),
walletMenu = document.getElementById("walletMenu"),
subMenu = document.getElementById("subMenu"),
formCloseButton = document.querySelector(".form_close");
notiMenu = document.getElementById("notificationMenu");
notiItem = document.querySelector(".notification_item");
down = false;
serviceLink = document.getElementById('service-link');
serviceDropdown = document.getElementById('service-dropdown');

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formOpenButton2.addEventListener("click", () => home.classList.add("show"));
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

serviceLink.addEventListener('click', (e) => {
    e.preventDefault();
    serviceDropdown.classList.toggle('active');
});
