Feature: Smava Home Page User Stories

Scenario: User tries to find info about loan
  Given User is on smava home page
  When  User performs search by entering loan related valid values
  Then  User is taken to first step of loan processing

Scenario: User tries to login with invalid credential is shown error page
  Given User is on smava home page
  When  User enters invalid credentials to login
  Then  User is taken to error page
