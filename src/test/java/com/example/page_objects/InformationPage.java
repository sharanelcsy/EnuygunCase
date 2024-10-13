package com.example.page_objects;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.example.definitions.Hooks.driver;
import static com.example.page_objects.FlightListPage.methods;


public class InformationPage extends HomePage {


    static By emailBox = By.xpath("//input[@id='contact_email']");
    static By cellphone = By.xpath("//input[@id='contact_cellphone']");
    static By firstName = By.xpath("//input[@id='firstName_0']");
    static By lastName = By.xpath("//input[@id='lastName_0']");
    static By birthDateD = By.xpath("//select[@id='birthDateDay_0']");
    static By birthDateM = By.xpath("//select[@id='birthDateMonth_0']");
    static By birthDateY = By.xpath("//select[@id='birthDateYear_0']");
    static By checkBox = By.xpath("//*[@class='form-check tcNo citizien-checkbox']");


    public InformationPage() {

    }


    public static boolean enterInformationToGoToPaymentPage() throws InterruptedException {
        methods.enterTextToElement("counter@hotmail.com",emailBox);
        methods.enterTextToElement("3334422121",cellphone);
        methods.enterTextToElement("test",firstName);
        methods.enterTextToElement("tester",lastName);
        methods.clickOnElementIfExists(checkBox);
        methods.clickOnElementIfExists(birthDateD);
        Select dropdown = new Select(driver.findElement(birthDateD));
        dropdown.selectByIndex(4);
        methods.clickOnElementIfExists(birthDateM);
        Select dropdown2 = new Select(driver.findElement(birthDateM));
        dropdown.selectByIndex(4);
        methods.clickOnElementIfExists(birthDateY);
        Select dropdown3 = new Select(driver.findElement(birthDateY));
        dropdown.selectByIndex(19);
return true;
    }


}