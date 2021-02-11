Feature: View Restaurant Info
  
  As a customer
	I would like to view the information of a restaurant
	So that I can decide if I want to make a reservation at it

Scenario: Customer Views Information of a Restaurant (Normal Flow)
  Given customer <customer> is unsuspended 
  And <customer> is logged into BookMyTable as a customer
  And <customer> is browsing the nearby restaurants on BookMyTable
  When <customer> selects to view the info of the restaurant of their choice
	Then <customer> is redirected to the selected restaurant page 

Scenario: Customer attempts to access restaurant info using direct url instead of accessing it through BookMyTable (Error Flow)
	Given customer <customer> is not using BookMyTable
  And <customer> types restaurant landing page url into search engine
  When <customer> submits the search
  Then <custmer> will be redirected to a page indicating the desired page can only be accessed through BookMyTable
  And <customer> is prompted to redirect to login page of BookMyTable
