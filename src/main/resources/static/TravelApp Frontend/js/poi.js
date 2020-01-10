"use strict";

// Poi functionality
function addPoi() {
    let poiName = document.getElementById("poiName").value;
    let poiLink = document.getElementById("link").value;
    axios
        .post('http://localhost:8080/poi/add', {
            poiName: poiName,
            link: poiLink
        })
        .then(res => console.log(res))
        .catch(error => console.log(error));
    getPoiName();
}




function deletePoi(id) {
    var id = document.getElementById("id").value;
    axios
        .delete('http://localhost:8080/poi/delete/' + id)
        .then(alert("Deleted"))
        .catch(error => console.log(error));
}

function getPoi(){
    getPoiName();
    getPoiLink()
}

function getPoiName() {
    axios
        .get('http://localhost:8080/poi/all')
        .then((res) => {
            showPoiNTable(res.data);
            console.log(res.data);
        })
        .catch((error) => {
            console.log(error);
        })
}

const poiN = document.getElementById("poiT");

function showPoiN(name) {
    poiN.innerHTML = "";
    for (let p of name) {
        const newPN = document.createElement("span");
        newPN.innerHTML = p.poiName + p.link;
        poiN.appendChild(newPN);
    }
}




function showPoiNTable(name) {
    var table = document.getElementById("poiTable");
    table.innerHTML ="";
    for (let p of name) {
        var row = table.insertRow(-1);
        var cell1  = row.insertCell(0);
        var cell2  = row.insertCell(1);
        console.log(p.poiName);
        console.log(p.link);
        cell1.innerHTML = p.poiName ;
        cell2.innerHTML = p.link ;

    }
}



function getPoiLink(){
    axios
        .get('http://localhost:8080/poi/all')
        .then((res)=>{
            showPoiNTable(res.data);
            console.log(res.data);
        })
        .catch((error) => {
            console.log(error);
        })
}

const poiL = document.getElementById("poi");
function showPoiL(link){
    poiL.innerHTML = "";
    for (let p of link) {
        const newPL = document.createElement("span");
        newPL.innerHTML = p.link;
        poiL.appendChild(newPL);
    }
}

