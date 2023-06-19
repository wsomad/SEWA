const formOpenButton = document.querySelector(".wallet_show"),
subMenu = document.getElementById("subMenu"),
home = document.querySelector(".test1"),
formCloseButton = document.querySelector(".form_close");

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formCloseButton.addEventListener("click", () => home.classList.remove("show"));

function toggleMenu(){subMenu.classList.toggle("open-menu");}