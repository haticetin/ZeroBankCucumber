@accountActivityGeneral @regression
Feature: Account Activity Page

  Scenario: AccActPage should have right title and dropdown default option should be Savings
    Given the user should be logged in
    And the user navigates to "Account Activity"
    Then the Account Activity Page should have title as "Zero - Account Activity"
    Then in the Account Activity Page dropdown default option should be "Savings"

  Scenario: In AccActPage account dropdown should have right options
    Given the user should be logged in
    And the user navigates to "Account Activity"
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    #wrong list on the current page ;)
    Then Transactions table should have column names
      |Date|
      |Description|
      |Deposit|
      |Withdrawal|
