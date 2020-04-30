Feature: Geo API validation

Scenario: Add place API validation
Given User provide all the pre-requiste details of Add api
When User trigger the endpoints of Add api via Post request 
Then User should get the valid response as status code 200
And User should see the place id as part of response


Scenario: Update place API validation
Given User provide place Id with other pre-requiste details 
When User trigger the endpoints of Update api via Put request 
Then User should get the valid response as status code 200
And User should see the updated message

Scenario: Get place API validation
Given User provide place id to retrive place details
When User trigger the endpoints of get place api via Get request 
Then User should get the valid response as status code 200
And User should see the updated addreess as part of response
