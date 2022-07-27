@UploadEditDeleteFileFeature
Feature: MeetSky login feature
  User story: As a user, I should be able to upload a file, move or delete any selected file under the Files module

  Background: User logs in
    Given User logs in with valid credentials "Employee21"
  # Valid Username: Employee21
  # Valid Password: Employee123

  @MTSK-504 @UploadingAFile
  Scenario: User can upload a file
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the upload file section from the dropdown menu
    And user enters the source of file to upload and clicks okay button
    Then user should see the source of file under the Files module

  @MTSK-505 @CreatingANewFolder @Smoke
  Scenario: User can create a new folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    Then user should see the created folder under the Files module

  @MTSK-506 @CreatingANewTextDocument
  Scenario: User can create a new text document
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    Then user should see the created text document in the title

  @MTSK-507 @CreatingAFolderWithSameName
  Scenario: User can not create a new folder with existing name
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    Then user should see the alert says it already exists

  @MTSK-508 @CreatingATextDocumentWithSameName
  Scenario: User can not create a new text document with existing name
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user clicks the close button
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    Then user should see the alert says the text document already exists

  @MTSK-509 @CreatingAFolderWithSpecialCharacter
  Scenario: User can not create a new folder name with / this character
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name includes slash punctuation
    Then user should see the alert says that slash punctuation is not allowed inside a file name

  @MTSK-510 @CreatingATexDocumentWithSpecialCharacter
  Scenario: User can not create a new text document name with / this character
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name includes slash punctuation
    Then user should see the alert says that slash punctuation is not allowed inside a file name

  @MTSK-511 @CreatingAFolderWithDotPunctuation
  Scenario: User can not create a new folder name with dot punctuation
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name includes dot punctuation
    Then user should see the alert says that dot punctuation is an invalid file name

  @MTSK-512 @CreatingATexDocumentWithDotPunctuation
  Scenario: User can not create a new text document name with dot punctuation
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name includes dot punctuation
    Then user should see the alert says that dot punctuation is not allowed inside a file name

  @MTSK-513 @CreatingAFolderWithEmptyFolderName
  Scenario: User can not create a new folder without name
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user deletes given name in the new folder input and clicks enter
    Then user should see the alert says that file name cannot be empty

  @MTSK-514 @CreatingATxtDocumentWithEmptyTextDocumentName
  Scenario: User can not create a new text document without name
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user deletes given name in the new text document input and clicks enter
    Then user should see the alert says that text document name cannot be empty

  @MTSK-515 @MoveATextDocumentToAFolder
  Scenario: User can move a text document to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that text document
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects move option
    And user opens the folder
    Then user see that the text file is there

  @MTSK-516 @CopyATextDocumentToAFolder
  Scenario: User can copy a text document to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that text document
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects copy option
    And user opens the folder
    Then user see that the text file is there

  @MTSK-517 @MoveMultipleTextDocumentToAFolder
  Scenario: User can move more than one text document to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a different text document name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that text documents
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects move option
    And user opens the folder
    Then user see that text files are there

  @MTSK-518 @CopyMultipleTextDocumentToAFolder
  Scenario: User can copy more than one text document to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a different text document name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that text documents
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects copy option
    And user opens the folder
    Then user see that text files are there

  @MTSK-519 @MoveAFolderToAFolder
  Scenario: User can move a folder to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters another folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to the newly created folder
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects move option
    And user opens the folder
    Then user see that newly created folder is there

  @MTSK-520 @CopyAFolderToAFolder
  Scenario: User can copy a folder to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters another folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to the newly created folder
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects copy option
    And user opens the folder
    Then user see that newly created folder is there

  @MTSK-521 @MoveMultipleFolderToAFolder
  Scenario: User can move more than one folder to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters another folder name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a different folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that folders
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects move option
    And user opens the folder
    Then user see that newly created folders are there

  @MTSK-522 @CopyMultipleFolderToAFolder
  Scenario: User can copy more than one folder to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters another folder name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a different folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that folders
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects copy option
    And user opens the folder
    Then user see that newly created folders are there

  @MTSK-523 @MoveBothTextDocumentAndFolderToAFolder
  Scenario: User can move both text document and folder to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters another folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to another folder and text document
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects move option
    And user opens the folder
    Then user see that newly created folder and text document are there

  @MTSK-524 @CopyBothTextDocumentAndFolderToAFolder
  Scenario: User can copy both text document and folder to a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters another folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to another folder and text document
    And user clicks the Actions dropdown menu
    And user selects Move or Copy file option
    And user sees the new page
    And user clicks the folder
    And user selects copy option
    And user opens the folder
    Then user see that newly created folder and text document are there

  @MTSK-525 @DeleteAFolder
  Scenario: User can delete a folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user goes to deleted files page
    And user clicks the select all checkbox in the deleted files page
    And user clicks the Actions dropdown menu in the deleted files page
    And user selects delete option in the deleted files page
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user refreshes the page
    And user selects the three dots dropdown menu belongs to the folder
    And user selects delete option from three dots dropdown menu
    And user goes to deleted files page
    Then user see the deleted folder there

  @MTSK-526 @DeleteMultipleFolder
  Scenario: User can delete more than one folder
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user goes to deleted files page
    And user clicks the select all checkbox in the deleted files page
    And user clicks the Actions dropdown menu in the deleted files page
    And user selects delete option in the deleted files page
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters another folder name and clicks enter
    And user refreshes the page
    And user selects the checkbox near to that newly created folders
    And user clicks the Actions dropdown menu
    And user selects delete option
    And user goes to deleted files page
    Then user see the deleted folders there

  @MTSK-527 @DeleteATextDocument
  Scenario: User can delete a text document
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user goes to deleted files page
    And user clicks the select all checkbox in the deleted files page
    And user clicks the Actions dropdown menu in the deleted files page
    And user selects delete option in the deleted files page
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user clicks the close button
    And user turns back to the dashboard
    And user selects the three dots dropdown menu belongs to the text document
    And user selects delete option of text document three dots dropdown menu
    And user refreshes the page
    And user goes to deleted files page
    Then user see the deleted text document there

  @MTSK-528 @DeleteMultipleTextDocuments
  Scenario: User can delete more than one text document
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user goes to deleted files page
    And user clicks the select all checkbox in the deleted files page
    And user clicks the Actions dropdown menu in the deleted files page
    And user selects delete option in the deleted files page
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user clicks the close button
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a different text document name and clicks enter
    And user clicks the close button
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that text documents
    And user clicks the Actions dropdown menu
    And user selects delete option
    And user goes to deleted files page
    Then user see the deleted text documents there

  @MTSK-529 @DeleteBothFolderAndATextDocument
  Scenario: User can delete both of the folder and text documents
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user goes to deleted files page
    And user clicks the select all checkbox in the deleted files page
    And user clicks the Actions dropdown menu in the deleted files page
    And user selects delete option in the deleted files page
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user clicks the close button
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    And user selects the checkbox near to that folder and text document
    And user clicks the Actions dropdown menu
    And user selects delete option
    And user goes to deleted files page
    Then user see the deleted folder and text document there

  @MTSK-530 @TotalNumberOfFoldersAndTextDocuments
  Scenario: User can delete both of the folder and text documents
    Given user is on the Files module of MeetSky application, and dashboard page does not have any file.
    When user clicks the plus icon top left of the page
    And user clicks the New Text Document section from the dropdown menu
    And user enters a text document name and clicks enter
    And user clicks the close button
    And user turns back to the dashboard
    And user clicks the plus icon top left of the page
    And user clicks the New Folder section from the dropdown menu
    And user enters a folder name and clicks enter
    And user turns back to the dashboard
    And user refreshes the page
    Then user see total number of folders and text documents there.