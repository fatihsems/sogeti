Feature: Opening sub menu, filling contact form and verifying country page links

  Background:
    Given the user is on the home page

  Scenario Outline: User should be able to open the Automation page
    Given the user should be able to hover over "<mainLink>" Link and click the "<subLink>" link
    And The "<subLink>" Screen should be displayed
    And The "<pageText>" text should be visible in Page
    When the user hover over mainLink Link again
    Then verify that the mainMenu and subMenu are selected "<mainLink>" "<subLink>"
    Examples:
      | mainLink | subLink    | pageText   |
      | Services | Automation | Automation |
#      | Explore  | Blogs            | Blogs            |
#      | Why us?  | Proven Expertise | Proven Expertise |


  Scenario: User should be able to fill and send Contact us Form
    Given the user should be able to hover over "Services" Link and click the "Automation" link
    And the user scroll down to the Contact us Form
    And the user fill the First Name, Last Name, Email, Phone and Message fields with Random Generated Data
    And the user check the I agree checkbox
    And the user check the i am not a robot checkbox
    And the user click submit button
    Then Thank you message is displayed

  Scenario Outline: Country links should work properly
    When the user click Worldwide Dropdown
    And the user should see Countries
    Then verify that all the Country specific Sogeti links are working "<country>" "<partialPageTitle>"

    Examples:
      | country     | partialPageTitle |
      | Belgium     | Belgium          |
      | Finland     | Finland          |
      | France      | France           |
      | Germany     | Deutschland      |
      | Ireland     | Ireland          |
      | Luxembourg  | Luxembourg       |
      | Netherlands | Technology       |
      | Norway      | Norge            |
      | Spain       | España           |
      | Sweden      | Sverige          |
      | UK          | UK               |
      | USA         | USA              |