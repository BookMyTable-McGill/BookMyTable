Feature: Delete User

As an administrator
I want to delete any type of user account
So that said account does not exist anymore

Background:
	
Given an administrator is logged in
And they are viewing all the existing users

Scenario: Deleting a customer account (Normal Flow) 

Given the administrator wants to delete a customer account
When they delete said customer account
Then the customer's account will be deleted
And the customer will not be able to log in to the restaurant booking system anymore

Scenario: Deleting a restaurant owner's account (Alternate Flow)

Given the administrator wants to delete a restaurant owner account
When they delete said restaurant owner
Then the restaurant owner's account will be deleted
And the restaurant owner's restaurants will be deleted
And the restaurant owner will not be able to log in to the restaurant booking system anymore