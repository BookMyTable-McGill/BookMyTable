Feature: Modify restaurant opening hours

As a restaurant owner
I would like to modify the opening hours of a restaurant that I own
So that customerss can be aware of the modification concerning the opening hours

Background:
Given a owner <restaurant_owner_id> is logged into BookMyTable as a restaurant owner

Scenario: The owner successfully modify the opening hours of a restaurant (Normal Flow)

When the owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the opening hours
And the restaurant owner <restaurant_owner_id> enters the new opening hours
Then the restaurant <restaurant_id> has the newly modified opening hours
And a "opening hours modified successfully" message is showing

Scenario: The owner does not successfully modify the opening hours of a restaurant because he fails to enter the new opening hours (Error Flow)

When the owner <restaurant_owner_id> selects one of its restaurants <restaurant_id>
And the restaurant owner <restaurant_owner_id> requests to modify the opening hours
And the restaurant owner <restaurant_owner_id> does not enter the new opening hours
Then the restaurant <restaurant_id> opening hours remains the same
And an error message is showing