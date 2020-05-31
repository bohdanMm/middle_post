var basicURL = "http://localhost:8080/api";

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function login() {

    console.log("Log in.");
    event.preventDefault();

    var customerForLogIn = {
        email: $('#email').val(),
        password: $('#pass').val()
    };

    $.ajax({
        url: basicURL + "/auth/login",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(customerForLogIn)
    })
        .done(function (response) {
            localStorage.setItem('currentUser', JSON.stringify(response));
            window.location.href = '../index.html';
        })
        .fail(function (e) {
            sessionStorage.clear();
            alert("ERROR:\n" + e.responseJSON.message);
        })
}