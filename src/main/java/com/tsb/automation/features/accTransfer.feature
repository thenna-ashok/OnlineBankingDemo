@Transfer
Feature: Validate account transfer functionality

  Scenario: Verify the transfer of funds from checking to savings accounts
    Given I navigate to the online banking portal and login as a valid user
    When I check the "800003 Checking" account have enough balance to transfer
    And I check the current balance in "800002 Savings" account
    And I navigate to the transfer funds and transfer "100" dollars
#    Then I verify that the funds transferred successfully

#  Examples:
#
#    | amount | checkingAcc     | savingsAcc     |
#    | 100    | 800003 Checking | 800002 Savings |