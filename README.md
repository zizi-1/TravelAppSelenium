# Travel App Project V1.0

## Table of Contents
* [Application Brief](#brief)
* [Features](#features)
* [Technologies Used](#tech)
    * [Back-End Application](#back)
    * [Front-End Application](#front)
    * [Deployment](#deployment)
    * [Testing](#testing)
    * [Architecture](#architecture)
    * [Ci/Cd Pipeline](#pipeline)
    * [Browser Support](#browser)
* [How to Use](#howto)
  * [Home Page](#home)
  * [Sumamry Page](#sumamry)
  * [Details Page](#details)
  * [Poi/Budget Page](#poi)

<a name="brief"></a>
## Brief Description of Application
This app will allow the user to enter travel details and then view them in a graphical way. 
There will also be a CRUD table allowing the user to enter their places of interest.

<a name="features"></a>
## Features
This app includes a CRUD table that allows the user to:

## Trip Details
* **Create** - Create a trip by entering origin, destination, date from & date to.
* **Read** - View the created trip on the summary page.
* **Update** - Update the created trip and view these in its updated form on the summary page.
* **Delete** - Delete trip by id and see the change in the table.

## Poi
* **Create** - Create a place of interest (poi), by entering a name and link.
* **Read** - View the created pois in a table format.
* **Update** - Update the created pois and view these in its updated form within the table.
* **Delete** - Delete pois by id and see the change in the table.

<a name="tech"></a>
## Technologies Used

<a name="back"></a>
### Backend
For the backend application was built using Java(ver. 11) with a SpringBoot framework which interacted with a H2 data. T
The main IDE used for this project was Intellij(highly recommended).

<a name="front"></a>
### Frontend
For the frontend the technologies used were HTML 5, CSS and JS (mainly vanilla js). This was coded using the 
Visual Code Studio (recommended to use live server extension).

<a name="deployment"></a>
### Deployment
In regards to deployment Jenkins was used to automate the build which passed. Tomcat was used as the server and AWS was used 
to inact the AWS

<a name="testing"></a>
### Testing
Testing was completed using Junit and Mockito wihch resulted in a line coverage of 86%.
Surefire report: [surefire][surefire-link] 

[surefire-link]: https://github.com/zzahid93/TravelApp/blob/master/docs/Surefire-Report.pdf

<a name="architecture"></a>
## Architecture
<img align="center" width="500" height="300" src="https://github.com/zzahid93/TravelApp/blob/master/docs/architecture.png">


<a name="pipeline"></a>
## Pipeline
<img align="center" width="500" height="300" src="https://github.com/zzahid93/TravelApp/blob/master/docs/ci:cd.png">

<a name="browser"></a>
## Browser Support
![Chrome](https://github.com/alrra/browser-logos/blob/master/src/chrome/chrome_48x48.png) | ![Firefox](https://github.com/alrra/browser-logos/blob/master/src/firefox/firefox_48x48.png)
--- | --- |
Latest :heavy_check_mark: | Latest :heavy_check_mark:

<a name="howto"></a>
## How to use

<a name="home"></a>
### Home Page
The hompage is a minimilistic page allowing the user to 'get started' and move to the details page, or if it is a returning 
user they can click 'view trip'  in order to view the latest entered trip.

<a name="summary"></a>
### Summary Page
This page shows the users origin and destination for the trip and also dates of depature and return. I have also added in 
weather using the openweather API. There is also a 'things to do' button which navigates the user to tripadvisor.com/things/todo
where upon entering the destination there are shown activities they can do.

<a name="details"></a>
### Details Page
This page allows the user to create, update and delete a trip. They can also navigagte to the summary page using the 'view trip'
button.

<a name="poi"></a>
### Poi/Budget Page
This page allows the user to use the budget calculator which can help them budget out their holiday. There is also a poi crud
table which allows the user to create, read, update and delete the places of interest.



