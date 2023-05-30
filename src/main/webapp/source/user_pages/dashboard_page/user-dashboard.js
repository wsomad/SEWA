const formOpenButton = document.querySelector(".wallet_show"),
formOpenButton2 = document.querySelector(".topup"),
home = document.querySelector(".home"),
home2 = document.querySelector(".home2"),
walletMenu = document.getElementById("walletMenu"),
subMenu = document.getElementById("subMenu"),
formCloseButton = document.querySelector(".form_close");

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formOpenButton2.addEventListener("click", () => home2.classList.add("show"));
formCloseButton.addEventListener("click", () => home.classList.remove("show"));

function toggleMenu(){subMenu.classList.toggle("open-menu");}
function toggleWallet(){subMenu.classList.toggle("open-wallet");}
