Feature: View Restaurant Menu

As a customer
I would like to view a restaurant Menu
So that I can choose what to eat

Background:
    Given a customer <customer_id> is logged into BookMyTable as a customer
    And the customer <customer_id> is an unsuspended user

Scenario: Query a list of nearby restaurants (Normal Flow)

    When the customer <customer_id> queries to view the menu of a restaurant with name <restaurant_name>
    Then the customer is redirected to the menu link to the restaurant <restaurant_name>
    And the list of foods available in the restaurant <restaurant_name> are shown.

Scenario: Wrong link to menu available (Error Flow)

    When the customer <customer_id> queries to view the menu of a restaurant with name <restaurant_name>
    And the restaurant <restaurant_name> has  link to its menu
    Then the customer gets redirected to the wrong link.

Scenario: No link to menu available (Error Flow)

    When the customer <customer_id> queries to view the menu of a restaurant with name <restaurant_name>
    And the restaurant <restaurant_name> has no link to its menu
    Then the customer gets an error message.