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

Scenario: Already logged in on another device (Alternative flow)

	Given Customer <customer> is already logged in
	When Customer <customer> inputs email <validEmail> and password <validPassword> 
	And Customer <customer> clicks to Log In
	Then Customer <customer> is redirected to the customer profile

Scenario: Log In with invalid email (Error Flow)

	When Customer <customer> inputs email <invalidEmail> 
	And Customer <customer> inputs  password <validPassword> 
	And Customer <customer> clicks to Log In
	Then a "No account associated with this email was found" error message is issued
	And Customer <customer> will remain on the login page

Scenario: Log In with invalid password (Error Flow)
	
	When Customer <customer> inputs email <validEmail> 
	And Customer <customer> inputs  password <invalidPassword> 
	And Customer <customer> clicks to Log In
	Then a "Password is incorrect" error message is issued
	And Customer <customer> will remain on the login page