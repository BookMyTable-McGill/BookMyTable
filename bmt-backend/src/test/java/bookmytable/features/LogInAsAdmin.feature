Feature: Log In As Admin

  As an Administrator of the Restaurant Booking System
  I would like to log in as Administrator
  So that I can perform administrative actions on the system

  Background:
    Given Administrator "<admin_name>" exists
    And Administrator "<admin_name>" has email "<admin_email>", password "<admin_pass>"

  Scenario Outline: Successful login (Normal flow)

    Given Administrator "<admin_name>" is logged out
    When Administrator "<admin_name>" attempts to login using email "<admin_email>" and password "<admin_pass>"
    Then Administrator "<admin_name>" will be logged in
    And Administrator "<admin_name>" will be redirected to the administrator profile

    Examples:
      | admin_name   | admin_email       | admin_pass |
      | Albert Adams | aadams@gmail.com  | albertpass |
      | Beth Baines  | bbaines@yahoo.com | bethpass   |
      | Charlie Cole | ccole@hotmail.com | charpass   |
      | Daphne Delia | ddelia@mail.ca    | deliapass  |

  Scenario Outline: Already logged in on another device (Alternative flow)

    Given Administrator "<admin_name>" is already logged in
    When Administrator "<admin_name>" tries to login using email "<admin_email>" and password "<admin_pass>"
    Then "<admin_name>" will remain logged in
    And Administrator "<admin_name>" will be redirected to the administrator profile

    Examples:
      | admin_name   | admin_email       | admin_pass |
      | Albert Adams | aadams@gmail.com  | albertpass |
      | Beth Baines  | bbaines@yahoo.com | bethpass   |
      | Charlie Cole | ccole@hotmail.com | charpass   |
      | Daphne Delia | ddelia@mail.ca    | deliapass  |

  Scenario Outline: Invalid email (Error flow)

    When Administrator "<admin_name>" attempts to login with credentials "<input_email>" and "<input_pass>"
    And "<input_email>" does not match "<admin_email>"
    Then error message "Admin email does not match input email." is issued
    And Administrator "<admin_name>" will remain logged out
    And Administrator "<admin_name>" will remain on the login page

    Examples:
      | admin_name   | admin_email       | admin_pass | input_email      | input_pass |
      | Albert Adams | aadams@gmail.com  | albertpass | albert@gmail.com | albertpass |
      | Beth Baines  | bbaines@yahoo.com | bethpass   | beth@yahoo.com   | bethpass   |
      | Charlie Cole | ccole@hotmail.com | charpass   | charlie@mail.ca  | charpass   |
      | Daphne Delia | ddelia@mail.ca    | deliapass  | daphne@yahoo.com | deliapass  |


  Scenario Outline: Invalid password (Error flow)


    When Administrator "<admin_name>" attempts to login with credentials "<input_email>" and "<input_pass>"
    And "<input_email>" matches "<admin_email>"
    But "<input_pass>" does not match "<admin_pass>"
    Then error message "Admin password does not match input password." is issued
    And Administrator "<admin_name>" will remain logged out
    And Administrator "<admin_name>" will remain on the login page
    Examples:
      | admin_name   | admin_email       | admin_pass | input_email       | input_pass  |
      | Albert Adams | aadams@gmail.com  | albertpass | aadams@gmail.com  | badpass     |
      | Beth Baines  | bbaines@yahoo.com | bethpass   | bbaines@yahoo.com | password    |
      | Charlie Cole | ccole@hotmail.com | charpass   | ccole@hotmail.com | invalidpass |
      | Daphne Delia | ddelia@mail.ca    | deliapass  | ddelia@mail.ca    | wrongpass   |



