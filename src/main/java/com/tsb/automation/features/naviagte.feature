@Navigate
Feature: Navigating to the url and validate the page load

  Scenario: Verify navigating to the specified url
    Given I navigate to the starting url
    When I verify that the web page is loaded successfully
    And I navigate to the banking portal login page via online banking login options
    Then I could confirm that navigating to the website works correctly

