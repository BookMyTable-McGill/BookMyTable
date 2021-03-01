Feature: View all restaurants

  As an Administrator of the Restaurant Booking system
  I would like to view all restaurants
  So that I can perform administrative actions on the restaurants

  Background:
    Given Administrator "<admin_name>" exists
    And Administrator "<admin_name>" has email "<admin_email>", password "<admin_pass>"
    And Administrator "<admin_name>" is logged in

  Scenario Outline: View all restaurants (Normal Flow)

    When Administrator "<admin_name>" attempts to view all restaurants
    Then a list of all restaurant ids <"list_of_restaurants_id"> is returned:

      | admin_name  | list_of_restaurants_id |
      | Eric Pelle  | 0001, 0002, 0003, 0004 |
      | Andy Adams  | 0001, 0002, 0003, 0004 |
      | Beth Baines | 0001, 0002, 0003, 0004 |


  Scenario Outline: No restaurants found (Error Flow)

    When Administrator "<admin_name>" attempts to view all restaurants
    And no restaurants exists
    Then the following empty list of restaurant ids <"list_of_restaurants_id"> is returned:

      | admin_name  | list_of_restaurants_id |
      | Eric Pelle  |         null           |
      | Andy Adams  |         null           |
      | Beth Baines |         null           |
    
