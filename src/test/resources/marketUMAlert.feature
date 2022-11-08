Feature:  Alerts

  Each individual alert on the marketalertum website should include an icon,
  a heading, a description, an image, a price and a link to the original product website.

  Scenario: Alert Layout
    Given I am an administrator of the website and I upload 3 alerts
    Given I am a user of marketalertum
    When I view a list of alerts
    Then each alert should contain an icon
    And each alert should contain a heading
    And each alert should contain a description
    And each alert should contain an image
    And each alert should contain a price
    And each alert should contain a link to the original product website