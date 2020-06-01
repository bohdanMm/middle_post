var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', getHistory);

function getHistory() {
    var table = document.getElementById("usersHistoryTable");
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const packageId = urlParams.get('packageId')

    $.ajax({
        url: basicURL + "/api/history/" + packageId,
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            var histories = response;
            for (var i = 0; i < histories.length; i++) {
                var row = table.insertRow();
                var history = histories[i];
                for (var j = 0; j < table.rows[0].cells.length; j++) {
                    row.insertCell();
                }
                table.rows[table.rows.length - 1].cells[0].innerHTML = history.pac.id;
                table.rows[table.rows.length - 1].cells[1].innerHTML = history.postOffice.locality.name + " " + history.postOffice.name;
                table.rows[table.rows.length - 1].cells[2].innerHTML = history.receivingDate;
                table.rows[table.rows.length - 1].cells[3].innerHTML = history.isEndOffice ? "Yes" : "No";
            }
        })
        .fail(function (e) {
            custFromIdArr = [];
            custToIdArr = [];
            alert("ERROR:\n" + e.responseJSON.message);
        })
}