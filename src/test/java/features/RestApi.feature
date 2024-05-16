Feature: Rest API testing

  Scenario Outline: Search Rest Api
    Given Search for all objects
    When Search for object by ID
    And Search for a single product with "<num>"

    Examples:
    |num|
    |7|
    |3|

  Scenario: Add new object
    Given Add new object to catalog
    When Update the object with color
    And Partial update the name of the object
    Then Delete object