Feature: Cancel a reservation

As a customer
I would like to cancel a reservation that I made
So that the restaurant can be aware of the changes 

Background:
Given customer <customer_id> is logged into BookMyTable as a customer
And customer <customer_id> has already made a reservation <reservation_id>

Scenario: The customer successfully cancels the reservation (Normal Flow)
When the customer <customer_id> requests to cancel the reservation
Then the reservation <reservation_id> will be cancelled

Scenario: The customer does not successfully cancel the reservation because the reservation has already passed (Error Flow)
When the customer <customer_id> wants to cancel the reservation
But the reservation <reservation_id> has already passed
Then the customer will not have the option to cancel the reservation