Feature: Make a Reservation

As a customer of BookMyTable
I would like to make a restaurant reservation
So that I can be guaranteed a table when I arrive at the restaurant.

Background: 
    Given a customer <customer_id> is logged into BookMyTable as a customer
    And the customer <customer_id> is an unsuspended user

Scenario: Make a reservation successfully (Normal flow)

    When the customer <customer_id> select the restaurant <restaurant_id> of their choice
    And the customer <customer_id>  enter an acceptable group size
    And the customer <customer_id>  select an available time 
    And the customer <customer_id>  select an available table of their choice
    Then the customer <customer_id>  should see a confirmation message
    And a new reservation <reservation_id> is generated

    | reservation_id | reservation_datetime | customer_id | table_id | table_coordinates | restaurant_id |
    | 0001           | 2021-05-25 20:00:00  | 69420       | 3246     | 0,2               | 0001          |

Scenario: Make a reservation fails due to available reservation time not selected (Error flow)

    When the customer <customer_id>  select the restaurant <restaurant_id> of their choice
    And the customer <customer_id>  enter an acceptable group size
    But the customer <customer_id>  fail to select an available reservation time 
    Then a "Please select an available reservation time" error message is issued

Scenario: Make a reservation fails due to entered group size surpassing set limit (Error flow)

    When the customer <customer_id>  select the restaurant <restaurant_id> of their choice
    But the customer <customer_id>  enter a group size surpassing the maximum limit
    Then a "Please enter acceptable group size" error message is issued

Scenario: Make a reservation fails due to group size not entered (Error flow)

    When the customer <customer_id>  select the restaurant <restaurant_id> of their choice
    But the customer <customer_id>  fail to enter a group size
    Then a "Please enter acceptable group size" error message is issued

Scenario: Make a reservation fails due to available table not selected (Error flow)

    When the customer <customer_id>  select the restaurant <restaurant_id> of their choice
    And the customer <customer_id>  enter an acceptable group size
    And the customer <customer_id>  select an available time 
    But the customer <customer_id>  fail to select an available table of my choice
    Then a "Please select an available table" error message is issued

Scenario: Make a reservation fails due to restaurant booking completely full for any group size (Error flow)

    When the customer <customer_id>  select a restaurant that is completely booked
    Then a "Please select another restaurant" error message is issued