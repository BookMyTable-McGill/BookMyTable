Feature: Modify Account Details

As a customer of the Restaurant Booking System
I would like to modify my account details
So that my use of the system changes with my modified credentials.

Background:
    Given a customer <customer_id> is logged into BookMyTable as a customer
    And the customer <customer_id> is an unsuspended user

Scenario: Successfully changing all customer credentials (Normal Flow)
    When the customer <customer_id> queries to change his <username>
    And the customer <customer_id> queries to change his <email_address>
    And the customer <customer_id> queries to change his <password>
    And the customer <customer_id> queries to change his <postal_code>
    Then the customer <customer_id>'s <username>, <email_address>, <password> and <postal_code> are modified Successfully.

Scenario: Successfully changing customer name (Alternate Flow)
    When the customer <customer_id> queries to change his <username>
    Then the customer <customer_id>'s <username> is modified Successfully.


Scenario: Successfully changing customer email address (Alternate Flow)
    When the customer <customer_id> queries to change his <email_address>
    Then the customer <customer_id>'s <email_address> is modified Successfully.

Scenario: Successfully changing customer password (Alternate Flow)
    When the customer <customer_id> queries to change his <password>
    Then the customer <customer_id>'s <password> is modified Successfully.

Scenario: Successfully changing customer postal code (Alternate Flow)
    When the customer <customer_id> queries to change his <postal_code>
    Then the customer <customer_id>'s <postal_code> is modified Successfully.

Scenario: Entering empty credentials (Error Flow)
    When the customer <customer_id> queries to change his <username>, <email_address>, <password> or <postal_code> to be empty
    Then the customer <customer_id>'s <username>, <email_address>, <password> and <postal_code> are not modified
    And the initial customer's credentials are kept the same.

