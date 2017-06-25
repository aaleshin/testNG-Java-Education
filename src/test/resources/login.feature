
Feature: login tests

  Scenario: Login to Redmine
    Given go to login page
    When enter user name aleshin
    And enter password 547348
    And click submit
    Then successfully logged in as Aleshin





