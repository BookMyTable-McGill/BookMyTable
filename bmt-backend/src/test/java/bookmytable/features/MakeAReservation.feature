Feature: Make a Reservation

As a customer of BookMyTable
I would like to make a restaurant reservation
So that I can be guaranteed a table when I arrive at the restaurant.

Background: 
    Given a customer <customer_id> is logged into BookMyTable as a customer
    And the customer <customer_id> is an unsuspended user

Scenario: Make a reservation successfully (Normal flow)

    When the customer <customer_id> selects the restaurant <restaurant_id> of their choice
    And the customer <customer_id>  enters an acceptable group size <group_size>
    And the customer <customer_id>  selects an available date and time <reservation_datetime> 
    And the customer <customer_id>  selects an available table <table_id> of their choice
    Then the customer <customer_id>  should see a confirmation message 
    And a new reservation <reservation_id> is generated

    | reservation_id | reservation_datetime | customer_id | table_id |group_size| restaurant_id |
    | 0001           | 2021-05-25 20:00:00  | 69420       | 3246     |4         | 0001          |


Scenario: Make a reservation fails due to available reservation time not selected (Error flow)

    When the customer <customer_id> selects the restaurant <restaurant_id> of their choice
    And the customer <customer_id>  enters an acceptable group size <group_size>
    But the customer <customer_id>  fails to select an available reservation date and time <reservation_datetime> 
    Then a "Please select an available reservation time" error message is issued

Scenario: Make a reservation fails due to entered group size surpassing set limit (Error flow)

    When the customer <customer_id> selects the restaurant <restaurant_id> of their choice
    But the customer <customer_id>  enter a group size <group_size> surpassing the maximum limit
    Then a "Please enter acceptable group size" error message is issued

Scenario: Make a reservation fails due to group size not entered (Error flow)

    When the customer <customer_id> selects the restaurant <restaurant_id> of their choice
    But the customer <customer_id>  fails to enter a group size <group_size>
    Then a "Please enter acceptable group size" error message is issued

Scenario: Make a reservation fails due to available table not selected (Error flow)

    When the customer <customer_id> selects the restaurant <restaurant_id> of their choice
    And the customer <customer_id>  enters an acceptable group size <group_size>
    And the customer <customer_id>  selects an available date and time <reservation_datetime> 
    But the customer <customer_id>  fails to select an available table <table_id> of my choice
    Then a "Please select an available table" error message is issued

Scenario: Make a reservation fails due to restaurant booking completely full for any group size (Error flow)

    When the customer <customer_id>  selects a restaurant that is completely booked
    Then a "Please select another restaurant" error message is issued