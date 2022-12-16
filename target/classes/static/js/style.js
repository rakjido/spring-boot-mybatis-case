const toggleBtn = document.querySelector('.navbar__toggleBtn');
const menu = document.querySelector('.navbar__menu');
const auth = document.querySelector('.navbar__auth');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
    auth.classList.toggle('active');
});