Feature: Mark Restaurant As Favorite

As a Customer
I would like to mark a Restaurant as Favorite
So that I can view my Favorite Restaurants

Background:
Given a Customer is logged in to BookMyTable as a Customer

Scenario: The Customer successfully marks a restaurant as Favorite (Normal Flow)

When the Customer marks a Restaurant as Favorite
Then the restaurant shall be added to that customer's favorite list of Favorite Restaurants
And a message indicating that the restaurant has been added to that customer's list of Favorite Restaurants will appear
