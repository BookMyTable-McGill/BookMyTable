Feature: Delete Own Customer Account

As a Customer
I want to delete my account
So that my account does not exist anymore

Background:
	
Given customer is logged in
And they are on their modify customer account page

Scenario: Successfully delete customer account (Normal Flow) 

When the customer inputs their password into the delete account field 
And the customer selects to delete their account
Then the customer's account will be deleted
And the customer will not be able to log in to the restaurant booking system anymore

Scenario: Fail to delete customer account (Normal Flow) 

When the customer inputs an incorrect password into the delete account field 
And the customer selects to delete their account
Then the customer's account will not be deleted
And the customer will still be able to log in to the restaurant booking system