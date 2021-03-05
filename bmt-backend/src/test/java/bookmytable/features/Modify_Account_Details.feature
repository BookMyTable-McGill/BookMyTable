Feature: Modify Account Details

As a customer of the Restaurant Booking System
I would like to modify my account details
So that my use of the system changes with my modified credentials.

Background:
    Given a customer <customer_id> is logged into BookMyTable as a customer
    And the customer <customer_id> is an unsuspended user

Scenario: Successfully changing all customer credentials (Normal Flow)
    When the customer <customer_id> queries to change his <name>
    And the customer <customer_id> queries to change his <email_address>
    And the customer <customer_id> queries to change his <password>
    And the customer <customer_id> queries to change his <phone_number>
    Then the customer <customer_id>'s <name>, <email_address>, <password> and <phone_number> are modified Successfully.

Scenario: Successfully changing customer name (Alternate Flow)
    When the customer <customer_id> queries to only change his <name>
    Then the customer <customer_id>'s <name> is modified Successfully.


Scenario: Successfully changing customer email address (Alternate Flow)
    When the customer <customer_id> queries to only change his <email_address>
    Then the customer <customer_id>'s <email_address> is modified Successfully.

Scenario: Successfully changing customer password (Alternate Flow)
    When the customer <customer_id> queries to only change his <password>
    Then the customer <customer_id>'s <password> is modified Successfully.

Scenario: Successfully changing customer phone number (Alternate Flow)
    When the customer <customer_id> queries to only change his <phone_number>
    Then the customer <customer_id>'s <phone_number> is modified Successfully.

Scenario: Entering empty credentials (Error Flow)
    When the customer <customer_id> queries to change his <name>, <email_address>, <password> or <phone_number> to be empty
    Then the customer <customer_id>'s <name>, <email_address>, <password> and <phone_number> are not modified
    And the initial customer's credentials are kept the same.

