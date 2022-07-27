@MTSK-491 @Regression
Feature: As a user, I should be able to create a new contact and edit/delete any contact under Contacts module

  Background: User logs in
    Given User logs in with valid credentials "Employee155"
    Then User goes to Contacts page

  @MTSK-487 @Smoke
  Scenario Outline: User can create a new contact with all properties filled with valid inputs
    Given User clicks to new contact button
    And User fills "<Full name>" "<Company>" "<Title>" "<Phone>" "<Email>" "<City>" "<Country>" properties out
    Then User should be able to see new created contact
    Examples:
      | Full name     | Company | Title   | Phone      | Email             | City   | Country |
      | Didier Drogba | Cydeo   | QA      | 8764756387 | ddrogba@gmail.com | London | England |
      | Muhtar Java   | Cydeo   | Teacher | 2345263767 | mjava@gmail.com   | Mclean | USA     |

  @MTSK-488
  Scenario: User can see all the contacts as a list inside the middle column and
  total number of the contacts near the “All Contacts” tab
    Given User clicks to All contacts link
    Then User should be able to see all contacts in the middle column
    Then User should be able to see the correct number near the "All Contacts" tab

  @MTSK-489
  Scenario: User can change the profile picture of any contact with a
  previously uploaded picture by using “Choose from files” option
    Given User clicks to All contacts link
    And User clicks to a random contact in the middle column
    And User clicks to Change Picture button
    And User clicks to Choose From File button
    And User selects a jpeg file by clicking
    And User clicks to Choose button
    Then User should be able to see the PP has been changed

  @MTSK-490
  Scenario: User can delete any selected contact
    Given User clicks to All contacts link
    And User clicks to a random contact in the middle column
    And User clicks to Three dot menu link
    And User clicks to Delete button
    Then User should be able to see the contact has been deleted


  @MTSK-502
  Scenario: User shouldn't be able to create a new contact with invalid inputs
    Given User clicks to new contact button
    And User fills these properties out
      | Fullname | ^^*09.-A   |
      | Company  | ;!74jds_,  |
      | Title    | 5345gb     |
      | Phone    | dgbs*&gbdg |
      | Email    | Edfbb4-+   |
      | City     | 345:&      |
      | Country  | %*-3"      |
    Then User should see warning message
    Then User shouldn't be able to see new created contact


  Scenario Outline: User can create a new contact with all properties filled with valid inputs
    Given User clicks to new contact button
    And User selects these options
      | Email          | Work   |
      | Social network | GitHub |
      | Phone          | Car    |
    And User fills "<Full name>" "<Company>" "<Title>" "<Phone>" "<Email>" "<City>" "<Country>" properties out
    Then User should be able to see new created contact
    Examples:
      | Full name     | Company | Title   | Phone      | Email             | City   | Country |
      | Didier Drogba | Cydeo   | QA      | 8764756387 | ddrogba@gmail.com | London | England |
      | Muhtar Java   | Cydeo   | Teacher | 2345263767 | mjava@gmail.com   | Mclean | USA     |
