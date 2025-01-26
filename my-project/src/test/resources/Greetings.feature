Feature: Greet API

  Scenario: Get greeting message from /greet endpoint
    Given the application is running
    When I send a GET request to "/greet"
    Then I should receive a response with status code 200
    And the response body should be "Hello User!"