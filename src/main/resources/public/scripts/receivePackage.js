var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', getPackageTypes);
document.addEventListener('DOMContentLoaded', getPackagingTypes);
document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function receivePackage() {
    event.preventDefault();

    var packageReceiving = {
        price: $('#anPrice').val(),
        weight: $('#pacWeight').val(),
        description: $('#desc').val(),
        packageType: $('#packType').val(),
        employee: JSON.parse(localStorage.getItem('currentUser')).id,
        postOfficeTo: $('#officeTo').val(),
        size: $('#pacSize').val(),
        payReceiver: $("#payRec").is(':checked', function () {
            $("#checkbox1").attr('value', 'true');
        }),
        receiver: $('#cusTo').val(),
        sender: $('#cusFrom').val(),
        deliveryPrice: $('#delivPrice').val(),
        packaging: $('#packagingId').val(),
    };

    console.log(packageReceiving);

    $.ajax({
        url: basicURL + "/api/package-receiving/create",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(packageReceiving)
    })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        });

}


