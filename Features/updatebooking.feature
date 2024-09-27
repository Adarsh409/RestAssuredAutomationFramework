Feature: Update Booking

Background: Book is already created
Given User has "CreateBooking" payload with all the attributes
|firstname|lastname|totalprice|depositpaid|checkindate|checkoutdate|additionalneeds|
|Mason|Mount|230|true|2024-07-01|2024-07-23|Breakfast|
When User calls "CreateBooking" API with "POST" http method
Then Booking id should be returned in reponse


Scenario: Update Booking
Given User passes booking id in request URI
And User has "UpdateBooking" payload with all the attributes
|firstname|lastname|totalprice|depositpaid|checkindate|checkoutdate|additionalneeds|
|Mason|Mount|230|true|2024-08-01|2024-08-23|Breakfast|
When User calls "UpdateBooking" API with "PUT" http method
Then User should get 200 response code
And Check in date should be updated to "2024-08-01" and Check out date should be updated to "2024-08-23"
And User validates response with "UpdateBookingSchema.json" schema

@PartialUpdate
Scenario: Partial Update
Given User passes booking id in request URI
And User has "PartialUpdateBooking" payload to update booking dates
|checkindate|checkoutdate|
|2024-07-12|2024-07-29|
When User calls "PartialUpdateBooking" API with "PATCH" http method
Then User should get 200 response code
And Check in date should be updated to "2024-07-12" and Check out date should be updated to "2024-07-29"

