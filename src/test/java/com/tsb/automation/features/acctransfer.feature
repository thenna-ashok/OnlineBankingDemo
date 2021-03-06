@Transfer
Feature: Validate account transfer functionality

  Scenario Outline: Verify the transfer of funds from checking to savings accounts
    Given I navigate to the online banking portal and login with a valid "<username>" and "<password>"
    When I check the "<checkingAcc>" account have enough balance to transfer "<amount>"
    And I navigate to the transfer funds and transfer "<amount>" dollars from "<checkingAcc>" to "<savingsAcc>"
    And I verify that the "<amount>" transferred successfully from "<checkingAcc>"
    And I verify the recent transaction of "<amount>" in "<checkingAcc>" and "<savingsAcc>"
    Then I should logoff the user and close the browser

    Examples:
      | username | password | amount | checkingAcc | savingsAcc |
      | jsmith   | Demo1234 | 200    | 800003      | 800002     |

    ##################################################################################################################

  Scenario Outline: Verify the transfer of funds from savings to checking accounts
    Given I navigate to the online banking portal and login with a valid "<username>" and "<password>"
    When I check the "<savingsAcc>" account have enough balance to transfer "<amount>"
    And I navigate to the transfer funds and transfer "<amount>" dollars from "<savingsAcc>" to "<checkingAcc>"
    And I verify that the "<amount>" transferred successfully from "<savingsAcc>"
    And I verify the recent transaction of "<amount>" in "<savingsAcc>" and "<checkingAcc>"
    Then I should logoff the user and close the browser
    Examples:
      | username | password | amount | checkingAcc | savingsAcc |
      | jsmith   | Demo1234 | 400    | 800003      | 800002     |

    ##################################################################################################################

  Scenario Outline: Verify the transfer of funds from credit card to savings accounts
    Given I navigate to the online banking portal and login with a valid "<username>" and "<password>"
    When I check the "<creditCard>" account have enough balance to transfer "<amount>"
    And I navigate to the transfer funds and transfer "<amount>" dollars from "<creditCard>" to "<savingsAcc>"
    And I verify that the "<amount>" transferred successfully from "<creditCard>"
    And I verify the cash advance fee for the cash withdrawn from "<creditCard>"
    Then I should logoff the user and close the browser

    Examples:
      | username | password | amount | creditCard        | savingsAcc |
      | jsmith   | Demo1234 | 10     | 4539082039396288  | 800002     |

    #################################################################################################################

