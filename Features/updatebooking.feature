Feature: Update Booking

Background: Book is already created
Given User has "CreateBooking" payload
|firstname|lastname|totalprice|depositpaid|checkindate|checkoutdate|additionalneeds|
|Mason|Mount|230|true|2024-07-01|2024-07-23|Breakfast|
When User calls "CreateBooking" API with "POST" http method
Then Booking id should be returned in reponse


@UpdateBooking
Scenario: Update Booking
Given User passes booking id in request URI
And User has "UpdateBooking" payload
|firstname|lastname|totalprice|depositpaid|checkindate|checkoutdate|additionalneeds|
|Mason|Mount|230|true|2024-08-01|2024-08-23|Breakfast|
When User calls "UpdateBooking" API with "PUT" http method
Then User should get 200 response code
And Check in date should be updated to "2024-08-01" and Check out date should be updated to "2024-08-23"