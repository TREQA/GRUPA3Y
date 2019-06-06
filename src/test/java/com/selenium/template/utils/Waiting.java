package com.selenium.template.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.selenium.template.extent_report.ExtentTestListener.testInfo;


public class Waiting {


    // --------------------------------------- Explicit Waits

    /**
     *
     * @param driver - driver instance
     * @param element - locator (WebElement)
     * @param elementName - element name
     */
    public static void elementToBeClickable(WebDriver driver, WebElement element, String elementName) {
        testInfo("> " + elementName + " : waiting to be clickable");
        try {
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException toe) {
            Assert.fail("> " + elementName + " : is not clickable within : " + TestData.SHORT_WAIT + " seconds" );
        } catch (NoSuchElementException e) {
            Assert.fail("> " + elementName + " : is not found ");
        }
    }

    /**
     *
     * @param driver - driver instance
     * @param element - locator (WebElement)
     * @param seconds - time to wait for element to be clickable
     * @param elementName - element name
     */
    public static void elementToBeClickable(WebDriver driver, WebElement element, int seconds, String elementName) {
        testInfo("> " + elementName + " : waiting to be clickable");
        try {
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException toe) {
            Assert.fail("> " + elementName + " : is not clickable within : " + TestData.SHORT_WAIT + " seconds" );
        } catch (NoSuchElementException e) {
            Assert.fail("> " + elementName + " : is not found ");
        }
    }


}
