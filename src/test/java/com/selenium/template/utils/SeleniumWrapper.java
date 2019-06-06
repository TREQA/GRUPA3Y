package com.selenium.template.utils;

import com.selenium.template.exceptions.LinkDoesNotExistException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;

import static com.selenium.template.extent_report.ExtentTestListener.testInfo;

public class SeleniumWrapper {

    /**
     *
     * @param element - locator (WebElement)
     * @param elementName - element name
     */
    public static void clearElement(WebElement element, String elementName) {
        testInfo("> " + elementName + " : clearing field");
        try {
            element.clear();
        } catch (NoSuchElementException e) {
            Assert.fail("> " + elementName  + " : is not found)");
        }

    }

    /**
     *
     * @param driver - driver instance
     * @param element - locator (WebElement)
     * @param elementName - element name
     */
    public static void moveToElement(WebDriver driver, WebElement element, String elementName) {
        testInfo("> " + elementName + " : moving to");
        try {
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
        } catch (NoSuchElementException e) {
            Assert.fail("> " + elementName  + " : is not found");
        }
    }

    /**
     *
     * @param element - locator (WebElement)
     * @param text - text to be sent to element
     * @param elementName - element name
     */
    public static void sendKeys(WebElement element, String text, String elementName) {
        clearElement(element, elementName);
        testInfo("> " + elementName + " : sending keys : " + text);
        try {
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("> " + elementName  + " : is not found)");
        }

   }

    /**
     *
     * @param driver - driver instance
     * @param element - locator (WebElement)
     * @param elementName - element name
     */
    public static void clickElement(WebDriver driver, WebElement element, String elementName) {
        Waiting.elementToBeClickable(driver, element, elementName);
        moveToElement(driver, element, elementName);
        testInfo("> " + elementName + " : clicking");
        try {
            element.click();
        } catch (NoSuchElementException e) {
            Assert.fail("> " + elementName  + " : is not found)");
        }
    }


    public static String getText(WebElement element, String elementName){
        String text = null;
        Log4Test.info("> " +  elementName);
        try {
            text = element.getText();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found : "  + elementName);
        }
        return text;
    }



    public static Boolean isEnabled(WebElement element, String elementName){
        Boolean elementEnable = null;
        try {
            testInfo("> " + elementName  +" - verifying if enabled");
            elementEnable =  element.isEnabled();
        } catch (NoSuchElementException e) {
            Assert.fail("> " + elementName  + " : is not found)");
        }
        return elementEnable;
    }

    public static void openIfLinkExists(WebDriver driver, String URLName) throws LinkDoesNotExistException {
        testInfo("Navigating to : " + URLName);
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection conn = (HttpURLConnection) new URL(URLName).openConnection();
            conn.setRequestMethod("HEAD"); // Using HEAD since we wish to fetch only meta data
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                driver.get(URLName);
            } else {
                throw new LinkDoesNotExistException();
            }
        } catch (Exception e) {
            throw new LinkDoesNotExistException();
        }
    }
}
