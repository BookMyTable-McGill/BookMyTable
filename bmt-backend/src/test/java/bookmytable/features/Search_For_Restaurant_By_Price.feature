Feature: Search for restaurant by price

As a Customer of the BookMyTable System
I would like to search for restaurants by their price
So that I can choose a restaurant that fits my budget

Background
Given Customer <customer_name> exists
And Customer <customer_name> is logged in

Scenario Outline: Successful search (Normal flow)

Given the following Restaurants exist

|restaurant_name|restaurant_price	|
|McDonalds	|1			|
|Dominos	|2			|
|Donalds pizza	|3			|
|Mykes		|4			|
|My pizza place	|2			|
|Wendys	|1			|

When Customer <customer_name> searches for the price <search_price>
Then the restaurant info for Restaurants with <restaurant_price> equal to <search_price> will be displayed

Scenario Outline: Successful search when the Customer has not selected a price (Alternate flow)

Given the Customer has not selected a price
When the Customer attempts to search by price
Then all restaurants will be returned
And the Customer will be notified that no price filter was applied

Scenario Outline: Unsuccessful search of a price range with no available restaurants (Error flow)

Given the following Restaurants exist

|restaurant_name|restaurant_price	|
|McDonalds	|1			|
|Dominos	|2			|
|Donalds pizza	|3			|
|Mykes		|4			|
|My pizza place	|2			|
|Wendys	|1			|

When Customer <customer_name> searches for the price 5
Then the Customer will be notified that no restaurants fall under their desired price range