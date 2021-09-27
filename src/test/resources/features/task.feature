Feature: Keytorc Task

  @task
  Scenario: Samsung search and add to favourites in Hepsiburada
    Given the user is on the dashboard
    When the user is on the login page and logged in
    Then the user sendKeys "samsung" keyword to search
    And the user goes to page "2" from opened page
    And the user adds the "3" th element of the table to the favourite
    And the user should see the selected option in the favourite
    Then the user will remove the product in the favorites and verify that it has been removed
