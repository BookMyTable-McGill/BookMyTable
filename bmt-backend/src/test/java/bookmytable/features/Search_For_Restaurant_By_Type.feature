Feature: Search for restaurant by type

As a Customer of the BookMyTable System
I would like to search for restaurants by their type
So that I can choose a restaurant that I would like

Background
Given Customer <customer_name> exists
And Customer <customer_name> is logged in

Scenario Outline: Successful search (Normal flow)

Given the following Restaurants exist

|restaurant_name|restaurant_type	|
|McDonalds	|Fast Food		|
|Dominos	|Fast Food		|
|Donalds pizza	|Italian		|
|Mykes		|Greek			|
|My pizza place	|Italian		|
|Wendys	|Fast Food		|

When Customer <customer_name> searches for the type <search_type>
Then the restaurant info for Restaurants with <restaurant_type> equal to <search_type> will be displayed



Scenario Outline: Successful search when the Customer has not selected a type (Alternate flow)

Given the Customer has not selected a price
When the Customer attempts to search by price
Then all restaurants will be returned
And the Customer will be notified that no price filter was applied

Scenario Outline: Unsuccessful search of a type with no available restaurants (Error flow)

Given the following Restaurants exist

|restaurant_name|restaurant_type	|
|McDonalds	|Fast Food		|
|Dominos	|Fast Food		|
|Donalds pizza	|Italian		|
|Mykes		|Greek			|
|My pizza place	|Italian		|
|Wendys	|Fast Food		|

When Customer <customer_name> searches for the type Chinese
Then the Customer will be notified that no restaurants fall under their desired type