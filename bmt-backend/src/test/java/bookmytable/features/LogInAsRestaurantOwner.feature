Feature: Log In as RestaurantOwner

As a RestaurantOwner
I would like to log into my account
So that I can create a Restaurant if not created, or view Reservation(s) for created Restaurant

Background:
	Given RestaurantOwner <owner> is on the login page
	And RestaurantOwner <owner> exists
	And RestaurantOwner <owner> is unsuspended

Scenario: Log In with existing RestaurantOwner account and Restaurant exists (Normal Flow)
	
	When RestaurantOwner <owner> inputs email <validEmailOwner> and password <validPasswordOwner>
	And RestaurantOwner <owner> clicks to Log In
	Then RestaurantOwner <owner> is redirected to the RestaurantOwner profile
	And the following Reservation list is returned
	| reservation_id | reservation_datetime | customer_id | table_id |group_size| restaurant_id |
    	| 0001           | 2021-05-25 20:00:00  | 69420       | 3246     |4         | 0001          |
	
Scenario: Log In with existing RestaurantOwner account and Restaurant does not exist (Alternate Flow)
	
	When RestaurantOwner <owner> inputs email <validEmailOwner> and password <validPasswordOwner>
	And RestaurantOwner <owner> clicks to Log In
	Then RestaurantOwner <owner> is redirected to the RestaurantOwner profile
	And RestaurantOwner <owner> has the option to Create Restaurant	      
     
Scenario: Log In with valid email and password is incorrect (Error Flow 1)

	When RestaurantOwner <owner> inputs email <validEmailOwner> and password <invalidPasswordOwner> 
	And RestaurantOwner <owner> clicks to Log In
	Then a "Password is incorrect" error message is issued

Scenario: Log In with invalid email  (Error Flow 2)

	When RestaurantOwner <owner> inputs email <validEmailOwner> and password <password> 
	And RestaurantOwner <owner> clicks to Log In
	Then a "No account associated with this email was found" error message is issued
