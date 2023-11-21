Feature: My Account-User can Add or Modify address

  Background: The user is on home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    And The user enters account credentials "mlk@gmail.com" and "Test12345" and clicks login
    And The user clicks on my account in the my account subcategory
    And The user clicks Adress Book button

  Scenario Outline: The user should be able to add new adress with valid credentials
    When The user clicks on the new address button
    And The user clicks on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the No radio button on the default address
    And The user click Continue button
    Then Verify that you can receive a new address verification message "<message>"
    Examples:
      | FirstName | LastName | Company  | Address1 | City | PostCode | Country | Region | message                                  |
      | Mlk       | Falanca  | Falanca  | aaaa     | bbbb | 123456   | Turkey  | Ankara | Your address has been successfully added |
      | M         | Falanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | Your address has been successfully added |


  Scenario Outline: The user should be able to update the address by deleting any field and entering new data.
    When The user clicks on the edit button
    And The user clicks edit address on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the No radio button on the default address
    And The user click Continue button
    Then Verify that you can receive a update adress verification message "<message>"

    Examples:
      | FirstName | LastName | Company  | Address1 | City | PostCode | Country | Region | message                                    |
      | Ahmet     | Falanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | Your address has been successfully updated |
      | Ahmet     | Filanca  | Audit    | cccc     | dddd | 123456   | Turkey  | Ankara | Your address has been successfully updated |


  Scenario Outline: The user should not be able to create a new address if the required field is filled incorrectly or not.
    When The user clicks on the new address button
    And The user clicks on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the No radio button on the default address
    And The user click Continue button
    Then Verify that you can get the error message "<massage>"
    Examples:
      | FirstName                         | LastName                          | Company  | Address1 | City | PostCode    | Country               | Region                | massage                                         |
      |                                   | Falanca                           | Bootflow | aaaa     | bbbb | 123456      | Turkey                | Ankara                | First Name must be between 1 and 32 characters! |
      | AhmetAhmetAhmetAhmetAhmetAhmetAhm | Falanca                           | Bootflow | aaaa     | bbbb | 123456      | Turkey                | Ankara                | First Name must be between 1 and 32 characters! |
      | Ahmet                             |                                   | Bootflow | aaaa     | bbbb | 123456      | Turkey                | Ankara                | Last Name must be between 1 and 32 characters!  |
      | Ahmet                             | FalancaFalancaFalancaFalancaFalan | Bootflow | aaaa     | bbbb | 123456      | Turkey                | Ankara                | Last Name must be between 1 and 32 characters!  |
      | Ahmet                             | Falanca                           | Bootflow | aaaa     | bbbb | 12345678901 | Germany               | Berlin                | Postcode must be between 2 and 10 characters!   |
      | Ahmet                             | Falanca                           | Bootflow | aaaa     | bbbb | 123456      | --- Please Select --- | --- None ---          | Please select a country!                        |
      | Ahmet                             | Falanca                           | Bootflow | aaaa     | bbbb | 123456      | Turkey                | --- Please Select --- | Please select a region / state!                 |


  Scenario Outline: If the user has an address, they should not be able to delete it.
    When The user clicks on the edit button
   # And The user clicks on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the radio button "<radiobutton>" on the default address
    And The user click Continue button
    When The user clicks Delete button
    Then Verify that you cannot delete the default address "<message>"
    Examples:
      | FirstName | LastName | Company  | Address1 | City | PostCode | Country | Region | radiobutton | message                                           |
      | Ahmet     | Falanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | No          | Your address has been successfully deleted        |
      | Ahmet     | Falanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | Yes         | Warning: You can not delete your default address! |

  Scenario Outline: If the user has an address
    When The user clicks on the edit button
    And The user clicks the radio button "<radiobutton>" on the default address
    And The user click Continue button
    When The user clicks Delete button
    Then Verify that you cannot delete the default address "<message>"
    Examples:
      | radiobutton | message                                           |
      | Yes         | Warning: You can not delete your default address! |
      | No          | Your address has been successfully deleted        |

  Scenario Outline: If the user has an address, they should not be able to delete it.
    When The user clicks on the edit button
    And The user clicks on "<FirstName>" box,"<LastName>" box,"<Company>" box,"<Address1>" box,"<City>" box and "<PostCode>" box and "<Country>" select and "<Region>" select enters valid data
    And The user clicks the radio button "<radiobutton>" on the default address
    And The user click Continue button
    When The user clicks Delete button
    Then Verify that you cannot delete the default address "<message>"
    Examples:
      | FirstName | LastName | Company  | Address1 | City | PostCode | Country | Region | radiobutton | message                                           |
      | Ahmet     | Falanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | Yes         | Warning: You can not delete your default address! |
      | Ahmet     | Falanca  | Bootflow | aaaa     | bbbb | 123456   | Turkey  | Ankara | No          | Warning: You can not delete your default address! |



  Scenario:
    When The user clicks Delete button