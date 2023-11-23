Feature:  User Registration

  Background:
    Given the home page is opened
    And the cookies is accepted
    And the user clicked on the 'My account' button

  Scenario: Valid Registeration
    Given the 'Registration email' is filled with randomly generated email
    And the 'Registration password' field is filled with 'h@h.com123'
    When the 'Register' button is clicked
    Then the my account navigation is visible
    And the 'Sign out' button is clicked

  Scenario Outline: Passwords variations
    Given the "Registration email" field is filled with '<email>'
    And the 'Registration password' field is filled with '<password>'
    Then the '<errorMessage>' message is shown in 'regPasswordError' section
    Examples:
    | email   | password          | errorMessage                                 |
    | h@h.com | 12345             | Very weak - Please enter a stronger password.|
    | h@h.com | 12hh              | Weak - Please enter a stronger password.     |
    | h@h.com | Medium@10!1       | Medium                                       |
    | h@h.com | testing@Softwar@1 | Strong                                       |

  Scenario Outline: Invalid registration
    Given the "Registration email" field is filled with '<email>'
    And the 'Registration password' field is filled with '<password>'
    When the 'Register' button is clicked
    Then the '<errorMessage>' message is shown in 'registrationError' section
    Examples:
      | email   | password          | errorMessage                                                                  |
      | h@h.com |                   | Error: An account is already registered with your email address. Please login.|
      | h@h.com | testing@Softwar@1 | Error: An account is already registered with your email address. Please login.|
      |         |                   | Error: Please provide a valid email address.                                  |
      | h@h.co  |                   | Error: Please enter an account password.                                      |
