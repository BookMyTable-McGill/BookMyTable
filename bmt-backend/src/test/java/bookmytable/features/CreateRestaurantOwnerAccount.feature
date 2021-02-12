Feature: Create Restaurant Owner Account

  As a restaurant owner
  I would like to create a restaurant owner account
  So that I can manage my restaurant(s)

  Background:

    Given a restaurant owner <restaurantOwner> is on the create restaurant owner account page

  Scenario: Create a New Restaurant Owner Account (Normal Flow)

    When a restaurant owner <restaurantOwner> inputs email <validEmail> and password <validPassword>
    And restaurant owner <restaurantOwner> clicks to Create account
    Then a restaurant owner with email <validEmail> and password <validPassword> is created
    And restaurant owner <restaurantOwner> is redirected to restaurant owner profile

  Scenario: Create a New Restaurant Owner Account with existing email (Error Flow 1)

    When a restaurant owner <restaurantOwner> inputs email <existingEmail> and password <validPassword>
    And restaurant owner <restaurantOwner> clicks to Create account
    Then a "An account with this email already exists" error message is issued

  Scenario: Create a New Restaurant Owner Account with invalid password (Error Flow 2)

    When a restaurant owner <restaurantOwner> inputs email <validEmail> and password <invalidPassword>
    And restaurant owner <restaurantOwner> clicks to Create account
    Then a "password is not valid" error message is issued
