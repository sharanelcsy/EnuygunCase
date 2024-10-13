package com.example.actions;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.example.definitions.Hooks.driver;


public class MethodsLibrary {


    // click on element if exists
    public void clickOnElementIfExists(By popup) throws InterruptedException {
        if (driver.findElements(popup).size() != 0) {
            WebElement popUpExistsClose = driver.findElement(popup);
            popUpExistsClose.click();

            Thread.sleep(500);
        }
    }


    // enter text to element , after finding WebElement with path.
    public void enterTextToElement(String input, By popup) {

        if (driver.findElements(popup).size() != 0) {
            WebElement popUpExistsClose = driver.findElement(popup);
            popUpExistsClose.sendKeys(input);
        }

    }

    // extracts string from List Web Element with index parameter
    public String takeStringFromWebElementList(List<WebElement> nameFlight, int index) {
        return nameFlight.get(index).getText();
    }


    public static boolean waitTime(int number) throws InterruptedException {
        Thread.sleep(number * 1000L);
        return true;
    }

    public void scrollToElement(WebElement webElement) throws Exception {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        Thread.sleep(500);
    }

    // searching the date in the attribute of the Element
    // returns true if its found
    public boolean searchAttributeInList(String date, List<WebElement> activeDayList) {
        int index = 0;
        for (index = 0; index < activeDayList.size(); index++) {
            WebElement element = activeDayList.get(index);
            String attribute = element.getAttribute("title");
            if (attribute.equalsIgnoreCase(date)) {
                element.click();
                return true;
            }
        }
        return false;
    }
}



