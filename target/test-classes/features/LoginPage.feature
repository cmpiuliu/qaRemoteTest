Feature: LoginPage

  Background:
    Given User is on the login page

  Scenario: Login using invalid credentials and validate unsuccessful login
    When User enters credentials "invalid_user", "invalid_password"
    And Click on the Login button
    Then The appropriate error message "Your username is invalid!" is displayed

  Scenario: Login using the recommended username & password, and validate successful login
    When User enters credentials "tomsmith", "SuperSecretPassword!"
    And Click on the Login button
    Then User is successfully logged in to the landing page
    And The appropriate login validation message "You logged into a secure area!" is displayed

  Scenario: Validate successful logout
    When User enters credentials "tomsmith", "SuperSecretPassword!"
    And Click on the Login button
    And Click on the Logout button
    Then User is successfully logged out
    And The appropriate logout validation message "You logged out of the secure area!" is displayed

