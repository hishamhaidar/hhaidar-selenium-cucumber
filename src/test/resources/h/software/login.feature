Feature: Saucedemo User Login

  Background:
    Given the home page is opened
    And the cookies is accepted
    And the user clicked on the 'My account' button

  Scenario Outline: Incorrect login attempts
    Given the 'Username' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    Then the '<errorMessage>' message is shown
    Examples:
      | username              | password       | errorMessage|
      |                       |                | Error: Username is required. |
      |  h                    |                | Error: Password is required. |
      |                       | h              | Error: Username is required. |
      | h2                    | wrong_password | Error: The password you entered for the username h2 is incorrect. Lost your password? |
      | unregistered_username | random_password| Error: The username unregistered_username is not registered on this site. If you are unsure of your username, try your email address instead. |

  Scenario: Valid login attempt
    Given the 'Username' field is filled with 'h2'
    And the 'Password' field is filled with 'h@h.com123'
    When the 'Login' button is clicked
    Then the my account navigation is visible