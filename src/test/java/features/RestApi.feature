Feature: Rest API testing

  Scenario Outline: Search Rest Api
    Given Search for all objects
    When Search for object by ID
    And Search for a single product with "<num>"

    Examples:
    |num|
    |7|
    |3|
