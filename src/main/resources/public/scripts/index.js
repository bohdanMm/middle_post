

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = 'index.html';
});

document.addEventListener('DOMContentLoaded', showUserInHeader);

function logOut(){
    localStorage.clear();
    window.location.href = 'index.html';
}
