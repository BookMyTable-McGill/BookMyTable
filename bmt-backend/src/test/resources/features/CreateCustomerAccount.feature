Feature: Create Customer Account

As a customer
I would like to create an account
So that I can have a more personalized user experience

Given customer <cust_name> with email <cust_email> and address <cust_address> wishes to create a customer account
  And the customer is currently on the account creation page

  | cust_name   | cust_email          | password | cust_address                             |
  |Joe James    |j.james@hotmail.com  |jj@6789   |223 Avenue Sherbrooke E, Montreal H2X 1E1 |

Scenario: Create a new customer account (Normal Flow)

When customer <cust_name> attempts to create a customer account
  And the customer inputs email <cust_email>
  And the customer inputs password <password>
  And the customer inputs address <cust_address>
  And the customer selects the Create Account button
Then a new customer account with email <cust_email>, password <password>, customer name <cust_name>, address <cust_address> is created
  And customer <cust_name> is redirected to their account profile

  | cust_name   | cust_email          | password | cust_address                             |
  |Joe James    |j.james@hotmail.com  |jj@6789   |223 Avenue Sherbrooke E, Montreal H2X 1E1 |
  |Adam Boucher |aboucher@gmail.com   |ab213ab   |845 Avenue Sherbrooke W, Montreal H3A 0G4 |

Scenario: Create a new customer account with same email as existing account (Error Flow 1)

When customer <cust_name> attempts to create a customer account
  And the customer inputs email <existing_email>
  And the customer inputs password <password>
  And the customer inputs address <cust_address>
  And the customer selects the Create Account button
Then the error message "An account with this email already exists" is displayed

Scenario: Create a new customer account with an invalid email (Error Flow 2)

When customer <cust_name> attempts to create a customer account
  And the customer inputs email <invalid_email>
  And the customer inputs password <password>
  And the customer inputs address <cust_address>
  And the customer selects the Create Account button
Then the error message "Invalid Email Address" is displayed

Scenario: Create a new customer account with an invalid password (Error Flow 3)

When customer <cust_name> attempts to create a customer account
  And the customer inputs email <cust_email>
  And the customer inputs password <invalid_password>
  And the customer inputs address <cust_address>
  And the customer selects the Create Account button
Then the error message "Invalid Password" is displayed

Scenario: Create a new customer account with an invalid address (Error Flow 4)

When customer <cust_name> attempts to create a customer account
  And the customer inputs email <cust_email>
  And the customer inputs password <password>
  And the customer inputs address <invalid_address>
  And the customer selects the Create Account button
Then the error message "Invalid Address" is displayed

Scenario: Create a new customer account with missing information (Error Flow 5)

When customer <cust_name> attempts to create a customer account
  And the customer does not input one or multiple of the required information
Then the error message "Missing Information" is displayed

