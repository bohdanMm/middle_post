var basicURL = "http://localhost:8080/api";

document.addEventListener('DOMContentLoaded', showUserInHeader);
document.addEventListener('DOMContentLoaded', setElemVisability);
document.addEventListener('DOMContentLoaded', getRegionTable);
// document.addEventListener('DOMContentLoaded', function () {
//     getDistrictTable(regionPage);
// });
// document.addEventListener('DOMContentLoaded', function () {
//     getLocalityesTable(localityPage);
// });
//
// document.getElementById("itemToConfigure").addEventListener('change', setElemVisability);
//
// document.addEventListener('DOMContentLoaded', getRegionForSelect);
//
// document.getElementById("itemToConfigure").addEventListener('change', getDistrictForLocalitySelect);
// document.getElementById("localityDistrSel").addEventListener('change', getDistrictForLocalitySelect);



function setElemVisability() {
    var choose = document.getElementById("itemToConfigure").value;
    var myOpts = document.getElementById('itemToConfigure').options;
    // var rememberOpt;
    for (var i = 0; i < myOpts.length; i++) {
        var opt = myOpts[i].value;
        if (opt == choose) {
            showItems("." + opt);
            //    rememberOpt = opt;
            //    var whatToDo = document.querySelector('select'+ "." +opt);
            //    whatToDo.addEventListener('change', function(){
            //     for(var j = 0; j < whatToDo.options.length; j++){
            //         if(whatToDo.options[j].value == whatToDo.value){
            //             console.log("." + rememberOpt + " ." + whatToDo.value);
            //             showItems("." + rememberOpt + " ." + whatToDo.value);
            //         } else {
            //             hideItems("." + rememberOpt + " ." + whatToDo.value);
            //         }
            //     }
            // });
        } else {
            hideItems("." + opt);
        }
    }
}

function showItems(querySel) {
    var showItems = document.querySelectorAll(querySel);
    for (var j = 0; j < showItems.length; j++) {
        showItems[j].style.display = 'flex';
    }
}

function hideItems(querySel) {
    var showItems = document.querySelectorAll(querySel);
    for (var j = 0; j < showItems.length; j++) {
        showItems[j].style.display = 'none';
    }
}
//
// function saveRegion() {
//     event.preventDefault();
//     var districtForSave = {
//         districtName: $('#distrName').val(),
//     };
//     document.getElementById("distrName").value = "";
//
//     $.ajax({
//         url: basicURL + "/district/create",
//         type: "POST",
//         dataType: "json",
//         contentType: "application/json",
//         data: JSON.stringify(districtForSave)
//     })
//         .done(function (data) {
//             var table = document.getElementById("distrTable");
//             for (var i = table.rows.length - 1; i > 0; i--) {
//                 table.deleteRow(i);
//             }
//             distrPage = 0;
//             getDistrictTable(distrPage);
//         })
//         .fail(function (e) {
//             alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
//         });
// }
//
function getRegionTable(page) {
    $.ajax({
        url: basicURL + "/location/region/all",
        type: "GET",
        dataType: "json"
    })
        .done(function (response) {
            var table = document.getElementById("regionTable");
            for (var i = 0; i < response.length; i++) {
                var row = table.insertRow();
                var region = response[i];
                for (var j = 0; j < table.rows[0].cells.length + 1; j++) {
                    row.insertCell();
                };
                table.rows[table.rows.length - 1].cells[0].innerHTML = region.id;
                table.rows[table.rows.length - 1].cells[1].innerHTML = region.name;
                table.rows[table.rows.length - 1].cells[2].innerHTML = '<button onclick="deleteRegion(' + region.id + ')">X</button>';

            }
        })
        .fail(function (e) {
            alert("Error in load districts. " + e.responseJSON.message)
        })
}

