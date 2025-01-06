Feature: Reset data User

    Background: To access this website, must be logged in with a registered admin account, and access Management User.
        Given User wants to log in as Admin
        When User logged in
        Then User direct to page Management->User

    Scenario: User using reset data after search
        Given User find user by Nik
        When User want to reset data as before
        Then System will restore the data as before