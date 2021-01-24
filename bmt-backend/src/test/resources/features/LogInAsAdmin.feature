Feature: Log In As Admin

As an Administrator of the Restaurant Booking System
I would like to log in as Administrator
So that I can perform administrative actions on the system

Background:
Given Administrator <admin_name> exists
And Administrator <admin_name> has email <admin_email>, password <admin_pass>

Scenario Outline: Successful login (Normal flow)

Given Administrator <admin_name> has current <login_status> equal to False
When Administrator <admin_name> attempts to login using email <admin_email> and password <admin_pass>
Then Administrator <admin_name> will be logged in
And Administrator <admin_name> will be redirected to the administrator profile

|admin_name	|admin_email		|admin_pass	|login_status	|
|Andy Adams	|aadams@gmail.com	|adamspass	|False		|
|Beth Baines	|bbains@yahoo.com	|bethpass	|False		|
|Charlie Cole	|ccole@hotmail.com	|charpass	|False		|
|Daphne Delia	|ddelia@mail.ca		|deliapass	|False		|

Scenario Outline: Already logged in on another device (Alternative flow)

Given Administrator <admin_name> has current <login_status> equal to True
When Administrator <admin_name> attempts to login using email <admin_email> and password <admin_pass>
Then <admin_name> will remain logged in
And Administrator <admin_name> will be redirected to the administrator profile

|admin_name	|admin_email		|admin_pass	|login_status	|
|Andy Adams	|aadams@gmail.com	|adamspass	|True		|
|Beth Baines	|bbains@yahoo.com	|bethpass	|True		|
|Charlie Cole	|ccole@hotmail.com	|charpass	|True		|
|Daphne Delia	|ddelia@mail.ca		|deliapass	|True		|

Scenario Outline: Invalid credentials (Error flow)

When Administrator <admin_name> attempts to login with credentials <input_email> and <input_pass>
And <input_email> does not match <admin_email>
Or <input_pass> does not match <admin_pass>
Then an error message is issued
And Administrator <admin_name> will remain logged out
And Administrator <admin_name> will remain on the login page

|admin_name	|admin_email		|admin_pass	|input_email		|input_pass	|
|Andy Adams	|aadams@gmail.com	|adamspass	|andy@gmail.com		|adamspass	|
|Beth Baines	|bbains@yahoo.com	|bethpass	|bbains@yahoo.com	|password	|
|Charlie Cole	|ccole@hotmail.com	|charpass	|ccole			|invalidpass	|
|Daphne Delia	|ddelia@mail.ca		|deliapass	|ddelia@yahoo.com	|wrongpass	|
