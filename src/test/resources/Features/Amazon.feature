Feature: To validate the login feature

  @iphone
  Scenario: Verify the login feature
    Given user launch the browser and url
    When user search the product
    And user clicks the product
    Then verify the product details page
