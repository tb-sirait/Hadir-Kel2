Feature: Login Page

  Scenario: invalid login
    Given akses url invalid
    When user input username invalid
    And user input password invalid
    And click login button invalid
    Then validate result failed login page

  Scenario: valid login
    Given akses url
    When user input username
    And user input password
    And click login button
    Then validate result login page