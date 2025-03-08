@SuccessfulLoginFeature
Feature: Successful login page feature

  @successfulLogin
  Scenario Outline: Logout from practice automation webapp
    Given a user with username "<username>" and password "<password>" is on the successful login page
    When a user clicks on logout button
    Then a user is redirected to the login page with title "<login_page_title>"

    Examples:
      | username | password    | login_page_title |
      | student  | Password123 | Test Login pipe Practice Test Automation |

  @successfulLogin @sanity
  Scenario Outline: Go to practice page
    Given a user with username "<username>" and password "<password>" is on the successful login page
    When a user clicks on practice tab
    Then a user is redirected to practice page with "<practice_page_title>"

    Examples:
      | username | password    | practice_page_title |
      | student  | Password123 | Practice            |

