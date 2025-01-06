Feature: Export Data User

    Background: To access this website, must be logged in with a registered admin account, and access Management User.
        Given User logged in as Admin
        When User in Dashboard page
        Then direct to Management->User

    Scenario: User want to export User Data to XLSX
        Given User want to export
        When User click Export button
        Then System exporting "export-users.xlsx" to local directory