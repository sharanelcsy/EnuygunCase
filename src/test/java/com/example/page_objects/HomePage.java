package com.example.page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import java.util.List;

import static com.example.definitions.Hooks.driver;
import static com.example.page_objects.FlightListPage.methods;


public class HomePage {



    By acceptCookies = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    By originP = By.xpath("//input[@name='origin']");
    By destination = By.xpath("//input[@name='destination']");
    By departureDate = By.xpath("//input[@name='departureDate']");
    By returnDate = By.xpath("//input[@name='returnDate']");
    By roundTrip = By.xpath("//*[@data-testid=\"search-round-trip-text\"]");
    By departureDateForward = By.xpath("//*[@data-testid='enuygun-homepage-flight-departureDate-month-forward-button']");
    By returnDateForward = By.xpath("//*[@data-testid='enuygun-homepage-flight-returnDate-month-forward-button']");
    By activeDays = By.xpath("//*[@data-testid='datepicker-active-day']");
    By submit = By.xpath("//button[@data-testid='enuygun-homepage-flight-doneBtn']");
    By submitAndSearchFlights = By.xpath("//button[@type='submit']");
    By passengerAndCabin = By.xpath("//div[@data-testid='enuygun-homepage-flight-selectPassengerAndCabin']");
    By economicFlight = By.xpath("//*[@data-testid='enuygun-homepage-flight-ekonomiCabin']");
    By businessFlight = By.xpath("//*[@data-testid='enuygun-homepage-flight-businessCabin']");
    By increaseAdultNumber = By.xpath("//button[@data-testid='flight-adult-counter-plus-button']");
    By increaseChildNumber = By.xpath("//button[@data-testid='flight-child-counter-plus-button']");
    By increaseInfantNumber = By.xpath("//button[@data-testid='flight-infant-counter-plus-button']");

    public HomePage() {

    }



    public void acceptCookies() throws InterruptedException {
        methods.clickOnElementIfExists(acceptCookies);
    }

    public void enterTextToBox(String target, String place) throws InterruptedException {
        if (target.equalsIgnoreCase("Origin")) {
            methods.clickOnElementIfExists(originP);
            methods.enterTextToElement(place, originP);
            driver.findElement(originP).sendKeys(Keys.ENTER);
        } else if (target.equalsIgnoreCase("Destination")) {
            methods.clickOnElementIfExists(destination);
            methods.enterTextToElement(place, destination);
            driver.findElement(destination).sendKeys(Keys.ENTER);
        }


    }


    public boolean selectFlightType(String type) throws InterruptedException {
        if (type.equalsIgnoreCase("Gidiş-Dönüş")) {
            methods.clickOnElementIfExists(roundTrip);

            return true;
        }
        return false;

    }


    // enterDateToBox Function:: Entering the date of flight for departure and takeoff
    // 1st - clicks on departure or return
    // 2nd - searches the date in the dropdown, if it'snot found, it enters a loop.
    // 3rd - Loop is there to press forward on menu to find the date which is parameter.
    // If it's found, date is selected otherwise returns false.
    public boolean enterDateToBox(String type, String date) throws InterruptedException {

        if (type.equalsIgnoreCase("departure"))
            methods.clickOnElementIfExists(departureDate);
        else if (type.equalsIgnoreCase("return"))
            methods.clickOnElementIfExists(returnDate);

        boolean result;
        int index;
        List<WebElement> activeDayList = driver.findElements(activeDays);
        result = methods.searchAttributeInList(date, activeDayList);
        if (result)
            return true;

        else {
            for (index = 0; index < 10; index++) {
                if (type.equalsIgnoreCase("departure"))
                    methods.clickOnElementIfExists(departureDateForward);
                else
                    methods.clickOnElementIfExists(returnDateForward);
                List<WebElement> ListActive = driver.findElements(activeDays);
                result = methods.searchAttributeInList(date, ListActive);
                if (result)
                    return true;
            }
            return false;

        }


    }

    public boolean submit() throws InterruptedException {
        methods.clickOnElementIfExists(submit);
        return true;
    }


    // 1st : selects Economy or Business
    // If adult number is 1 and nothing else is added, it does nothing.
    // Otherwise it clicks on increase button as much as needed.
    public boolean selectAdultKidBabyAsPassengers(int adultNumber, int childNumber, int infantNumber, String flightType) throws InterruptedException {
        methods.clickOnElementIfExists(passengerAndCabin);

        if (flightType.equalsIgnoreCase("Economic"))
            methods.clickOnElementIfExists(economicFlight);
        else
            methods.clickOnElementIfExists(businessFlight);
        /////////////////////////////////////////////////
        if (adultNumber == 1 && childNumber == 0 & infantNumber == 0)
            return true;
        if (adultNumber == 0)
            return false;
        else if (adultNumber > 1 && childNumber > -1 & infantNumber > -1) {

            for (int i = 1; i < adultNumber; i++)
                methods.clickOnElementIfExists(increaseAdultNumber);
            for (int i = 0; i < childNumber; i++)
                methods.clickOnElementIfExists(increaseChildNumber);
            for (int i = 0; i < infantNumber; i++)
                methods.clickOnElementIfExists(increaseInfantNumber);

            methods.clickOnElementIfExists(submit);
            return true;
        } else
            methods.clickOnElementIfExists(submit);
        return false;


    }


    public boolean searchFlights() throws InterruptedException {
        methods.clickOnElementIfExists(submitAndSearchFlights);
        return true;
    }
}