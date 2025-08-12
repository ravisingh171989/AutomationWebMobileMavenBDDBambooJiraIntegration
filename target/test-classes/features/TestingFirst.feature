#   Author: Anand Ravi
#   https://www.linkedin.com/in/anandravisingh/
#   https://github.com/ravisingh171989
#   https://anand.github.io/

Feature: Test the first scenario.

  @Regression_Test
  Scenario: 01 - First scenario to be tested
    Given I Anand developing the Automation Framework and launches a "SIT" site
    When I login to "Test" site with "testing" credential
    Then I should be able to verify that I am able to login to "testing" account
    And Logout from the application

  @Regression_Test
  Scenario: 02 - Second scenario to be tested
    Given I Anand developing the Automation Framework and launches a "<Test-site>" site
    When I login to "Test" site with "<testing-credential>" credential
    Then I should be able to verify that I am able to login to "testing" account
    #Examples:
    #| Test-site | testing-credential |
    #| Test1     | cred1              |
    #| Test2     | cred2              |

  @Regression_Test
  Scenario: 03 - Third scenario to be tested
    Given I Anand developing the Automation Framework and launches a "<Test-site>" site
    When I login to "<Test-site>" site with "<Testing-credential>" credential
    Then I should be able to verify that I am able to login to "testing" account
    #Examples:
     # | Test-site | Testing-credential |
      #| Test1     | cred1              |
      #| Test2     | cred2              |