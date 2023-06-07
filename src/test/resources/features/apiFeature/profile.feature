Feature: Retrieving All Profiles


  Scenario: User able to see all profiles
    Given User sends a GET request and able to see all profiles
    Then Verify that status code is 200


  Scenario: GET Request with Path Parameter
    Given User sends a GET request with id 36
    Then Verify that status code is 200
    Then Verify that user's information, name is "Anderson Talisca" and company is"Al-Hilal" and location is "Riyad"

  Scenario Outline: GET Request One user and verify All Informations
    Given User sends a GET request with id <id>
    Then Verify that status code is 200
    Then Verify that user's information, name is "<name>" and company is"<company>" and location is "<location>"
    Examples:
      | id | name             | company   | location |
      | 36 | Anderson Talisca | Al-Hilal  | Riyad    |
      | 34 | Blg              | Amazon    | Dortmund |
      | 29 | oyku             | Microsoft | Germany  |

    @wip
    Scenario: Register User
      Given User sends a POST request with "nhntsc1234567890@gmail.com" and "N12345!" and "Nihan" and "google" and "facebook" and "github"
      Then Verify that status code is 200
      Then Verify that body contains "token"
      And User sends a POST request with "BMW" and "www.bmw.com" and "Berlin" and "Tester" and "Java" and "Bgit" and "B" and "B" and "B" and "B" and "B"
      Then Verify that status code is 200
      Then Verify that user's information, name is "Nihan" and company is "BMW"
