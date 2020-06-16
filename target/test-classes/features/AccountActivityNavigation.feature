@regression
Feature: Navigating to specific accounts in Accounts Activity

  Scenario Outline: <accountLink> account redirect
    Given the user should be logged in
    When the user clicks on "<accountLink>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<selectedDropdown>" selected
    Examples:
      | accountLink | selectedDropdown |
      | Savings     | Savings          |
      | Brokerage   | Brokerage        |
      | Checking    | Checking         |
      | Credit Card | Credit Card      |
      | Loan        | Loan             |

