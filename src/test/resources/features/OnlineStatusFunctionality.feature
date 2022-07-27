@MTSK-477
Feature: As a user, I should be able to change my online status and set a status message

  Background: User logs in
    Given User logs in with valid credentials "Employee41"
    Then User goes to home page

  @MTSK-544
  Scenario:User sets status message from profile
    Given user clicks to click on the profile icon on the right side of the page
    Then user clicks on the set status text
    Then user sees the online status page
    And user can view the online status on the opened set status page

  @MTSK-545
  Scenario:User sets status message from profile
    Given user clicks to click on the profile icon on the right side of the page
    Then user clicks the set online button
    And user sees the online status page
    And user clicks the Away button on the online status page that opens

  @MTSK-546
  Scenario: User sets status message from profile
    Given user clicks to click on the profile icon on the right side of the page
    Then the User clicks the away button
    Then the user sees the set status page
    And the user selects a status message from the default option
    Then the user clicks the set status message button

  @MTSK-547
  Scenario: User sets status message from profile
    Given user clicks to click on the profile icon on the right side of the page
    Then user click set status button
    Then the user sees the set status page
    Then the user clicks sick
    And the user can set a custom status message using any emoji option
    Then the user should click on the set status message button

  @MTSK-548 @Smoke
  Scenario: User sets status message from profile
    Given user clicks to click on the profile icon on the right side of the page
    Then User clicks on a selected exception message
    Then the user sees the set status page
    Then user clicks the clear status message button to clear the status message
    And the user sees that the message has been deleted
    Then user clicks the clear status after button to clear the status message automatically and can set a time
