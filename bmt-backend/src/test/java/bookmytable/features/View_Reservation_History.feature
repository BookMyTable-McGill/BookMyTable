Feature: View Reservation History

As a Customer
I would like the view my history of reservations
So I can see which restaurants I previously visited

Background:

Given a customer is logged in

Scenario: Successfully view reservation history (Normal Flow)

Given the customer has made at least one reservation through BookMyTable
When the customer selects to view their reservation history
Then the customer's reservation history will be displayed

Scenario: Try to view an empty history (Error Flow)

Given the customer has never used the system to make a reservation
When the customer tries to view their reservation history
Then there will be an error message displayed
And there will be no history for the customer to view
