Feature: Log In as Customer

As a Customer
I would like to log into my account
So that I can view and/or modify my reservations, my contact information or my preferred restaurants

Background:
	Given Customer <customer> is on the login page
	And Customer <customer> exists
	And Customer <customer> is unsuspended

Scenario: Log In with existing Customer Account (Normal Flow)

	When Customer <customer> inputs email <validEmail> and password <validPassword> 
	And Customer <customer> clicks to Log In
	Then Customer <customer> is redirected to the customer profile

Scenario: Log In with invalid credentials (Error Flow)

	When Customer <customer> inputs email <invalidEmail> and password <invalidPassword> 
	And Customer <customer> clicks to Log In
	Then a "Email and password do not match" error message is issued

