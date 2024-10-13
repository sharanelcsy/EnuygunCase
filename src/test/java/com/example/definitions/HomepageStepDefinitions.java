package com.example.definitions;


import com.example.actions.MethodsLibrary;
import com.example.page_objects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static com.example.definitions.Hooks.driver;


public class HomepageStepDefinitions {


    private final HomePage homePage = new HomePage();


    @When("The user opens website {string}.")
    public void userOpensWebsite(String site) throws InterruptedException {
        driver.get("http:///www.enuygun.com");
        homePage.acceptCookies();
        System.out.println("Enuygun.com main page has been opened");


    }

    @Then("Click on {string} and enter {string}.")
    public void clickOnAndEnterRoute(String target, String place) throws Throwable {
        homePage.enterTextToBox(target, place);

    }


    @And("^wait (\\d+) seconds\\.$")
    public void waitSeconds(int number) throws InterruptedException {
        Assert.assertTrue(MethodsLibrary.waitTime(number));
    }


    @Then("Close the browser.")
    public void closeTheBrowser() {
        driver.close();
    }

    @Then("Quit the browser.")
    public void quitTheBrowser() {

        driver.quit();

    }


    @Then("Select on {string} Flight.")
    public void clickOnFlight(String type) throws InterruptedException {
        Assert.assertTrue(homePage.selectFlightType(type));

    }

    @Then("Enter {string} date as {string} in YYYY-MM-DD format.")
    public void enterDateAsInYYYYMMDDFormat(String type, String date) throws InterruptedException {
        Assert.assertTrue(homePage.enterDateToBox(type, date));
    }

    @And("Click on find ticket.")
    public void clickOnFindTicket() throws InterruptedException {
        Assert.assertTrue(homePage.submit());
    }

    @Then("Select {int} Adult , {int} Kid , {int} Baby as passengers in {string} flight.")
    public void selectAdultKidBabyAsPassengers(int adultNumber, int childNumber, int infantNumber, String flightType) throws InterruptedException {
        Assert.assertTrue(homePage.selectAdultKidBabyAsPassengers(adultNumber, childNumber, infantNumber, flightType));
    }


    @Then("Search flights.")
    public void searchFlights() throws InterruptedException {
        Assert.assertTrue(homePage.searchFlights());

    }
}
