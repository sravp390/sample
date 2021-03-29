#Author: SRAVANI 
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps


#Note:
#Taking each Objective points as a seperate scenario for better Understanding


Feature: To validate the Calculation of all the values in the Home page of ExerciseOne Application.

Background: User is Logged into the application
     Given customer is on homepage
     Then verify that core control is displayed
     

@tag1
Scenario: Need to verify the right count of values appear on the screen
Then all key homepage elements are shown
Then Close the Driver
    

@tag2
Scenario: Need to verify the values on the screen are greater than Zero
Then I verify Values Greater than Zero
Then Close the Driver
    

@tag3 
Scenario: Need to verify the total balance is correct based on the values listed on the screen
When I Calculate the sum of all the values
Then Close the Driver

    
@tag4
Scenario: Need to verify the values are formatted as currencies
Then Verify values are displayed in Currencies
Then Close the Driver

@tag5
Scenario :Need to verify the total balance matches the sum of the values
When I Calculate the sum of all the values and verify with the Excepted Total
Then Close the Driver



