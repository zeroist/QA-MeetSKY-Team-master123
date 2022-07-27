@MTSK-536
Feature: Folder View Functionality [AutomationS4]
  As a user, I should be able to change folder view order by using Name/Size/Modified buttons

  Background:
    Given User goes to login page
    And User logs in with valid credentials "Employee90"
    Then User should be logged in

  @MTSK-493
  Scenario: User can change folder view order by Name
    Given User toggles list view
    When User clicks Name link
    And User scrolls to button of page to load all items
    Then User sees Files and Folders in an order according to their Names

  @MTSK-494
  Scenario: User can change folder view order by Size
    Given User toggles list view
    When User clicks Size link
    And User scrolls to button of page to load all items
    Then User sees Files and Folders in an order according to their Size

  @MTSK-533 @Smoke
  Scenario: User can change folder view order by Modified
    Given User toggles list view
    When User clicks Modified link
    And User scrolls to button of page to load all items
    Then User sees Files and Folders in an order according to Modified day

  @MTSK-534
  Scenario: User can change the folder view by clicking the toggle-view
  button at the right corner of all files tab screen
    Given User click the toggle button
    Then User sees the files and folders' view changed

  @MTSK-535
  Scenario: User can select all the files at once and see the total values of all files in the first line
  when clicked on the “select all” checkbox at the left top corner of the list
    Given User clicks the select All Checkbox at the left top corner of the list
    Then User sees all files and folders are selected



