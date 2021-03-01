Feature: Modify restaurant food option

As a restaurant owner
I would like to modify the food option of a restaurant that I own
So that customer's can be aware of the modification concerning the offered food option

Background:
Given a restaurant owner <restaurant_owner_id> is logged into BookMyTable as a restaurant owner

Scenario: The owner successfully modify the food option of a restaurant (Normal Flow)

When the restaurant owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the food option
And the restaurant owner <restaurant_owner_id> enters the new food option
Then the restaurant <restaurant_id> has the newly modified food option
And a "Food option modified successfully" message is displayed

Scenario: The owner does not successfully modify the food option of a restaurant because he fails to enter a new option (Error Flow)

When the restaurant owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the food option
And the restaurant owner <restaurant_owner_id> does not enter the new food option
Then the restaurant <restaurant_id> food option remains the same
And an error message is displayed
