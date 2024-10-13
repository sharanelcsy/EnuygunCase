package com.example.page_objects;


import com.example.actions.MethodsLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static com.example.definitions.Hooks.driver;


public class FlightListPage extends HomePage {

    static MethodsLibrary methods = new MethodsLibrary();


    static By departureTimes = By.xpath("//*[@data-testid='departureTime']");
    static By flightsListed = By.xpath("//*[@class='flight-summary-airline']");
    static By flightPrices = By.xpath("//*[@class='summary-average-price']");
    static By returnFlights = By.xpath("//div[contains(@class,'flight-summary-promo')]");
    static By selectFlight = By.xpath("//div[@class='flight-summary-select']");
    static By forward = By.xpath("//button[@data-testid='providerSelectBtn']");
    static By basicFlight = By.xpath("//div[contains(@data-testid,'returnProviderPackageItemBASIC')]");


    public FlightListPage() {

    }


    // checkIfDepartureTimesAreBetweenAmAndPm Method.
    // Split the departure times with character :
    // Takes 1st part of the string, checks if it's before than AM parameter and after than PM parameter.
    public static boolean checkIfDepartureTimesAreBetweenAmAndPm(int am, int pm) throws Exception {

        List<WebElement> flightDepartureTimes = driver.findElements(departureTimes);

        int i;
        for (i = 0; i < flightDepartureTimes.size(); i++) {
            methods.scrollToElement(flightDepartureTimes.get(i));
            String flightTimes = methods.takeStringFromWebElementList(flightDepartureTimes, i);
            String[] parts = flightTimes.split(":");
            int firstPartOfTime = Integer.parseInt(parts[0]);

            if (firstPartOfTime < am || firstPartOfTime > pm) {
                System.out.println("There are flights before 10 am and after 18pm");
                return true;
            }

        }
        return false;
    }


    /* checkIfTHYPricesAreSortedFromLowToHigh Function
    It saves 2 List WebElements, one for flights and other one is the corresponding price.
    Only checks THY flights by method of contains to know if flight is from THY.
    Then the sort logic is:
    1-) Checks if the price is  equal or greater than the previous one if it is, update the initial price.
    2-) If it'snot, then prices aren't sorted and return true. Otherwise return true.
     */
    public static boolean checkIfTHYPricesAreSortedFromLowToHigh() throws Exception {
        List<WebElement> flights = driver.findElements(flightsListed);
        List<WebElement> flightsPrices = driver.findElements(flightPrices);

        int priceControl = 0;
        int priceControl2 = 0;
        for (int i = 0; i < flights.size(); i++) {

            String flightNameSaved = methods.takeStringFromWebElementList(flights, i);
            String pricesSaved = methods.takeStringFromWebElementList(flightsPrices, i);
            String[] priceslist = pricesSaved.split("[,.\\s+]");
            int pricesPart1 = Integer.parseInt(priceslist[0]);
            int pricesPart2 = Integer.parseInt(priceslist[1]);
            methods.scrollToElement(flights.get(i));

            if (flightNameSaved.contains("Türk") || flightNameSaved.contains("Türk Hava")) {
                if (pricesPart1 == priceControl && pricesPart2 >= priceControl2) {
                    priceControl2 = pricesPart2;
                } else if (pricesPart1 >= priceControl) {
                    priceControl = pricesPart1;
                    priceControl2 = pricesPart2;
                } else {
                    return false;
                }
            }

        }
        return true;

    }

    public static boolean selectFlightAndForward() throws InterruptedException {
        methods.clickOnElementIfExists(selectFlight);
        methods.clickOnElementIfExists(forward);
        methods.clickOnElementIfExists(returnFlights);
        methods.clickOnElementIfExists(basicFlight);
        return true;
    }


    // checks flights are listed and not 0.
    public boolean checkIfFlightsAreListed() {
        return !driver.findElements(departureTimes).isEmpty();

    }


}