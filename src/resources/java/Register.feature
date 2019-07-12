Feature: Register
Scenario: Registration functionality
Given launch TestMe
And login with user credentials
|userName|firstName|lastName|password|confirmPassword|Gender|emailAddress|mobileNumber|dob|address|securityQuestion|answer|
|anitha111|priya|durai|abc123|abc123|Female|priya123@gmail.com|9234567890|12/03/1997|abcdffggh|What is your Birth Place?|perungalathur|
When registration is done
Then user must be in the login page