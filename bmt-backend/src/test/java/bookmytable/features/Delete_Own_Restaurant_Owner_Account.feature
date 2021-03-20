Feature: Delete Own Restaurant Owner Account

As a Restaurant Owner
I want to delete my account
So that my account does not exist anymore

Background:
	
Given a restaurant owner is logged in
And they are on their modify restaurant owner account page

Scenario: Successfully delete restaurant owner account (Normal Flow) 

When the restaurant owner inputs their password into the delete account field 
And the restaurant owner selects to delete their account
Then the restaurant owner's account will be deleted
And the restaurant owner's restaurants will be deleted
And the restaurant owner will not be able to log in to the restaurant booking system anymore

Scenario: Fail to delete restaurant owner account (Normal Flow) 

When the restaurant owner inputs an incorrect password into the delete account field 
And the restaurant owner selects to delete their account
Then the restaurant owner's account will not be deleted
And the restaurant owner's restaurants will not  be deleted
And the restaurant owner will still be able to log in to the restaurant booking system