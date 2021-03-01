Feature: Search for restaurant by food options

As a Customer of the BookMyTable System
I would like to search for restaurants by their food options
So that I can choose a restaurant that fits my dietary restrictions

Background
Given Customer <customer_name> exists
And Customer <customer_name> is logged in

Scenario Outline: Successful search (Normal flow)

Given the following Restaurants exist

|restaurant_name|restaurant_options	|
|McDonalds			|None								|
|RestoResto	|Vegan			|
|Donalds pizza	|Gluten-free		|
|Mykes		|Gluten-free		|
|My pizza place	|None			|
|Wendys	|None			|

When Customer <customer_name> searches for the price <search_options>
Then the restaurant info for Restaurants with <restaurant_price> equal to <search_options> will be displayed


Scenario Outline: Successful search when the Customer has not selected food options (Alternate flow)

Given the Customer has not selected any food options
When the Customer attempts to search by food options
Then all restaurants will be returned
And the Customer will be notified that no options filter was applied

Scenario Outline: Unsuccessful search of food options with no available restaurants (Error flow)

Given the following Restaurants exist

|restaurant_name|restaurant_options	|
|McDonalds	|None			|
|RestoResto	|Vegan			|
|Donalds pizza	|Gluten-free		|
|Mykes		|Gluten-free		|
|My pizza place	|None			|
|Wendys	|None			|

When Customer <customer_name> searches for the option Lactose-Free
Then The the Customer will be notified that no restaurants fall under their desired food options