function deleteRegion(id) {
    $.ajax({
        url: basicURL + "/location/region/delete/" + id,
        type: "DELETE",
        dataType: "json"
    })
        .done(function (data) {
            var table = document.getElementById("regionTable");
            for (var i = table.rows.length - 1; i > 0; i--) {
                table.deleteRow(i);
            }
            getRegionTable();
        })
        .fail(function (e) {
            alert("ERROR:\n" + e.responseJSON.message);
        })
}
//
//
// function saveDistrict() {
//     event.preventDefault();
//     var regionForSave = {
//         regionName: $("#regionName").val(),
//         districtName: $('#refionDistrSel').val()
//     };
//     document.getElementById("regionName").value = "";
//
//     $.ajax({
//         url: basicURL + "/region",
//         type: "POST",
//         dataType: "json",
//         contentType: "application/json",
//         data: JSON.stringify(regionForSave)
//     })
//         .done(function (data) {
//             var table = document.getElementById("regionTable");
//             for (var i = table.rows.length - 1; i > 0; i--) {
//                 table.deleteRow(i);
//             }
//             regionPage = 0;
//             getRegionTable(distrPage);
//         })
//         .fail(function (e) {
//             alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
//         });
// }
//
// function getDistrictTable() {
//     var url = basicURL;
//     $.ajax({
//         url: basicURL + "/location/region",
//         type: "GET",
//         dataType: "json"
//     })
//         .done(function (response) {
//             var regions = response.data;
//             var table = document.getElementById("regionTable");
//             for (var i = 0; i < regions.length; i++) {
//                 var row = table.insertRow();
//                 var region = regions[i];
//                 for (var j = 0; j < table.rows[0].cells.length + 1; j++) {
//                     row.insertCell();
//                 };
//                 table.rows[table.rows.length - 1].cells[0].innerHTML = region.id;
//                 table.rows[table.rows.length - 1].cells[1].innerHTML = region.regionName;
//                 table.rows[table.rows.length - 1].cells[2].innerHTML = region.districtName;
//                 table.rows[table.rows.length - 1].cells[3].innerHTML = '<button onclick="deleteDistrict(' + region.id + ')">X</button>';
//
//             }
//         })
//         .fail(function (e) {
//             alert("Error in load regions. " + e.responseJSON.message)
//         })
// }
//
// function deleteDistrict(id) {
//     $.ajax({
//         url: basicURL + "/region?id=" + id,
//         type: "DELETE",
//         dataType: "json"
//     })
//         .done(function (data) {
//             var table = document.getElementById("regionTable");
//             for (var i = table.rows.length - 1; i > 0; i--) {
//                 table.deleteRow(i);
//             }
//             regionPage = 0;
//             getDistrictTable(distrPage);
//         })
//         .fail(function (e) {
//             alert("ERROR:\n" + e.responseJSON.message);
//         })
// }
//
// function getRegionForSelect() {
//     var url = basicURL + "api/region/all";
//     $.ajax({
//         url: url,
//         type: "GET",
//         dataType: "json"
//     })
//         .done(function (response) {
//             var regions = response;
//             var distrSelects = document.getElementsByClassName('regionSelect');
//             for (var i = 0; i < regions.length; i++) {
//                 var region = regions[i];
//                 var opt = document.createElement('option');
//                 opt.value = region.districtName;
//                 opt.innerHTML = region.districtName;
//                 for (var j = 0; j < distrSelects.length; j++) {
//                     distrSelects[j].appendChild(opt.cloneNode(true));
//                 }
//             }
//         })
//         .fail(function (e) {
//             alert("Error in load districts. " + e.responseJSON.message)
//         })
// }
//
// function getDistrictForLocalitySelect() {
//     var url = basicURL + "/district/byName?name=" + document.getElementsByClassName("distrSelect")[1].value;
//     $.ajax({
//         url: url,
//         type: "GET",
//         dataType: "json",
//         async: false
//     })
//         .done(function (response) {
//             var regions = response.regions;
//             var regionSelect = document.getElementById('localityRegionSel');
//             for (i = regionSelect.options.length - 1; i >= 0; i--) {
//                 regionSelect.remove(i);
//             }
//             for (var i = 0; i < regions.length; i++) {
//                 var region = regions[i];
//                 var opt = document.createElement('option');
//                 opt.value = region.regionName;
//                 opt.innerHTML = region.regionName;
//                 regionSelect.appendChild(opt);
//             }
//         })
//         .fail(function (e) {
//             alert("Error in load regions. " + e.responseJSON.message)
//         })
// }
//
// function saveLocality() {
//     event.preventDefault();
//     var localityForSave = {
//         regionName: $("#localityRegionSel").val(),
//         districtName: $('#localityDistrSel').val(),
//         localityName: $('#localityName').val()
//     };
//
//     $.ajax({
//         url: basicURL + "/locality",
//         type: "POST",
//         dataType: "json",
//         contentType: "application/json",
//         data: JSON.stringify(localityForSave)
//     })
//         .done(function (data) {
//             var table = document.getElementById("loclaitiesTable");
//             for (var i = table.rows.length - 1; i > 0; i--) {
//                 table.deleteRow(i);
//             }
//             localityPage = 0;
//             getLocalityesTable(localityPage);
//         })
//         .fail(function (e) {
//             alert("ERROR:\n" + e.responseJSON.errors[0].defaultMessage);
//         });
// }
//
// function getLocalityesTable(page) {
//     var url = basicURL + "/locality?page= " + page + "&size=20&sortBy=localityName&direction=ASC";
//     $.ajax({
//         url: url,
//         type: "GET",
//         dataType: "json"
//     })
//         .done(function (response) {
//             var localities = response.data;
//             var table = document.getElementById("loclaitiesTable");
//             for (var i = 0; i < localities.length; i++) {
//                 var row = table.insertRow();
//                 var locality = localities[i];
//                 for (var j = 0; j < table.rows[0].cells.length + 1; j++) {
//                     row.insertCell();
//                 };
//                 table.rows[table.rows.length - 1].cells[0].innerHTML = locality.id;
//                 table.rows[table.rows.length - 1].cells[1].innerHTML = locality.localityName;
//                 table.rows[table.rows.length - 1].cells[2].innerHTML = locality.districtName;
//                 table.rows[table.rows.length - 1].cells[3].innerHTML = locality.regionName;
//                 table.rows[table.rows.length - 1].cells[4].innerHTML = '<button onclick="deleteLocality(' + locality.id + ')">X</button>';
//
//             }
//         })
//         .fail(function (e) {
//             alert("Error in load localityes. " + e.responseJSON.message)
//         })
// }
//
// function deleteLocality(id) {
//     $.ajax({
//         url: basicURL + "/locality?id=" + id,
//         type: "DELETE",
//         dataType: "json"
//     })
//         .done(function (data) {
//             var table = document.getElementById("loclaitiesTable");
//             for (var i = table.rows.length - 1; i > 0; i--) {
//                 table.deleteRow(i);
//             }
//             localityPage = 0;
//             getLocalityesTable(localityPage);
//         })
//         .fail(function (e) {
//             alert("ERROR:\n" + e.responseJSON.message);
//         })
// }