var isLogIn;

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function showUserInHeader() {
    console.log("show user in header");
    if (localStorage.length == 0) {
        document.getElementById("references").innerHTML = '<a href="pages/signIn.html" class="refs">Sign in</a> <a href="pages/signUp.html" class="refs">Sign up</a>';
    } else {
        var re = new RegExp("/*index.html/*");
        var prefix = "";
        if (re.test(window.location.href)) {
            prefix = "pages/";
        }

        var refrences = document.getElementById('references');
        var pageHref = document.createElement("a");
        var href;
        if (JSON.parse(localStorage.getItem('currentUser')).userRole == "admin") {
            href = prefix + "adminPage.html";
            pageHref.innerHTML = JSON.parse(localStorage.getItem('currentUser')).fullName;
        } else if (JSON.parse(localStorage.getItem('currentUser')).userRole == "employee") {
            href = prefix + "receivePackage.html";
            pageHref.innerHTML = "Receive package";
            var historyHref = document.createElement("a");
            historyHref.innerHTML = "History";
            historyHref.href = prefix + "historyRecord.html";
            historyHref.className = "refs";
            refrences.appendChild(historyHref);
            console.log(historyHref)
            console.log(refrences)
        } else {
            href = prefix + "personalCabinet.html";
            pageHref.innerHTML = JSON.parse(localStorage.getItem('currentUser')).fullName;
        }
        pageHref.href = href;
        pageHref.className = "refs";
        refrences.appendChild(pageHref);
        var exit = document.createElement("a");
        exit.className = "refs";
        exit.href = "#";
        exit.addEventListener("click", logOut);
        exit.innerHTML = "Log out";
        refrences.appendChild(exit);
    }
}

function logOut() {
    sessionStorage.clear();
    window.location.href = '../index.html';
}