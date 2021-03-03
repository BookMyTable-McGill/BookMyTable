Feature: Modify restaurant menu

As a restaurant owner
I would like to modify the menu of a restaurant that I own
So that customer's can be aware of the modification concerning the restaurant menu

Background:
Given restaurant owner <restaurant_owner_id> is logged into BookMyTable as a restaurant owner

Scenario: The owner successfully modify the menu of a restaurant (Normal Flow)

When restaurant owner <restaurant_owner_id> selects one of their restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the menu
And the restaurant owner <restaurant_owner_id> enters the menu link
Then the restaurant <restaurant_id> has the newly modified menu
And a "Menu modified successfully" message appears

Scenario: The owner does not successfully modify the menu of a restaurant because he fails to enter a new option (Error Flow)

When restaurant owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the menu
And the restaurant owner <restaurant_owner_id> does not enter the new menu link
Then the restaurant <restaurant_id> menu remains the same
And an error message appears
