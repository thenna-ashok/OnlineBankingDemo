@Login
Feature: Validate login functionality

  Scenario Outline: Verify user can be login successfully
    Given I navigate to the online banking application url
    When I navigate to online banking portal login page
    And I enter the "<username>" and "<password>" to login
    And I click on login button
    Then I should be on the landing page of user account
    And I wait for "2" seconds
    Then I should logoff the user and close the browser

    Examples:
      | username | password |
      | jsmith   | Demo1234 |

   ##############################################################################################################

  Scenario Outline: Verify login failure for invalid username
    Given I navigate to the online banking application url
    When I navigate to online banking portal login page
    And I enter the "<username>" and "<password>" to login
    And I click on login button
    Then I should see the login failure error message

    Examples:
      | username | password |
      | jsmith1  | Demo1234 |

    ##############################################################################################################

  Scenario Outline: Verify login failure for invalid password
    Given I navigate to the online banking application url
    When I navigate to online banking portal login page
    And I enter the "<username>" and "<password>" to login
    And I click on login button
    Then I should see the login failure error message

    Examples:
      | username | password |
      | jsmith   | Demo123  |

    ###############################################################################################################