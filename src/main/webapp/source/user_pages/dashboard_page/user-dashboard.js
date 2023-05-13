const formOpenButton = document.querySelector(".wallet_show"),
home = document.querySelector(".home"),
subMenu = document.getElementById("subMenu"),
formContainer = document.querySelector(".form_container"),
formCloseButton = document.querySelector(".form_close");

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formCloseButton.addEventListener("click", () => home.classList.remove("show"));

function toggleMenu(){subMenu.classList.toggle("open-menu");}
