const formOpenButton = document.querySelector(".wallet_show"),
home = document.querySelector(".confirmation_form"),
formCloseButton = document.querySelector(".form_close");

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formCloseButton.addEventListener("click", () => home.classList.remove("show"));