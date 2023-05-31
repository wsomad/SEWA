const formOpenButton = document.querySelector(".wallet_show"),
home = document.querySelector(".test1"),
formCloseButton = document.querySelector(".form_close");

formOpenButton.addEventListener("click", () => home.classList.add("show"));
formCloseButton.addEventListener("click", () => home.classList.remove("show"));