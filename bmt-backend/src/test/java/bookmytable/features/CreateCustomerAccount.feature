Feature: Create Customer Account

  As a customer
  I would like to create an account
  So that I can have a more personalized user experience

  Given a customer is on the account creation page

  Scenario Outline: Create a new customer account (Normal Flow)
    When customer attempts to create a customer account with name "<cust_name>" email "<cust_email>" password "<password>" and phone number "<number>"
    Then a new customer account with the customer's name email password and phone number is created
    And the customer is redirected to their account profile

    Examples:
      | cust_name   | cust_email          | password | number    |
      |Joe James    |j.james@hotmail.com  |jj@6789   |234-567-8901 |

  Scenario Outline: Create a new customer account with same email as existing account (Error Flow 1)

    When customer attempts to create a customer account with name "<cust_name>" existing email "<cust_email>" password "<password>" and phone number "<number>"
    Then the error message 'An account with this email already exists' is displayed

    Examples:
      | cust_name   | cust_email      | password | number    |
      |Joe James    |j.james@hotmail.com  |jj@6789   |234-567-8901 |

  Scenario Outline: Create a new customer account with an invalid email (Error Flow 2)

    When customer attempts to create a customer account with name "<cust_name>" invalid email "<cust_email>" password "<password>" and phone number "<number>"
    Then the error message 'Invalid Email' is displayed

    Examples:
      | cust_name   | cust_email | password | number    |
      |Joe James    |joejames       |jj@6789   |234-567-8901 |


  Scenario Outline: Create a new customer account with an invalid password (Error Flow 3)

    When customer attempts to create a customer account with name "<cust_name>" email "<cust_email>" invalid password "<password>" and phone number "<number>"
    Then the error message 'Invalid Password' is displayed

    Examples:
      | cust_name   | cust_email             | password | number    |
      |Joe James    |joejames@hotmail.com    |pass      |234-567-8901 |

  Scenario Outline: Create a new customer account with an invalid phone number (Error Flow 4)

    When customer attempts to create a customer account with name "<cust_name>" email "<cust_email>" password "<password>" and invalid phone number "<number>"
    Then the error message 'Invalid Phone Number' is displayed

    Examples:
      | cust_name   | cust_email          | password | number |
      |Joe James    |j_james@hotmail.com  |jj@6789   |2345    |

  Scenario Outline: Create a new customer account with missing information (Error Flow 5)

    When customer attempts to create a customer account with name "<cust_name>" missing email "<cust_email>" password "<password>" and phone number "<number>"
    Then the error message 'Missing Information' is displayed

    Examples:
      | cust_name   | cust_email | password | number |
      |Joe James    |             |          |        |