@MTSK-480   @MTSK-555
Feature:Profile Settings Functionality
  User Story :
  As a user, I should be able to change profile info settings under the Profile module
  Acceptance Criteria:
  #User can see at least following titles inside personal info under Profile Settings page;
  # =>Full name/Email/Phone Number
 #User can change "Full name" info under Profile Settings page
  #User can make "Phone number" info as private under Profile Settings page
  #User can see the current local time under the Local dropdown


  Background:user logs in
    Given User logs in with valid credentials "Employee31"
    Then user should see homepage


  @MTSK-551 @Smoke
  Scenario:User can see at least following titles inside personal info under Profile Settings page;
  =>Full name/Email/Phone Number
    Given user is on the homepage
    When user clicks on account menu
    And user clicks on accountMenuSettingsButton
    Then user should see full name Title
    Then user should see email title
    Then user should see phone number title

  @MTSK-552
  Scenario:User can change "Full name" info under Profile Settings page
    Given user is on the homepage
    When user clicks on account menu
    And user clicks on accountMenuSettingsButton
    When user enters a new full name "newEmployee" inside full name box
    Then user should see new Full name "newEmployee" inside the full name box and on the profile

  @MTSK-553
  Scenario:User can make "Phone number" info as private under Profile Settings page
    Given user is on the homepage
    When user clicks on account menu
    And user clicks on accountMenuSettingsButton
    And user clicks on phoneOptionsButton
    And user selects phonePrivateOption
   #  Then user should see notice message as "Authentication required"
    #  And user enters valid password in the AuthenticationInputBox
     # And user clicks on confirm button
    Then phone should be private

  @MTSK-554
  Scenario:User can see the current local time under the Local dropdown
    Given user is on the homepage
    When user clicks on account menu
    And user clicks on accountMenuSettingsButton
    Then user should see the current local time under the local dropdown