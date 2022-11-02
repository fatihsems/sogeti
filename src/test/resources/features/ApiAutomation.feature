Feature: Write API Test

#  API Test for http://api.zippopotam.us/de/bw/stuttgart
  Scenario: Verifying responses
    Given user is on the Api page
    When Verify that the response status code is 200 and content type is "application/json"
    And Verify that the response time is below 1000ms
    And Verify in Response - That country is "Germany" and state is "Baden-Württemberg"
    Then Verify in Response - For Post Code "70597" the place name has "Stuttgart Degerloch"

#  Data Driven Test for http://api.zippopotam.us/{country}/{postal-code}
  Scenario Outline: Api Data Driven Test
    Given information for data driven test below
    Then Verify in Response  "<placeName>" for each input "<country>" and "<postalCode>"
#  Verify that the response status code is 200, content type is "application/json" and the response time is below 1000ms

    Examples:
      | country | postalCode | placeName     |
      | us      | 90210      | Beverly Hills |
      | us      | 12345      | Schenectady   |
      | ca      | B2R        | Waverley      |

