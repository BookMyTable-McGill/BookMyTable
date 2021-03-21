Feature: Add Photos

As a Restaurant Owner
I would like to add Photos
So that the customer can browse the seating plan and menu

Background:
Given a Restaurant Owner is logged in to BookMyTable as a restaurant owner

Scenario: The restaurant owner sucessfully adds a Photo (Normal Flow)
When the restaurant owner selects a restaurant
And the restaurant owner requests to add a photo
And the restaurant owner provides a link to a photo
Then the restaurant has a new link to a photo

Scenario: The restaurant owner fails to provide a link (Error Flow)
When the restaurant owner selects a restaurant
And the restaurant owner requests to add a photo
And the restaurant owner does not provides a link to a photo
Then a status message is displayed