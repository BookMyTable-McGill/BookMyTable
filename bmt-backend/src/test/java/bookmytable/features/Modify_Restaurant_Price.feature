Feature: Modify restaurant price

As a restaurant owner
I would like to modify the price of a restaurant that I own
So that customers can be aware of the modification concerning the restaurant price

Background:
    Given a restaurant owner <restaurant_owner_id> is logged into BookMyTable as a restaurant owner
    And restaurant owner <restaurant_owner_id> has at least one registered restaurant 

Scenario: The owner successfully modifies the price of a restaurant (Normal Flow)

    When the restaurant owner <restaurant_owner_id> modifies the price of their restaurant <restaurant_id> to a new price
    Then the restaurant <restaurant_id> has the newly modified price
    And a "restaurant price modified successfully" message is displayed

Scenario: The owner does not successfully modify the price of a restaurant because they select the same price (Alternate Flow)

    When the restaurant owner <restaurant_owner_id> modifies the price of their restaurant <restaurant_id> to be the same price
    Then the restaurant <restaurant_id> price remains the same
    And a "restaurant price modified successfully" message is displayed
