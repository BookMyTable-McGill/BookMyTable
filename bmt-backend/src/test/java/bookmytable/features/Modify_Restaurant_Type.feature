Feature: Modify restaurant type

As a restaurant owner
I would like to modify the type of a restaurant that I own
So that customer's can be aware of the modification concerning the restaurant type

Background:
Given owner of restaurant <restaurant_owner_id> is logged into BookMyTable as a restaurant owner

Scenario: The owner successfully modify the type of a restaurant (Normal Flow)

When owner of restaurant <restaurant_owner_id> selects one of their restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the restaurant type
And the restaurant owner <restaurant_owner_id> enters the restaurant type
Then the restaurant <restaurant_id> has the newly modified type
And a "Type modified successfully" message is appearing

Scenario: The owner does not successfully modify the type of a restaurant because he fails to enter a new option (Error Flow)

When owner of restaurant <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the restaurant type
And the restaurant owner <restaurant_owner_id> does not enter the new restaurant type
Then the restaurant <restaurant_id> type remains the same
And an error message is appearing
