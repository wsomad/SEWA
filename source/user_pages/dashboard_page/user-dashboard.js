const formOpenButton = document.querySelector("#form-open"),
home = document.querySelector(".home2"),
formCloseButton = document.querySelector(".form_close");

formOpenButton.addEventListener("click", () => home.classList.add("show"))
formCloseButton.addEventListener("click", () => home.classList.remove("show"))