Feature: Log In As Admin

As an Administrator of the Restaurant Booking System
I would like to log in as Administrator
So that I can perform administrative actions on the system

Background:
Given Administrator <admin_name> exists
And Administrator <admin_name> has email <admin_email>, password <admin_pass>

Scenario Outline: Successful login (Normal flow)

Given Administrator <admin_name> is logged out
When Administrator <admin_name> attempts to login using email <admin_email> and password <admin_pass>
Then Administrator <admin_name> will be logged in
And Administrator <admin_name> will be redirected to the administrator profile

|admin_name	|admin_email		|admin_pass	|
|Andy Adams	|aadams@gmail.com	|adamspass	|
|Beth Baines	|bbains@yahoo.com	|bethpass	|
|Charlie Cole	|ccole@hotmail.com	|charpass	|
|Daphne Delia	|ddelia@mail.ca		|deliapass	|

Scenario Outline: Already logged in on another device (Alternative flow)

Given Administrator <admin_name> is already logged in
When Administrator <admin_name> attempts to login using email <admin_email> and password <admin_pass>
Then <admin_name> will remain logged in
And Administrator <admin_name> will be redirected to the administrator profile

|admin_name	|admin_email		|admin_pass	|
|Andy Adams	|aadams@gmail.com	|adamspass	|
|Beth Baines	|bbains@yahoo.com	|bethpass	|
|Charlie Cole	|ccole@hotmail.com	|charpass	|
|Daphne Delia	|ddelia@mail.ca		|deliapass	|

Scenario Outline: Invalid email (Error flow)

When Administrator <admin_name> attempts to login with credentials <input_email> and <input_pass>
And <input_email> does not match <admin_email>
Then error message "No account associated with this email was found" is issued
And Administrator <admin_name> will remain logged out
And Administrator <admin_name> will remain on the login page

|admin_name	|admin_email		|admin_pass	|input_email		|input_pass	|
|Andy Adams	|aadams@gmail.com	|adamspass	|andy@gmail.com		|adamspass	|
|Beth Baines	|bbains@yahoo.com	|bethpass	|bbains@yahoo.com	|password	|
|Charlie Cole	|ccole@hotmail.com	|charpass	|ccole			|charpass	|
|Daphne Delia	|ddelia@mail.ca		|deliapass	|ddelia@yahoo.com	|wrongpass	|


Scenario Outline: Invalid password (Error flow)

When Administrator <admin_name> attempts to login with credentials <input_email> and <input_pass>
And <input_email> matches <admin_email>
But <input_pass> does not match <admin_pass>
Then error message "Password is incorrect" is issued
And Administrator <admin_name> will remain logged out
And Administrator <admin_name> will remain on the login page

|admin_name	|admin_email		|admin_pass	|input_email		|input_pass	|
|Andy Adams	|aadams@gmail.com	|adamspass	|aadams@gmail.com	|badpass	|
|Beth Baines	|bbains@yahoo.com	|bethpass	|bbains@yahoo.com	|password	|
|Charlie Cole	|ccole@hotmail.com	|charpass	|ccole@hotmail.com	|invalidpass	|
|Daphne Delia	|ddelia@mail.ca		|deliapass	|ddelia@mail.ca		|wrongpass	|



