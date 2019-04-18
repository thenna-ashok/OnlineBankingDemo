@Login
Feature: Validate login functionality

  Scenario Outline: Verify user can be login successfully
    Given I navigate to the online banking application url
    When I navigate to online banking portal login page
    And I enter the "<username>" and "<password>" to login
    And I click on login button
    Then I should be on the landing page of user account

    Examples:
    | username | password |
    | jsmith   | Demo1234 |