"use strict";


function displayDetails() {
  addDetail();
  getCountdown();
  getAllD();
  getCountdown();
}

function thingsToDo() {
  window.open("https://www.tripadvisor.co.uk/?fid=88fcde45-5a56-4c19-be9c-1718ed412c74", "_blank");
}


function getAllD() {
  getOrigin();
  getDestination();
  getDateFrom()
  getDateTo()
}
function getDateTo() {
  axios
      .get('/details/getAll')
      .then((res) => {
        showDateTo(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
}
const dateToDetails = document.getElementById("dt");
function showDateTo(dateT) {
  dateToDetails.innerHTML = "";
  for (let x of dateT) {
    const newDT = document.createElement("span");
    newDT.innerHTML = formatDate(x.dateTo);
    dateToDetails.appendChild(newDT);
  }
}
function getDateFrom() {
  axios
      .get('/details/getAll')
      .then((res) => {
        showDateFrom(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
}
const dateFromDetails = document.getElementById("df");
function showDateFrom(dateF) {
  dateFromDetails.innerHTML = "";
  for (let x of dateF) {
    const newDF = document.createElement("span");
    newDF.innerHTML = formatDate(x.dateFrom);
    dateFromDetails.appendChild(newDF);
  }
}
function getDestination() {
  axios
      .get('/details/getAll')
      .then((res) => {
        showDestination(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
}
const destinationDetails = document.getElementById("d");
function showDestination(trip) {
  destinationDetails.innerHTML = "";
  for (let x of trip) {
    const newD = document.createElement("span");
    newD.innerHTML = x.destination;
    destinationDetails.appendChild(newD);
  }
}
function getOrigin() {
  axios
      .get('/details/getAll')
      .then((res) => {
        showOrigin(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
}
const tripDetails = document.getElementById("o");
function showOrigin(trip) {
  tripDetails.innerHTML = "";
  for (let x of trip) {
    const newO = document.createElement("span");
    newO.innerHTML = x.origin;
    tripDetails.appendChild(newO);
  }
}






function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}





function addDetail() {
  axios
    .post('/details/add', {
      origin: document.getElementById("origin").value,
      destination: document.getElementById("destination").value,
      dateFrom: document.getElementById("dateFrom").value,
      dateTo: document.getElementById("dateTo").value,
    })
    .then(res => console.log(res))
    .catch(error => console.log(error));
}

function updateDetail() {
  axios
    .patch('/details/update/1', {
      origin: document.getElementById("origin").value,
      destination: document.getElementById("destination").value,
      dateFrom: document.getElementById("dateFrom").value,
      dateTo: document.getElementById("dateTo").value,
    })
    .then(res => console.log(res))
    .catch(error => console.log(error));
}

function deleteDetail() {
  axios
    .delete('/details/delete/2')
    .then(alert("The details have been deleted"))
    .catch(error => console.log(error));
}






//   countdown ----->
var target_date = new Date.getTime() + (dateSeconds()); // set the countdown date
var days, hours, minutes, seconds; // variables for time units

var countdown = document.getElementById("tiles");


setInterval(function () { getCountdown(); }, 1000);

function getCountdown() {

  // find the amount of "seconds" between now and target
  var current_date = new Date().getTime();
  var seconds_left = (target_date - current_date) / 1000;

  days = pad(parseInt(seconds_left / 86400));
  seconds_left = seconds_left % 86400;

  hours = pad(parseInt(seconds_left / 3600));
  seconds_left = seconds_left % 3600;

  minutes = pad(parseInt(seconds_left / 60));
  seconds = pad(parseInt(seconds_left % 60));

  // format countdown string
  countdown.innerHTML = "<span>" + days + "</span><span>" + hours + "</span><span>" + minutes + "</span><span>" + seconds + "</span>";
}

function pad(n) {
  return (n < 10 ? '' : '') + n;
}

function dateSeconds() {
  var _initial = getDateFrom().value;
  var fromTime = new Date(_initial);
  var toTime = new Date();

  var differenceTravel = fromTime.getTime() - toTime.getTime();
  var seconds = Math.floor(differenceTravel);
  return seconds;
}

