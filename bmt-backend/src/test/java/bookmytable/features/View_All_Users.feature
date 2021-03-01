Feature: View all Users

  As an Administrator of the Restaurant Booking system
  I would like to view all Users
  So that I can manage the users of the Booking System

  Background:
    Given Administrator "<admin_name>" exists
    And Administrator "<admin_name>" has email "<admin_email>", password "<admin_pass>"
    And Administrator "<admin_name>" is logged in

  Scenario Outline: View all Users (Normal Flow)

    When Administrator "<admin_name>" attempts to view all users
    Then a list of all Customer ids <"list_of_customers"> and all  Restaurant Owner ids <"list_of_restaurant_owners"> is returned:

      | admin_name  | list_of_customers      | list_of_restaurant_owners |
      | Eric Pelle  | 0001, 0002, 0003, 0004 | 0005, 0006, 0007, 0008    |
      | Andy Adams  | 0001, 0002, 0003, 0004 | 0005, 0006, 0007, 0008	 |
      | Beth Baines | 0001, 0002, 0003, 0004 | 0005, 0006, 0007, 0008	 |


  
    
