Feature: Login

  In order to provide users of the website with individual alerts.
  As a user I should be able to login using valid credentials and see
  my alerts.

  Scenario: Valid Login
    Given I am a user of marketalertum
    When I login using valid credentials
    Then I should see my alerts


  Scenario: Invalid Login
    Given I am a user of marketalertum
    When I login using invalid credentials
    Then I should see the login page
