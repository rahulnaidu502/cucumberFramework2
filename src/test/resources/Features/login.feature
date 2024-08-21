Feature: login functionality

Background: 
Given user should be on login page


Scenario: TC_01_valid_login
When user enter the valid credentials
Then user should be navigated to Home page
And user should see the logout link


Scenario: TC_02_Invalid_login
Given user should be on login page
When user enter the invalid credentials
Then user can see error message


@Test2
Scenario Outline: TC_03_Invalid_login data driven
When user enter the invalid userid as "<userid>" and password is "<password>"
Then user can see error message
Examples:   
|userid  | password  |
|ad1     | Pwd1      |
|ad2     | Pwd2      | 
|ad3     | Pwd3      | 