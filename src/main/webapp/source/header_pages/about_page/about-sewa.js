const serviceLink = document.getElementById('service-link');
const serviceDropdown = document.getElementById('service-dropdown');

serviceLink.addEventListener('click', (e) => {
    e.preventDefault();
    serviceDropdown.classList.toggle('active');
});