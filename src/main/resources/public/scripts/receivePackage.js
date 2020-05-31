var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', getPackageTypes);
document.addEventListener('DOMContentLoaded', getPackagingTypes);
document.getElementById('icon').addEventListener('click', function () {
    window.location.href = '../index.html';
});

function getPackageTypes() {
    $.ajax({
        url: basicURL + "/api/dictionary/package-type",
        type: "GET"
    })
        .done(function (response) {
            var select = document.getElementById("packType");
            for (var i = 0; i < response.length; i++) {
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode(response[i].name));
                opt.value = 'response.name';
                opt.id = response[i].id;
                select.appendChild(opt);
            }
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}

function getPackagingTypes() {
    $.ajax({
        url: basicURL + "/api/dictionary/packaging",
        type: "GET"
    })
        .done(function (response) {
            var select = document.getElementById("packagingId");
            for (var i = 0; i < response.length; i++) {
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode(response[i].name));
                opt.value = 'response.name';
                opt.id = response[i].id;
                select.appendChild(opt);
            }
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}

function receivePackage() {
    event.preventDefault();

    var packageReceiving = {
        price: $('#anPrice').val(),
        weight: $('#pacWeight').val(),
        description: $('#desc').val(),
        packageType: $('#packType').find('option:selected').attr('id'),
        employee: JSON.parse(localStorage.getItem('currentUser')).id,
        postOfficeTo: $('#officeTo').val(),
        size: $('#pacSize').val(),
        payReceiver: $("#payRec").is(':checked', function () {
            $("#checkbox1").attr('value', 'true');
        }),
        receiver: $('#cusTo').val(),
        sender: $('#cusFrom').val(),
        deliveryPrice: $('#delivPrice').val(),
        packaging: $('#packagingId').find('option:selected').attr('id'),
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


