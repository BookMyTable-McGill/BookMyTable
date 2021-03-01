Feature: Search for restaurant by name

As a Customer of the BookMyTable System
I would like to search for a restaurant by its name
So that I can make a reservation there

Background
Given Customer <customer_name> exists
And Customer <customer_name> is logged in

Scenario Outline: Successful search (Normal flow)

Given Restaurant <restaurant_name> exists
When Customer <customer_name> searches for the name <restaurant_name>
Then the restaurant info for Restaurant <restaurant_name> will be displayed

Examples:
|restaurant_name|
|McDonalds	|
|Dominos	|
|Donalds pizza	|
|Mikes		|
|My pizza place	|
|Wendys	|

Scenario Outline: Successful search of a name fragment (Alternative flow)

Given the following Restaurants exist

|restaurant_name|
|McDonalds	|
|Dominos	|
|Donalds pizza	|
|Mykes		|
|My pizza place	|
|Wendys	|

When Customer <customer_name> searches for the name <restaurant_name_fragment>
Then the restaurant info for all Restaurants containing fragment <restaurant_name_fragment> will be displayed

Examples:
|restaurant_name_fragment	|
|Donald				|
|pizza				|
|Wen				|
|My				|

Scenario Outline: Unsuccessful search of a name that does not exist (Error flow)

Given the following Restaurants exist

|restaurant_name|
|McDonalds	|
|Dominos	|
|Donalds pizza	|
|Mykes		|
|My pizza place	|
|Wendys	|

When Customer <customer_name> searches for the name <false_restaurant_name>
Then no corresponding restaurants will be found
And the Customer will be notified that no such restaurant exists


Scenario: Unsuccessful search of an empty name (Error flow)

Given Customer <customer_name> has not entered the name of a restaurant
When Customer <customer_name> searches for a restaurant by name
Then no no restaurants will be returned
And the Customer will be prompted to enter a name