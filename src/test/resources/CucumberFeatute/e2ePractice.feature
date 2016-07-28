	Feature: PULSE e2e Test.
@Step1
  Scenario: Open Pulse Website
    Given As a user i open the driver
    When As a user i navigate to the "http://52.32.239.69"
    Then As a user i click on go to pulse
    And As a user i put username
    And As a user i put password

@Step2
  Scenario: New acf registration.
    
    Given As a user i click on acf not found
    When Enter new acf show up
    Then I put name and all the user information
    And I click on Submit
    Then I click on logout
    And I click on login as a existing acf


  Scenario: Changing acf information
    Given As a user i click on edit acf information
    When Edit current acf show up
    Then I put patient information
    And I save all acf information


  Scenario: Search for patient with invalid information
    Given As a user i want to put wrong order date of birth
    When I try to send wrong date of birth information
    Then I should get an invalid dob format error
    
    Scenario: Verify query search page
     Given As a user i want to verify patient query page
    	When I want to verify the error in the bottom
    	
  @Step3  	
  Scenario Outline: Search for patient with valid information
   
    Given I enter the patient firstname "<firstname>" to search
    Given  I enter the patient lastname "<lastname>" to search
    Given I enter patient last four "<ssn>" to search
    Then I click on search
    And I want to verify the result
    
    Examples: 
    |firstname|lastname	|ssn	|
    |John			|Doe			|4563	|	
    |Janet		|Smith		|0099	|
    |Sam			|Johnson	|3333	|
    |Samual		|Johnson	|6790 |
    |Lauren		|Doerty		|8769	|

