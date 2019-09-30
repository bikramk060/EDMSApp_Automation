Feature: Login in EDMS Application

Scenario: Login with valid Username and Password
Given User Enters valid Username
And   User enters valid password
When  User Clicks on Login Button
Then  User should log in succesfully

Scenario: Login with invalid Username
Given User Enters invalid Username
When  User Clicks on Login Button
Then  User should get error message

Scenario: Login with invalid Password
Given User Enters valid Username
And   User enters invalid password
When  User Clicks on Login Button
Then  User should get error message

