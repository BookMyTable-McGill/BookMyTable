Feature: Modify reservation

As a customer
I would like to modify a reservation that I made
So that the restaurant can be aware of the changes 

Background:
Given a customer <customer_id> is logged into BookMyTable as a customer
And a customer <customer_id> has already made a reservation <reservation_id>

Scenario: The customer successfully modifies the date of the reservation (Normal Flow)
When the customer <customer_id> requests to modify the date of the reservation
And the customer <customer_id> selects a new date for the reservation
Then the reservation <reservation_id> has the newly modified date

Scenario: The customer does not successfully modify the date of the reservation because no new date is selected (Error Flow)
When the customer <customer_id> requests to modify the date of the reservation
But the customer <customer_id> does not select any date for the reservation
Then the reservation <reservation_id> has the previously set date
And "date of reservation not modified" message appears

Scenario: The customer successfully modifies the time of the reservation (Normal Flow)
When the customer <customer_id> requests to modify the time of the reservation
And the customer <customer_id> selects a new time for the reservation
Then the reservation <reservation_id> has the newly modified time

Scenario: The customer does not successfully modify the time of the reservation because no new time is selected (Error Flow)
When the customer <customer_id> requests to modify the time of the reservation
But the customer <customer_id> does not select any time for the reservation
Then the reservation <reservation_id> has the previously set time
And "time of reservation not modified" message appears

Scenario: The customer successfully modifies the group size and table of the reservation (Normal Flow)
When the customer <customer_id> requests to modify the group size of the reservation
And the customer <customer_id> selects a new group size for the reservation
And the customer <customer_id> selects a new table for the reservation
Then the reservation <reservation_id> has the newly modified group size and table

Scenario: The customer does not successfully modify the group size of the reservation because no group size is selected (Error Flow)
When the customer <customer_id> requests to modify the group size of the reservation
But the customer <customer_id> does not select a new group size for the reservation
Then the reservation <reservation_id> has the previously set group size
And "group size of reservation not modified" message appears

Scenario: The customer successfully modifies the group size of the reservation (Normal Flow)
When the customer <customer_id> requests to modify the group size of the reservation
And the customer <customer_id> selects a new group size for the reservation
And the customer <customer_id> selects a new table for the reservation
Then the reservation <reservation_id> has the newly modified group size and table

Scenario: The customer does not successfully modify the group size of the reservation because no group size is selected (Error Flow)
When the customer <customer_id> requests to modify the group size of the reservation
But the customer <customer_id> does not select a new group size for the reservation
Then the reservation <reservation_id> has the previously set group size
And "group size of reservation not modified" message appears

Scenario: The customer successfully modifies the table of the reservation (Normal Flow)
When the customer <customer_id> requests to modify the table of the reservation
And the customer <customer_id> selects a new table for the reservation
Then the reservation <reservation_id> has the newly modified table

Scenario: The customer does not successfully modify the table of the reservation because no table is selected (Error Flow)
When the customer <customer_id> requests to modify the table of the reservation
But the customer <customer_id> does not select a new table for the reservation
Then the reservation <reservation_id> has the previously set table
And "table of reservation not modified" message appears