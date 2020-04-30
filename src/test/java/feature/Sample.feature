Feature: Gmail Authentication


Scenario: Authenticate via Signin with User1
Given User is on Gmail Signin screen
When User is entering user name "mohanty.sourav100@gmail.com"
And  User is entering password "shreemaa123"
Then User should see the Gmail inbox screen
And User should see all my mails listed under Gmail

Scenario: Authenticate via Signin with User2
Given User is on Gmail Signin screen
When User is entering user name "souravmohanty0@gmail.com"
And  User is entering password "sourav123"
Then User should see the Gmail inbox screen
And User should see all my mails listed under Gmail