@demoqa @elements
Feature: Demo QA Form feature

  @regression
  Scenario: Navigate to elements page - happy path
    Given User is on the demoqa page
    When User navigates to "ELEMENTS" page
    And User is redirected to "https://demoqa.com/elements" page
    And User clicks on the text box element
    And User fills user name with "Cristian"
    And User fills email with "test@test.com"
    And User fills in address with "Home"
    And User fills in permanent address 1
    And User clicks submit
    Then I check the correct information is returned on the page

  Scenario: Navigate to elements page - unhappy hapth
    Given User is on the demoqa page
    When User navigates to "forms" page
    And User is redirected to "https://demoqa.com/elements" page
    And User clicks on the text box element
    And User fills user name with "Cristian"
    And User fills email with "test@test.com"
    And User fills in address with "Home"
    And User fills in permanent address 1
    And User clicks submit
    Then I check the correct information is returned on the page

