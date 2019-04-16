@Test
Feature: Test navigating to the URL


  Scenario: Verify navigating to the specified url
    Given I navigate to the starting url
    And I verify that the web page is loaded
    When The page loads correctly with required details
    Then I confirm that navigating to the website works correctly

