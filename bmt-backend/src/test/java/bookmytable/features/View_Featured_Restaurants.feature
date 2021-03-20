Feature: View Featured Restaurants

  As a Customer of the Restaurant Booking system
  I would like to view Restaurants with the most number of Reservations
  So that I may find the most popular restaurants

  Background:
    Given a Customer "<customer_name>" exists
    And a Customer "<customer_name>" has email "<customer_email>", password "<customer_pass>"
    And a Customer "<customer_name>" is logged in
    And there is at least 1 Restaurant in system

  Scenario Outline: View first 10 Restaurants with the most Reservations (Normal Flow)

    When Customer "<customer_name>" queries to view Restaurants with most Reservations
    And there are at least 10 Restaurants in System
    Then a list of the first 10 Restaurants with the most Reservations <"list_of_restaurants_with_least_res"> is returned in ascending order:

      | list_of_restaurants_with_least_res 					   						      | 
      | New Rivoli, Matjip KBBQ, Elio Pizzeria, Nostos, Jukebox Burgers, 40 West, Baton Rouge, Monza, Mac Bar et Fromage, Maiko Sushi | 
     

  Scenario Outline: There are less than 10 Restaurants in the System (Alternate Flow)	

    When Customer "<customer_name>" queries to view Restaurants with most Reservations
    And there are less than 10 Restaurants in system
    Then a list of all of the Restaurants <"list_of_restaurants_with_least_res_reduced"> in system is returned in ascending order based on Reservations:

      | list_of_restaurants_with_least_res_reduced				 | 						      
      | New Rivoli, Matjip KBBQ, Elio Pizzeria, Nostos, Jukebox Burgers, 40 West |
