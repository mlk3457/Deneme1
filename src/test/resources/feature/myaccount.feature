 Feature: My account edit Functionality

  Background: The user is on home page
    Given The user navigate to web page
    And The user enters login panel credential and clicks login button
    And The user closes cookies page
    And The user clicks the login under the my account
    And The user enters account credentials "nesibe@ogux.sss" and "test1234" and clicks login
    And The user clicks on my account in the my account subcategory
    And The user clicks on the Edit Account button

  Scenario Outline: The user should be able to update the My Account on the DgMarkt website.
    When The user clicks on "<FirstName>" box,"<LastName>" box,"<Email>" box,"<Telephone>" box select enters valid data
    And The user click continue button
    Then Verify that you can receive a my account verification message "<message>"
    And The use standardizes login data
    Examples:
      | FirstName                        | LastName                         | Email           | Telephone                        | message                                              |
      | nesibe                           | oguz                             | nesibe@ogux.sss | 1234567890                       |Success: Your account has been successfully updated.|
      | 123456                           | ..?A!                            | nesibe@ogux.sss | 1234567890                       |Success: Your account has been successfully updated.|

   @nsb
   Scenario Outline: The user should not be able to update the My Account section on the DgMarkt site with incorrect information.
     When The user clicks on the Edit Account button
     And The user clicks on "<FirstName>" box,"<LastName>" box,"<Email>" box,"<Telephone>" box select enters invalid data
     And The user click continue button
     Then Verify that you can receive my account alert message "<message>"
     And The use standardizes login data
     Examples:
       | FirstName                            | LastName                             | Email           | Telephone                         | message                                         |
       |                                      | oguz                                 | nesibe@ogux.sss | 123                               | First Name must be between 1 and 32 characters! |
       | nesibenesibenesibenesibenesibenesibe | oguz                                 | nesibe@ogux.sss | 123                               | First Name must be between 1 and 32 characters! |
       | nesibe                               |                                      | nesibe@ogux.sss | 123                               | Last Name must be between 1 and 32 characters!  |
       | nesibe                               | oguzoguzoguzoguzoguzoguzoguzoguzoguz | nesibe@ogux.sss | 123                               | Last Name must be between 1 and 32 characters!  |
       | nesibe                               | oguz                                 | n.oguz          | 123                               | E-Mail Address does not appear to be valid!     |
       | nesibe                               | oguz                                 | n.oguz@         | 123                               | E-Mail Address does not appear to be valid!     |
