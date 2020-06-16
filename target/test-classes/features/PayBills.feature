@payBillsGeneral @regression
Feature: Pay Bills Page

  Scenario: Pay Bills page should have right title and should show after successful pay
    Given the user should be logged in
    And the user navigates to "Pay Bills"
    Then the Pay Bills Page should have title as "Zero - Pay Bills"
    When user completes a successful Pay operation
    Then after valid payment "The payment was successfully submitted." should be displayed

  Scenario: Try to make a payment without entering the amount
    Given the user should be logged in
    And the user navigates to "Pay Bills"
    When the user tries to make a payment without entering the amount
    Then after invalid payment "Please fill out this field!" should be displayed on amount
    #wrong displayed

  Scenario: Try to make a payment without entering the date, Please fill out this field message! should be displayed
    Given the user should be logged in
    And the user navigates to "Pay Bills"
    When the user tries to make a payment without entering the date
    Then after invalid payment "Please fill out this field!" should be displayed on date
    #wrong displayed
