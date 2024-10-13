package com.example.definitions;


import com.example.page_objects.FlightListPage;
import com.example.page_objects.InformationPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;



public class FlightPageStepDefinitions {


    private final FlightListPage flightPage = new FlightListPage();


    @Then("Check if departure times are between {int} am and {int} pm.")
    public void checkIfDepartureTimesAreBetweenAmAndPm(int am, int pm) throws Exception {
        Assert.assertTrue(FlightListPage.checkIfDepartureTimesAreBetweenAmAndPm(am, pm));

    }


    @Then("Validate if THY prices are sorted from low to high.")
    public void checkIfTHYPricesAreSortedFromLowToHigh() throws Exception {
        Assert.assertTrue(FlightListPage.checkIfTHYPricesAreSortedFromLowToHigh());
    }

    @Then("Select the 1st flight to go to to information page.")
    public void selectTheStFlightToGoToToPaymentPage() throws InterruptedException {
        Assert.assertTrue(FlightListPage.selectFlightAndForward());

    }

    @Then("Enter information to go to payment page and validate if page exists")
    public void enterInformationToGoToPaymentPage() throws InterruptedException {
        Assert.assertTrue(InformationPage.enterInformationToGoToPaymentPage());
    }
}
