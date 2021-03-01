Feature: Modify restaurant location

As a restaurant owner
I would like to modify the location of a restaurant that I own
So that customers can be aware of the modification concerning the location

Background:
Given a restaurant owner <restaurant_owner_id> is logged into BookMyTable as a restaurant owner

Scenario: The owner successfully modify the location of a restaurant (Normal Flow)

When the restaurant owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the location
And the restaurant owner <restaurant_owner_id> enters the new location
Then the restaurant <restaurant_id> has the newly modified location
And a "location modified successfully" message is displayed

Scenario: The owner does not successfully modify the location of a restaurant because he fails to enter a new location (Error Flow)

When the restaurant owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the location
And the restaurant owner <restaurant_owner_id> does not enter the new location
Then the restaurant <restaurant_id> location remains the same
And an error message is displayed