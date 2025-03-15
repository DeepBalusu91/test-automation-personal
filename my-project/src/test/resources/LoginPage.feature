Feature: Facebook Login

  Scenario: User tries to log in with invalid credentials
    Given I am on the Facebook login page
    When I enter invalid username and password
    Then I should see an error message