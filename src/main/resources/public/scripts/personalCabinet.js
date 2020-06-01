var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', getPackagesData);
document.addEventListener('DOMContentLoaded', getPackageTypes);
document.addEventListener('change', getPackagesData);


function getPackagesData() {
    var table = document.getElementById("usersHistoryTable");
    var filters = "";
    var packageTypeFilter = $('#packType').val()
    if (packageTypeFilter != ""){
        filters += "&packageType=" + packageTypeFilter;
    }
    console.log(JSON.parse(localStorage.getItem('currentUser')).id)
    $.ajax({
        url: basicURL + "/api/package/all?" +
            "userId= " +JSON.parse(localStorage.getItem('currentUser')).id +
            filters,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            var packages = response;
            for (var i = 0; i < packages.length; i++) {
                var row = table.insertRow();
                var package = packages[i];
                for (var j = 0; j < table.rows[0].cells.length; j++) {
                    row.insertCell();
                }
                console.log(package)
                table.rows[table.rows.length - 1].cells[0].appendChild(createLink(package.id));
                table.rows[table.rows.length - 1].cells[1].innerHTML = package.weight;
                table.rows[table.rows.length - 1].cells[2].innerHTML = package.price;
                table.rows[table.rows.length - 1].cells[3].innerHTML = package.size;

                table.rows[table.rows.length - 1].cells[4].innerHTML = package.description;
                table.rows[table.rows.length - 1].cells[5].innerHTML = package.packageType;

                table.rows[table.rows.length - 1].cells[6].innerHTML = package.owner.fullName;
                table.rows[table.rows.length - 1].cells[7].innerHTML = package.receiver.fullName;
            }
        })
        .fail(function (e) {
            custFromIdArr = [];
            custToIdArr = [];
            alert("ERROR:\n" + e.responseJSON.message);
        })
}

function createLink(packageId) {
    var link = document.createElement("a");
    link.setAttribute("href", "packageHistory.html?packageId=" + packageId)
    var linkText = document.createTextNode(packageId);
    link.appendChild(linkText);

    return link;
}
