Feature: User Registration on Facebook

  Scenario: User tries to log in with invalid credentials

    Given I am on facebook page
    And I click on registration button
    When I try to half fill in the details
    Then User registration fails

