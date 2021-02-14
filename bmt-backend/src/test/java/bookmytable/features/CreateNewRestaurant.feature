Feature: Create New Restaurant

As a restaurant owner
I would like to create a new restaurant
So that I can view and manage the reservations made to it 


Scenario Outline: Create a New Restaurant (Normal Flow)

Given a restaurant owner "<RestaurantOwner>" wants to add a new restaurant to his account
When creating a restaurant with name "<RestaurantName>" and address "<RestaurantAddress>"
Then a unique id "<RestaurantID>" will be assigned to it
And a status message "<Status>" will be displayed
And reservations for that restaurant will be possible



Scenario Outline: Attempt to Create Already Existent Restaurant (Error Flow)

Given a restaurant owner "<RestaurantOwner>" wants to add a new restaurant to his account
When creating a restaurant with name "<RestaurantName>" and address "<RestaurantAddress>"
And a restaurant with name "<RestaurantName>" and address "<RestaurantAddress>" already exists
Then restaurant creation will fail
And a status message will be displayed



