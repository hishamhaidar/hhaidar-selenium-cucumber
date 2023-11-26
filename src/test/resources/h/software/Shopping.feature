Feature: Shopping

  Background:
    Given the home page is opened
    And the cookies is accepted

  Scenario Outline: Shopping after logging in
    Given the user clicked on the 'My account' button
    When the 'Username' field is filled with 'h2'
    And the 'Password' field is filled with 'h@h.com123'
    And the 'Login' button is clicked
    Then the my account navigation is visible
    Given the user clicked on the 'Shop' button
    And the user added '<item1>' to the basket
    And the user added '<item2>' to the basket
    When the 'Basket' button is clicked
    And the 'Checkout' button is clicked
    Then the check out page is open
    Given the 'Proceed' button is clicked
    Then the total price should be '<totalPrice>'
    Given the user sign out
    Examples:
    | item1                            | item2                      | totalPrice |
    | Functional Programming in JS     | Selenium Ruby              | ₹787.50    |
    | HTML5 Forms                      | HTML5 WebApp Develpment    | ₹483.00    |
    | JS Data Structures and Algorithm | Selenium Ruby              | ₹682.50    |
    | HTML5 Forms                      | Mastering JavaScript       | ₹661.50    |

  Scenario Outline: Successful Shopping without logging in
    Given the user clicked on the 'Shop' button
    And the user added '<item1>' to the basket
    And the user added '<item2>' to the basket
    Then the 'Basket' button is clicked
    And the 'Checkout' button is clicked
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
      | item1                            | item2                      | totalPrice |
      | Functional Programming in JS     | Selenium Ruby              | ₹510.00    |
      | HTML5 Forms                      | HTML5 WebApp Develpment    | ₹469.20    |
      | JS Data Structures and Algorithm | Selenium Ruby              | ₹663.00    |
      | HTML5 Forms                      | Mastering JavaScript       | ₹642.60    |