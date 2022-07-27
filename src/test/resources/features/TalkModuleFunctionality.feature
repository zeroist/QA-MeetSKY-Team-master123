@MTSK-542
Feature: As a user, I should be able to create/delete conversation groups and chat with other co-workers under Talk Module

  Background: User logs in
    Given User logs in with valid credentials "Employee51"
    Then User goes to Talk page

@MTSK-538 @Smoke
  Scenario: User can create a new group conversation by adding other users
    Given User clicks to plus sign on the left side of the page
    Given User enters the "friends" conversation name
    Then User clicks Add Participants button
    Then User chooses any of the contacts from the contacts list
    Then User clicks Create Conversation button
    Then User verify "friends" has created

@MTSK-539
  Scenario: User can see the participants of the conversation on the right-hand menu under Participants
  Given User clicks to "friends" group on the left side of the page
  Then User verify that he or she can see the participants of the group conversation under Participants tab

@MTSK-540
  Scenario: User can remove any participant from the conversation as being moderator of the conversation
    Given User clicks to "friends" group on the left side of the page
    Then User locates the participants of the group conversation under Participants tab
    And User clicks to the three dots next to participant name
    And User clicks to the Remove participant button
    Then User verify the participant has been succesfully removed from the group


@MTSK-541 @Smoke
  Scenario: User can delete any group conversation previously created
    Given User clicks to three dots on the right side of the "friends"
    Then User clicks to the Delete conversation button
    Then User clicks to Yes button on the pop-up asking Do you really want to delete friends?
    Then User verify that deleted group conversation is not existing inside the available group conversations










