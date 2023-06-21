Feature: Compare UI and API Experiences

  Scenario: UI and API Experiences


  Scenario Outline: Create new Experience
    Given User send A POST request and logins with "<email>" and "<password>"
    And User sends a POST request and creates new experience with "<title>" "<company>" "<location>" "<from>" "<to>" "<current>" "<description>"
    Then Verify status code is <statusCode>
    And Compiler gets the experience id
    And User creates a GET request to get experience with id
    And User is on the Dashboard page
    Then Verify that UI experience and API experience for the "<company>" should match

    Examples:
      | email            | password | title           | company | location | from       | to         | current | description | statusCode |
      | nhntsc@gmail.com | N12345!  | Software Tester | IBM3    | India    | 2023-05-10 | 2020-05-10 | false   | All is well | 201        |
#      | nhntsc@gmail.com | N12345!  | QA Tester | Oracle  | Netherland | 2022-05-10 | no | true    | All is well | 201        |
#      | nhntsc@gmail.com | N12345!  | SDET      | Tesla   | Netherland | 2022-05-10 | no | true    | All is well | 201        |


