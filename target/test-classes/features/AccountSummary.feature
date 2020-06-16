@accountPageGeneral @regression
Feature: Account Summary Page
  We can write here what we want..
  Scenario: AccSumPage should have right title and account types
    Given the user should be logged in
    Then the Account Summary Page should have title as "Zero - Account summary"
    Then the Account Summary Page should have account types as
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then the Account Summary Page Credit Account table should have columns as
      | Account     |
      | Credit Card |
      | Balance     |

