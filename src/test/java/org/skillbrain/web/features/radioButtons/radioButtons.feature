@demoqa @radioButtons
Feature: Radio buttons feature

  @regression
  Scenario Outline: User clicks on different radio button
    Given User is on the demoqa page
    When User navigates to "elements" page
    And User clicks on Radio Button on the elements page
    When User clicks on <buton> radio button
    Then User checks the following message is displayed: <message>

    Examples:
      | buton        | message                        |
      | "yes"        | "You have selected Yes"        |
      | "impressive" | "You have selected Impressive" |
      | "no"         | "You have selected No"         |
