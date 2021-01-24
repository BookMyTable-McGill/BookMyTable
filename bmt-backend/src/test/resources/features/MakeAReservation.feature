Feature: Make a Reservation

As a customer of BookMyTable
I would like to make a restaurant reservation
So that I can be guaranteed a table when I arrive at the restaurant.

Background: 
    Given I am an unsuspended user 
    And I am logged into BookMyTable

Scenario: Make a reservation successfully

    When I select the restaurant of my choice
    And I enter an acceptable group size
    And I select an available time 
    And I select an available table of my choice
    Then I should see a confirmation message

Scenario: Make a reservation fails due to available reservation time not selected

    When I select the restaurant of my choice
    And I enter an acceptable group size
    But I fail to select an available reservation time 
    Then I should see an error message
    And I should be requested to select an available reservation time

Scenario: Make a reservation fails due to entered group size surpassing set limit 

    When I select the restaurant of my choice
    But I enter a group size surpassing the maximum limit
    Then I should see an error message
    And I should be requested to enter an acceptable group size
  

Scenario: Make a reservation fails due to group size not entered

    When I select the restaurant of my choice
    And I fail to enter a group size
    Then I should see an error message
    And I should be requested to enter an acceptable group size


Scenario: Make a reservation fails due to available table not selected

    When I select the restaurant of my choice
    And I enter an acceptable group size
    And I select an available time 
    And I fail to select an available table of my choice
    Then I should see an error message
    And I should be requested to select an available table of my choice

Scenario: Make a reservation fails due to restaurant booking completely full for any group size

    When I select a restaurant that is completely booked
    Then I should be requested to choose another available restaurant of my choice