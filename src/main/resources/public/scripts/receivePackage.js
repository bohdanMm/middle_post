var basicURL = "http://localhost:8080";

document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function receivePackage() {
    event.preventDefault();

    var package = {
        price: $('#anPrice').val(),
        weight: $('#pacWeight').val(),
        size: $('#pacSize').val(),
        owner: $('#cusFrom').val(),
        description: $('#desc').val(),
        packageType: $('#packageType').val()
    };

    console.log(package);

    var pac;

    $.ajax({
        url: basicURL + "/api/package/create",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(package)
    })
        .done(function (response) {
            sendPackReceiving(response);
        })
        .fail(function (e) {
            sessionStorage.clear();
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        });

    window.setTimeout( sendPackReceiving , 2000, pac);

}

function sendPackReceiving(pac){

    console.log(pac);

    var packageReceiving = {
        employee: JSON.parse(localStorage.getItem('currentUser')).id,
        postOfficeTo: $('#postOfficeTo').val(),
        size: $('#pacSize').val(),
        payReceiver: $('#payRec').val(),
        receiver: $('#cusTo').val(),
        sender: $('#cusFrom').val(),
        deliveryPrice: $('#delivPrice').val(),
        packaging: $('#packagingId').val(),
        pack: pac.id,
    };

    console.log(packageReceiving);
}

