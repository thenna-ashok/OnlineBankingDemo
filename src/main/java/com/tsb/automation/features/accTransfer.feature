@Transfer
Feature: Validate account transfer functionality

  Scenario Outline: Verify the transfer of funds from checking to savings accounts
    Given I navigate to the online banking portal and login with a valid "<username>" and "<password>"
    When I check the "<checkingAcc>" account have enough balance to transfer
    And I check the current balance in "<savingsAcc>" account
    And I navigate to the transfer funds and transfer "<amount>" dollars from "<checkingAcc>" to "<savingsAcc>"
    Then I verify that the "<amount>" transferred successfully

    Examples:
      | username | password | amount | checkingAcc | savingsAcc |
      | jsmith   | Demo1234 | 200    | 800003      | 800002     |