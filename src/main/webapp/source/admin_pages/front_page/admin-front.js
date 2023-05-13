const formOpenButton = document.querySelector("#form-open"),
home = document.querySelector(".home2"),
formContainer = document.querySelector(".form_container2"),
formCloseButton = document.querySelector(".form_close"),
loginButton = document.querySelector("#login"),
pwShowHide = document.querySelectorAll(".pw_hide");

formOpenButton.addEventListener("click", () => home.classList.add("show"))
formCloseButton.addEventListener("click", () => home.classList.remove("show"))

pwShowHide.forEach(icon => {
    icon.addEventListener("click", () => {
        let getPwInput = icon.parentElement.querySelector("input");
        if(getPwInput.type === "password") {
            getPwInput.type = "text";
            icon.classList.replace("fa-eye-slash", "fa-eye");
        }
        else {
            getPwInput.type = "password";
            icon.classList.replace("fa-eye", "fa-eye-slash");
        }
    })
})

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    formContainer.classList.remove("active");
});