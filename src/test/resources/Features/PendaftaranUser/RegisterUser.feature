Feature: User Registration
    As an admin
    I want to register new users
    So that they can access the system

    Scenario: Successful user registration with complete information
        Given I am on the user registration page
        When I upload an employee photo less than 2MB
        And I enter valid NIK "D0123456789"
        And I enter employee name "Taor"
        And I enter email "taor@juaracoding.com"
        And I enter password "SecurePass123"
        And I select division "Bastion"
        And I select unit "BCA"
        And I select position "SQA Analyst"
        And I select job title "Coding Juara"
        And I select contract type "Magang"
        And I select work location "DIKA 1"
        And I select work schedule "Testing"
        And I enter selfie is "No Selfie"
        And I enter leave balance "12"
        And I click the submit button
        Then I should see a success message

    Scenario: Required field validation
        Given I am on the user registration page
        When I click the submit button
        Then I should see error messages for required fields