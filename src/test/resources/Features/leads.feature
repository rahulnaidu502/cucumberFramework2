Feature: lead functionality

Background: 
Given user should be on login page
When user enter the valid credentials


@only
Scenario: TC_04_create_lead
When user fills the mandatory fields as "<lastname>" and "<Company>"
|lastname  | Company   |
|ad1       | Pwd1      |
|ad2       | Pwd2      | 
|ad3       | Pwd3      | 
Then leads should be created successfully
And click on logout