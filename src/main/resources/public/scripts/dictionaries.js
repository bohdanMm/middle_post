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
                opt.value = response[i].id;
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
                opt.value = response[i].id;
                select.appendChild(opt);
            }
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        })
}