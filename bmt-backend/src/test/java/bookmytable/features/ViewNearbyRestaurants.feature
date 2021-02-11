Feature: View Nearby Restaurants

As a customer of BookMyTable
I would like to view nearby restaurants
So that I can find a close by restaurant to eat at


Backgound:
    Given a customer <customer_id> is logged into BookMyTable as a customer
    And the customer <customer_id> is an unsuspended user

Scenario: Query a list of nearby restaurants (Normal Flow)

    When the customer <customer_id> with <postal_code> queries a list of nearby restaurants within a chosen <diameter>
    Then the following list of <list_of_restaurants_id> is returned:

       | customer_id | postal_code | diameter | list_of_restaurants_id  | 
       | 12234       |   H4K2J9    |    20    |    0034, 0012, 0054     |
       | 82903       |   H7J3K0    |    10    |          0004           |
       | 34828       |   H5K9H0    |     5    |       0054, 0002        |


Scenario: No restaurants found nearby (Error Flow)

    When the customer <customer_id> with <postal_code> queries a list of nearby restaurants within a chosen <diameter>
    And no restaurants are found within the <diameter>
    Then the following empty list of <list_of_restaurants_id> is returned:

       | customer_id | postal_code | diameter | list_of_restaurants_id  | 
       | 56789       |   H7B3L9    |    25    |          null           |
       | 98765       |   H8G4B3    |    10    |          null           |

    And the customer will be prompted with an error message