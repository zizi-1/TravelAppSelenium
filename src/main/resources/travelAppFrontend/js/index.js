function startUpDetails() {
  displayDetails();
  clearInputs();
}


function clearInputs() {
  document.getElementById('origin').value = '';
  document.getElementById('destination').value = '';
  document.getElementById('dateFrom').value = '';
  document.getElementById('dateTo').value = '';
}

function displayDetails() {
  var o = document.getElementById("origin").value;
  document.getElementById("o").innerHTML = o;

  var d = document.getElementById("destination").value;
  document.getElementById("d").innerHTML = d;

  var df = document.getElementById("dateFrom").value;
  document.getElementById("df").innerHTML = df;

  var dt = document.getElementById("dateTo").value
  document.getElementById("dt").innerHTML = dt;

  getAll();
  addDetail();
  getCountdown();
}

function thingsToDo() {
  window.open("https://www.tripadvisor.co.uk/?fid=88fcde45-5a56-4c19-be9c-1718ed412c74", "_blank");
}

function getAll() {
  axios
    .get('http://localhost:8083/details/getAll')
    .then(res => { showOutput(res) })
    .catch(error => console.err(error));
}

function getDestination() {

}

function addDetail() {
  axios
    .post('http://localhost:8083/details/add', {
      origin: document.getElementById("origin").value,
      destination: document.getElementById("destination").value,
      dateFrom: document.getElementById("dateFrom").value,
      dateTo: document.getElementById("dateTo").value,
    })
    .then(res => showOutput(res))
    .catch(error => console.log(error));
}

function updateDetail() {
  axios
    .put('http://localhost:8083/details/update/1', {
      origin: document.getElementById("origin").value,
      destination: document.getElementById("destination").value,
      dateFrom: document.getElementById("dateFrom").value,
      dateTo: document.getElementById("dateTo").value,
    })
    .then(res => showOutput(res))
    .catch(error => console.log(error));
}

function deleteDetail() {
  axios
    .delete('http://localhost:8083/details/delete/3')
    .then(alert("The details have been deleted"))
    .catch(error => console.log(error));
}


function showOutput(res) {
  document.getElementById('all').innerHTML = `
    <div class="card card-body mb-4">
      <h5>Status: ${res.status}</h5>
    </div>

    <div class="card mt-3">
      <div class="card-header">
        Data
      </div>
      <div class="card-body">
        <pre>${JSON.stringify(res.data, null, 2)}</pre>
      </div>
    </div>

  `;
}



//   countdown ----->
var target_date = new Date().getTime() + (dateSeconds()); // set the countdown date
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

  // format countdown string + set tag value
  countdown.innerHTML = "<span>" + days + "</span><span>" + hours + "</span><span>" + minutes + "</span><span>" + seconds + "</span>";
}

function pad(n) {
  return (n < 10 ? '' : '') + n;
}

function dateSeconds() {
  var _initial = document.getElementById("dateFrom").value;
  var fromTime = new Date(_initial);
  var toTime = new Date();

  var differenceTravel = fromTime.getTime() - toTime.getTime();
  var seconds = Math.floor(differenceTravel);
  return seconds;
}

