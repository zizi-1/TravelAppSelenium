"use strict";

// Poi functionality
function addPois() {
    axios
        .post('http://localhost:8080/poi/add', {
            poiName: document.getElementById("poiName").value,
            link: document.getElementById("link").value,
        })
        .then(alert("Your place of interest has been added"))
        .catch(error => console.log(error));
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
            showPoiN(res.data);
            console.log(res.data);
        })
        .catch((error) => {
            console.log(error);
        })
}

const poiN = document.getElementById("poiTable");

function showPoiN(name) {
    poiN.innerHTML = "";
    for (let p of name) {
        const newPN = document.createElement("span");
        newPN.innerHTML = p.poiName;
        poiN.appendChild(newPN);
    }
}

function getPoiLink(){
    axios
        .get('http://localhost:8080/poi/all')
        .then((res)=>{
            showPoiL(res.data);
            console.log(res.data);
        })
        .catch((error) => {
            console.log(error);
        })
}

const poiL = document.getElementById("poiTable");
function showPoiL(link){
    poiL.innerHTML = "";
    for (let p of link) {
        const newPL = document.createElement("span");
        newPL.innerHTML = p.poiName;
        poiL.appendChild(newPL);
    }
}

