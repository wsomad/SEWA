const formOpenButton = document.querySelector(".wallet_show"),
formOpenButton2 = document.querySelector("#open_topup"),
home = document.querySelector(".home"),
walletMenu = document.getElementById("walletMenu"),
subMenu = document.getElementById("subMenu"),
formCloseButton = document.querySelector(".form_close");
serviceLink = document.getElementById('service-link');
serviceDropdown = document.getElementById('service-dropdown');

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formOpenButton2.addEventListener("click", () => home.classList.add("show"));
formCloseButton.addEventListener("click", () => home.classList.remove("show"));

function toggleMenu(){subMenu.classList.toggle("open-menu");}

serviceLink.addEventListener('click', (e) => {
    e.preventDefault();
    serviceDropdown.classList.toggle('active');
});