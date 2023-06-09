Feature: Profile Feature

  Background:
    Given User send A POST request and logins with "nhntsc@gmail.com" and "N12345!"
    Then Verify that status code is 200
    And Verify that body contains "token"

  Scenario Outline: Create new Experience
    Given User send A POST request and logins with "<email>" and "<password>"
    Then Verify that status code is 200
    And Verify that body contains "token"
    And User sends a POST request and creates new experience with "<title>" , "<company>" , "<location>" , "<from>" , "<to>" , "<current>" , "<description>"
    Then Verify that status code is <statusCode>

    Examples:
      | email            | password | title  | company | location | from       | to | current | statusCode |
      | nhntsc@gmail.com | N12345!  | Tester | Amazon  | India    | 2022-05-10 | no | true    | 201        |

  Scenario Outline: Create new Experience
    And User sends a POST request and creates new experience with "<title>" , "<company>" , "<location>" , "<from>" , "<to>" , "<current>"
    Then Verify that status code is <statusCode>

    Examples:
      | title  | company | location | from       | to | current | statusCode |
      | Tester | Amazon  | India    | 2022-05-10 | no | true    | 201        |

  Scenario: Retrieve experience by id
    Given User sends a GET request with experience id ""
