Feature: Shopping

  Background:
    Given the home page is opened
    And the cookies is accepted

  Scenario Outline: Successful Shopping without logging in
    Given the user clicked on the 'Shop' button
    And the user added '<item>' to the basket
    Then the user visit check out page
    Given the 'first name' field is filled with 'h'
    And the 'last name' field is filled with 'h'
    And the 'buyer mail' field is filled with 'h@h.com'
    And the 'buyer phone' field is filled with '0620'
    And the 'buyer address' field is filled with 'deb'
    And the 'buyer city' field is filled with 'deb'
    And zip code is '5020'
    And the 'Proceed' button is clicked
    Then the total price should be '<totalPrice>'
    Examples:
    | item                              | totalPrice |
    | JS Data Structures and Algorithm  | ₹153.00    |
    | Mastering JavaScript              | ₹357.00    |
    | Selenium Ruby                     | ₹510.00    |
    | Android Quick Start Guide         | ₹459.00    |

  Scenario Outline: Shopping after logging in
    Given the user clicked on the 'My account' button
    And the 'Username' field is filled with 'h2'
    And the 'Password' field is filled with 'h@h.com123'
    When the 'Login' button is clicked
    Then the my account navigation is visible
    Given the user clicked on the 'Shop' button
    And the user added '<item1>' to the basket
    And the user added '<item2>' to the basket
    When the user visit check out page
    Given the 'Proceed' button is clicked
    Then the total price should be '<totalPrice>'
    Given the user sign out
    Examples:
      | item1                            | item2                      | totalPrice |
      | Functional Programming in JS     | Selenium Ruby              | ₹787.50    |
      | HTML5 Forms                      | HTML5 WebApp Develpment    | ₹483.00    |
      | JS Data Structures and Algorithm | Selenium Ruby              | ₹682.50    |
      | HTML5 Forms                      | Mastering JavaScript       | ₹661.50    |

  Scenario Outline: Errors in filling checkout
    Given the user clicked on the 'Shop' button
    And the user added 'HTML5 Forms' to the basket
    When the user visit check out page
    Given the 'first name' field is filled with '<firstName>'
    And the 'last name' field is filled with '<lastName>'
    And the 'buyer mail' field is filled with '<email>'
    And the 'buyer phone' field is filled with '<phoneNb>'
    And the 'buyer address' field is filled with '<address>'
    And the 'buyer city' field is filled with '<city>'
    And zip code is '<zipcode>'
    And the 'Proceed' button is clicked
    Then the '<errorMessage>' message is shown in 'checkOutError' section
    Examples:
       | firstName |  lastName | email   | phoneNb | address | city | zipcode | errorMessage                                  |
       |           | h         | h@h.com | 1       | h       | h    | 1       | Billing First Name is a required field.       |
       | h         |           | h@h.com | 1       | h       | h    | 1       | Billing Last Name is a required field.        |
       | h         | h         |         | 1       | h       | h    | 1       | Billing Email Address is a required field.    |
       | h         | h         | h@h.com |         | h       | h    | 1       | Billing Phone is a required field.            |
       | h         | h         | h@h.com | 1       |         | h    | 1       | Billing Address is a required field.          |
       | h         | h         | h@h.com | 1       | h       |      | 1       | Billing Town / City is a required field.      |

