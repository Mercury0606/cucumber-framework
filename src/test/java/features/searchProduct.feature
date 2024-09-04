Feature: Search and Place the order for Products

  Scenario: Search Experience for product search in both home and offers page
    Given User is on GreenCart Landing Page
    When User searched with shortname "Tom" and extracted actual name of product
    Then User searched with same "Tom" in offers page
    And Validate product name in offers page matches with Landing page
