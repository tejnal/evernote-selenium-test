Feature: Evernote app login functionality

  @unsuccessful
  Scenario: check login is unscuccessful using invalid email
    Given user is on login page
    When user enters the invalid email address
    And user click continue button
    Then user should get that the notification that the email address is invalid

  @successful
  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then verify login must be successful

  @LoginAndCreateNote
  Scenario: login and create a note
    Given user is on login page
    When user enters username and password
    And clicks on login button
    And click create a new note
    And write a title of the note
    And Write some text in note
    Then logout form the evernote

  @LoginAndCheckAlreadyCreatedNote
  Scenario: login and verify existing note
    Given user is on login page
    When user enters username and password
    And clicks on login button
    And clicks on note created in previous test case
    And verify the content of the note
    And move note to trash bin



