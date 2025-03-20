@Group1
Feature: API health check

  @APIHealthCheck
  Scenario: Verify all api requests are responding with status code 200
    Then All apis should return 200 status code
