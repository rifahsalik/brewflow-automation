
Feature: Coffee Cart homepage

  Scenario: Verify that the Coffee Cart homepage loads successfully
    Given the browser is open
    When the user navigates to the Coffee Cart homepage
    Then the homepage title should be "Coffee cart"

  Scenario: Verify that the homepage has the correct title
    Given the browser is open
    When the user navigates to the Coffee Cart homepage
    Then the homepage title should be "Coffee cart" 
