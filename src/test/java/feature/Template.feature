Feature: Validate Content Playback

Scenario: Validate playback of VOD content
Given User is a subscriber
And User is on VOD contnetdetails screen
When User click on play button
Then User should see the VOD content playback from the beginning 