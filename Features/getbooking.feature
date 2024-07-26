Feature: GetBooking

Background: Book is already created
Given User has "CreateBooking" payload
|firstname|lastname|totalprice|depositpaid|checkindate|checkoutdate|additionalneeds|
|Mason|Mount|230|true|2024-07-01|2024-07-23|Breakfast|
When User calls "CreateBooking" API with "POST" http method
Then Booking id should be returned in reponse


@GetBooking
Scenario: GetBooking
Given User passes booking id in request URI
When User calls "GetBooking" API with "GET" http method
Then User should get 200 response code
And First name returned should be "Mason" and last name should be "Mount"