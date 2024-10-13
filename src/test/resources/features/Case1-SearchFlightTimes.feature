Feature: Search Flight Times


  Scenario: Find flight plan and check flights
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
    Then Check if departure times are between 10 am and 18 pm.
    Then Quit the browser.
