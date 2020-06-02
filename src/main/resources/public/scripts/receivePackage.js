var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', getPackageTypes);
document.addEventListener('DOMContentLoaded', getPackagingTypes);
document.addEventListener('DOMContentLoaded', getRegions);
document.getElementById('region').addEventListener('change', getDistricts);
document.getElementById('district').addEventListener('change', getLocalities);
// document.getElementById('locality').addEventListener('change', getPostOffices);


function receivePackage() {
    event.preventDefault();

    var packageReceiving = {
        price: $('#anPrice').val(),
        weight: $('#pacWeight').val(),
        description: $('#desc').val(),
        packageType: $('#packType').val(),
        employee: JSON.parse(localStorage.getItem('currentUser')).id,
        postOfficeTo: $('#postOffice').val(),
        size: $('#pacSize').val(),
        payReceiver: $("#payRec").is(':checked', function () {
            $("#checkbox1").attr('value', 'true');
        }),
        receiver: $('#cusTo').val(),
        sender: $('#cusFrom').val(),
        deliveryPrice: $('#delivPrice').val(),
        packaging: $('#packagingId').val(),
    };

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

function getRegions() {
    $.ajax({
        url: basicURL + "/api/location/region/all",
        type: "GET"
    })
        .done(function (response) {
            var select = document.getElementById("region");
            for (var i = 0; i < response.length; i++) {
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode(response[i].name));
                opt.value = response[i].id;
                select.appendChild(opt);
            }
            getDistricts()
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}

function getDistricts() {
    var region = $('#region').val();
    $.ajax({
        url: basicURL + "/api/location/district/" + region,
        type: "GET"
    })
        .done(function (response) {
            $('#district').find('option').remove().end()
            var select = document.getElementById("district");
            for (var i = 0; i < response.length; i++) {
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode(response[i].name));
                opt.value = response[i].id;
                select.appendChild(opt);
            }
            getLocalities();
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}

function getLocalities() {
    var district = $('#district').val();
    $.ajax({
        url: basicURL + "/api/location/locality/" + district,
        type: "GET"
    })
        .done(function (response) {
            $('#locality').find('option').remove().end()
            var select = document.getElementById("locality");
            for (var i = 0; i < response.length; i++) {
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode(response[i].name));
                opt.value = response[i].id;
                select.appendChild(opt);
                getPostOffices();
            }
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}

function getPostOffices() {
    var locality =document.getElementById("locality").value;
    console.log(document.getElementById("locality").value)
    $.ajax({
        url: basicURL + "/api/post-office/" + locality,
        type: "GET"
    })
        .done(function (response) {
            $('#postOffice').find('option').remove().end()
            var select = document.getElementById("postOffice");
            for (var i = 0; i < response.length; i++) {
                var opt = document.createElement('option');
                opt.appendChild(document.createTextNode(response[i].name));
                opt.value = response[i].id;
                select.appendChild(opt);
            }
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}




