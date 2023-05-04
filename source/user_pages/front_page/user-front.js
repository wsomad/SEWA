const formOpenButton = document.querySelector("#form-open"),
home = document.querySelector(".home"),
formContainer = document.querySelector(".form_container"),
formCloseButton = document.querySelector(".form_close"),
signUpButton = document.querySelector("#signup"),
loginButton = document.querySelector("#login"),
pwShowHide = document.querySelectorAll(".pw_hide");
serviceLink = document.getElementById('service-link');
serviceDropdown = document.getElementById('service-dropdown');

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

signUpButton.addEventListener("click", (e) => {
    e.preventDefault();
    formContainer.classList.add("active");
});
loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    formContainer.classList.remove("active");
});
serviceLink.addEventListener('click', (e) => {
    e.preventDefault();
    serviceDropdown.classList.toggle('active');
});