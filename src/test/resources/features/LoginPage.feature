@loginFeature
Feature: Login page feature

  @login @regression
  Scenario Outline: Login to practice test automation with valid credentials
    Given a user is on the login page
    When a user login with valid username "<username>" and password "<password>"
    Then a user is redirected successfulLogin page with "<login_successful_message>"

    Examples:
      | username | password    | login_successful_message |
      | student1  | Password123 | Logged In Successfully   |

  @login
  Scenario Outline: Login to practice test automation with invalid credentials
    Given a user is on the login page
    When a user login with invalid username "<username>" and or password "<password>"
    Then a user is should see a message "<error_message>"

    Examples:
      | username | password     | error_message             |
      | student1 | Password123  | Your username is invalid! |
      | student  | Password1234 | Your password is invalid! |
