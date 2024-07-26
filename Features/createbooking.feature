Feature: CreateBooking

@CreateBooking
Scenario Outline: Create Booking
Given User has "CreateBooking" payload with all the attributes
|firstname|lastname|totalprice|depositpaid|checkindate|checkoutdate|additionalneeds|
|Mason|Mount|230|true|2024-07-01|2024-07-23|Breakfast|
When User calls "CreateBooking" API with "POST" http method
Then User should get 200 response code
And User validates response with "CreateBookingSchema.json" schema
