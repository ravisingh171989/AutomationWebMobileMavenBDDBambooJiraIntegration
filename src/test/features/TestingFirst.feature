Feature: Test the first scenario.
  Scenario: First scenario to be tested
    Given I Anand developing the Automation Framework and launches a "Test" site
    When I login to "Test" site with "testing" credential
    Then I should be able to verify that I am able to login to "testing" account

  Scenario Outline: First scenario to be tested
    Given I Anand developing the Automation Framework and launches a "<Test-site>" site
    When I login to "Test" site with "<testing-credential>" credential
    Then I should be able to verify that I am able to login to "testing" account
    Examples:
    | Test-site | testing-credential |
    | Test1     | cred1              |
    | Test2     | cred2              |

    Scenario Template:
      Given I Anand developing the Automation Framework and launches a "<Test-site>" site
      When I login to "<Test-site>" site with "<Testing-credential>" credential
      Then I should be able to verify that I am able to login to "testing" account
      Examples:
        | Test-site | Testing-credential |
        | Test1     | cred1              |
        | Test2     | cred2              |