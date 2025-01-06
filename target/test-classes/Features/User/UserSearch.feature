Feature: Search by Name or NIK
    As a user
    I want to search for records using either a name or NIK
    So that I can find the required information

    @SearchByName
    Scenario Outline: Search by Name
        Given I navigate to the search page
        When I select "Nama" from the search by dropdown
        And I enter "<name>" in the search input and press Enter
        Then I should see results related to "<name>"

        Examples:
            | name             |
            | AANG MULYADI     |
            | Taor Baga        |

    @SearchByNIK
    Scenario Outline: Search by NIK
        Given I navigate to the search page
        When I select "Nik" from the search by dropdown
        And I enter "<nik>" in the search input and press Enter
        Then I should see results related to "<nik>"

        Examples:
            | nik  |
            | D22  |
            | D21  |