var basicURL = "http://localhost:8080";

document.addEventListener('DOMContentLoaded', showUserInHeader);

function makeHistoryRecord() {
    event.preventDefault();

    var historyRecord = {
        postOffice: $('#postOff').val(),
        isEndOffice: $("#isEndOff").is(':checked', function () {
            $("#isEndOff").attr('value', 'true');
        }),
        employee: JSON.parse(localStorage.getItem('currentUser')).id,
        pac: $('#pac').val()
    };

    console.log(historyRecord);

    $.ajax({
        url: basicURL + "/api/history/create",
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(historyRecord)
    })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
        });

}


