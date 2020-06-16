@login @regression
Feature: Users should be able to login

  Background:
    Given the user on the login page
  @loginValid
  Scenario:Login with valid credantials
    When the user enter valid credantials
    Then the user should be able to login
  @loginInvalid
  Scenario: Login with invalid credantials
    When the user enter invalid credantials
    Then the user should not be able to login
  @loginBlank
  Scenario: Login with blank credantials
    When the user enter blank credantials
    Then the user should not be able to login