Feature: Modify restaurant name

As a restaurant owner
I would like to modify the name of a restaurant that I own
So that customers can be aware of the modification concerning the restaurant name

Background:
    Given a restaurant owner <restaurant_owner_id> is connected into BookMyTable as a restaurant owner
    And restaurant owner <restaurant_owner_id> has at least one registered restaurant 

Scenario: The owner successfully modifies the name of a restaurant (Normal Flow)

    When the restaurant owner <restaurant_owner_id> modifies the name of their restaurant <restaurant_id> to a new name
    Then the restaurant <restaurant_id> has the newly modified name
    And a "restaurant name modified successfully" message is showcased

Scenario: The owner does not successfully modify the name of a restaurant because they enter the same name (Alternate Flow)

    When the restaurant owner <restaurant_owner_id> modifies the name of their restaurant <restaurant_id> to be the same name
    Then the restaurant <restaurant_id> name remains the same
    And a "restaurant name modified successfully" message is showcased

Scenario: The owner does not successfully modify the name of a restaurant because they fail to enter a new name (Error Flow)

    When the restaurant owner <restaurant_owner_id> modifies the name of their restaurant <restaurant_id> to be an empty name
    Then the restaurant <restaurant_id> name remains the same
    And an error message is showcased

