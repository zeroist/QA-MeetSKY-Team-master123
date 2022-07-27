@MTSK-501
Feature: As a user, I should be able to add a file to favorites, rename any file and give some comments on any file.

  Background:
    Given User is logged in with valid credentials


  @MTSK-496 @Smoke
  Scenario: User can add any file to favorites from its own three dots menu
    Given User clicks on Files button on top header menu
    And user click on the three dots next to chosen file
    And user clicks on Add to favorites button
    And user clicks on Favorites tab at the left menu
    Then user can see that the file is listed at the Favorites tab


  @MTSK-497
  Scenario: User can rename any file from its own three dots menu
    Given User clicks on Files button on top header menu
    And User navigates to Favorites page
    And user clicks on Favorites tab at the left menu
    And user click on the three dots next to any file in the FavPage
    Then user clicks on Rename button and rename the file as and see the new name

  @MTSK-498
  Scenario: User can put some comments on any file from the file details menu opened right side
    Given User navigates to Favorites page
    And user click on the three dots next to any file in the FavPage
    And user clicks on Details button
    And user clicks on Comments button
    And user clicks on New Comment text filed and types "New comment Added"
    And  User clicks the arrow
    Then user can see that the comment is posted

  @MTSK-499
  Scenario: User can delete the comments made on any file from the the file details menu opened right side
    Given User navigates to Favorites page
    And user clicks to three dot next to Name to move to comment
    And user clicks on Details button
    And user clicks on Comments button
    And user clicks to three dot next to Name on comment section
    And user clicks on Delete comment button
    Then user can see that the comment is deleted

  @MTSK-500 @Smoke
  Scenario: Scenario: User removes the file from favorites from its own three dots menu
    Given User navigates to Favorites page
    And user click on the three dots to removeFrom favorites
    And user clicks on remove from favorites button