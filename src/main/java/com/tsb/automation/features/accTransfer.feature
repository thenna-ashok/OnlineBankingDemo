@Transfer
Feature: Validate account transfer functionality

  Scenario Outline: Verify the transfer of funds from checking to savings accounts
    Given I navigate to the online banking portal and login with a valid "<username>" and "<password>"
    When I check the "<checkingAcc>" account have enough balance to transfer
    And I check the current balance in "<savingsAcc>" account
    And I navigate to the transfer funds and transfer "<amount>" dollars from "<checkingAcc>" to "<savingsAcc>"
    Then I verify that the "<amount>" transferred successfully from "<checkingAcc>"

    Examples:
      | username | password | amount | checkingAcc | savingsAcc |
      | jsmith   | Demo1234 | 200    | 800003      | 800002     |

    ##################################################################################################################

  Scenario Outline: Verify the transfer of funds from savings to checking accounts
    Given I navigate to the online banking portal and login with a valid "<username>" and "<password>"
    When I check the "<savingsAcc>" account have enough balance to transfer
    And I check the current balance in "<checkingAcc>" account
    And I navigate to the transfer funds and transfer "<amount>" dollars from "<savingsAcc>" to "<checkingAcc>"
    Then I verify that the "<amount>" transferred successfully from "<savingsAcc>"

    Examples:
      | username | password | amount | checkingAcc | savingsAcc |
      | jsmith   | Demo1234 | 400    | 800003      | 800002     |

    ##################################################################################################################

  Scenario Outline: Verify the transfer of funds from credit card to savings accounts
    Given I navigate to the online banking portal and login with a valid "<username>" and "<password>"
    When I check the "<creditCard>" account have enough balance to transfer
    And I check the current balance in "<creditCard>" account
    And I navigate to the transfer funds and transfer "<amount>" dollars from "<creditCard>" to "<savingsAcc>"
    Then I verify that the "<amount>" transferred successfully from "<creditCard>"

    Examples:
      | username | password | amount | creditCard        | savingsAcc |
      | jsmith   | Demo1234 | 50     | 4539082039396288  | 800002     |

    #################################################################################################################

