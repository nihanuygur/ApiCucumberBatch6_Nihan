Feature: Post to community

  @wip
  Scenario: User should be able to create a new post
    Given User send A POST request and logins with "nhntsc@gmail.com" and "N12345!"
    And User send a POST request and creates a post with title "Hello" and text "Group1 girls are studying"
    Then Verify that status code is 200 - post feature
    And Compiler gets the post id
    And User creates a GET request to get post with id
    And User is on the Post page
    Then Verify that UI post and API post for the title should match
