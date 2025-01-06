Feature: User Filter

    Background: To access this website, must be logged in with a registered admin account, and access Management User.
        Given Admin is logged in
        And go to Management->User
        When I click filter button
        Then filter page should open

    Scenario: User using filter by Filter Field
        Given User filtered by Unit
        When User is choosed filter unit is "3D"
        Then System showing filtered data by unit

