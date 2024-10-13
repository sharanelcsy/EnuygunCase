Feature: Check THY prices are sorted


  Scenario: Check THY prices are sorted
    When The user opens website "enuygun.com".
    Then Select on "Gidiş-Dönüş" Flight.
    Then Click on "Origin" and enter "İstanbul".
    Then Click on "Destination" and enter "Ankara".
    And wait 1 seconds.
    Then Enter "departure" date as "2024-11-11" in YYYY-MM-DD format.
    And wait 1 seconds.
    Then Enter "return" date as "2024-11-16" in YYYY-MM-DD format.
    Then Select 1 Adult , 0 Kid , 0 Baby as passengers in "Economic" flight.
    Then Search flights.
    And wait 10 seconds.
    Then Validate if THY prices are sorted from low to high.
    Then Quit the browser.
