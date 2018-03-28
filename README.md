# HR_Reservation
APIs for creation, modification, and retrieval of hotel reservation data using Spring MVC and Java. The web service uses in-memory data storage with rid being the unique identifier for each reservation. The ID Generator is marked as a @Component which allows the Spring Boot to recognize the generator class as an injectable coponent.


Controller: http://localhost:8080/reservation

Reservation Domain Model
************************
rid : Long
gFullName: string
checkinDate: date
checkoutDate: date
rStatus	  :  Future_Reservation, Checked_In, Checked_Out
************************

GET
/reservation
Obtains the list of all reservations currently created in the system. If the list is successfully obtained, the list of existing reservations is returned, along with an HTTP 200(OK) status.

POST
/reservation
Creates a new reservation. This request should carry a request body that includes the data that should be associated with the newly created reservation. If the reservation is created, an HTTP 201 (Created) status is returned along with the newly created reservation in the response body.

GET
/reservation/{id}
Obtains the reservation associated with the given ID. If no reservation exists, an HTTP 404 (Not Found) status is returned. If the reservation can be found, an HTTP 200 status is returned and the response body contains the information associated with the reservation.

PUT
/reservation/{id}
Updates an existing reservation. If no reservation with the given ID can be found, an HTTP 404 status is returned. If an reservation exists with the given ID and the request body contains valid updates to the reservation, the reservation is updated and the updated reservation is returned in the response body, along with an HTTP 200 status.
************************

JSON Request body
{
    "gFullName": "Some sample name",
    "checkinDate": "2018-12-12",
    "checkoutDate": "2018-12-12"
    
}
************************

A Copy of the Maven can be downloaded from https://maven.apache.org/install.html
To start maven navigate to the path where maven is downloaded.
Export the location to the PATH variable
MAC: export PATH=/{local directory}apache-maven-3.5.3/bin:$PATH
Windows: Set the PATH in the Environment variables
Execute the following command in Terminal/Command prompt:
mvn spring-boot:run

Navigate to the URL (Controller info above) in your local browser.

For inserting new records download a rest client and make sure the request body format is set as JSON(application/json)
*************************

The following Unit Tests have been successfully executed
> Generating Multiple Unique IDs to make sure they dont interfere
> Find Non existing IDs should respond with error
> Find exisiting reservation
> Finding a reservation returns appropriate values
> Find multiple non existing IDs returns no reservations
> Finding multiple reservations returns correct count
> Finding count with 1 reservation
> Finding count with multiple reservations
> PUT request to update non existing IDs encure no updates being made
> PUT request to update a reservation
> PUT with no changes makes no update
*************************

To run the tests import the Maven project in the IDE (Eclipse, Spring Boot)
Click on the Test and Run as JUnit Test
In the command propmt execute:
mvn test

Docker tag used: docker run -p 80:80 ramsantoshtk/hr-reservation:new