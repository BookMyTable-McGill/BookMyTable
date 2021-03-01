Feature: Create Administrator Account

  As an administrator
  I would like to create an administrator account
  So that I can login as administrator and do administrative actions

  Given a person <administrator> wishes to create an adminstrator account

  Scenario: Create a new adminstrator account (Normal Flow)

    When the admin <administrator> inputs email <validEmail> and password <validPassword>
    And the admin <administrator> clicks to Create account
    Then an adminstrator account with email <validEmail> and password <validPassword> is created
    And the admin <administrator>  is redirected to the administrator profile

  Scenario: Create a new adminstrator account with existing email (Error Flow 1)

    When the admin <administrator> inputs email <existingEmail> and password <validPassword>
    And the admin <administrator> clicks to Create account
    Then a "An account with this email already exists" error message is issued

  Scenario: Create a new adminstrator account with invalid password (Error Flow 2)

    When the admin <administrator> inputs email <validEmail> and password <invalidPassword>
    And the admin <administrator> clicks to Create account
    Then a "password is not valid" error message is issued