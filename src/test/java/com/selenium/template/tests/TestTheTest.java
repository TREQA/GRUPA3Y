package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.google_example.GoogleSearchPage;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyPage;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyTwoInput;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestTheTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Verify logo is present after search is made")
    public void Test_01_Verify_logo_present_after_search() throws Exception {

        WebDriver driver = getDriver();;
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.GOOGLE_URL);
        driver.manage().window().maximize();

        googleSearchPage.setGoogleSearchField("random string");
        googleSearchPage.clickGoogleSearchButton();

        Assert.assertEquals(driver.getTitle(), "Google");
        testPass("Assert google page title");

        Assert.assertTrue(googleSearchPage.isEnabledGoogleLogo(), "Google logo is enabled : ");
        testPass("Assert google logo is present after search is made");
    }

    @Test(groups = "Test", description = "Verify false negative")
    public void Test_01_Verify_some_other_shit() throws Exception {

        WebDriver driver = getDriver();
        ;
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.YAHOO_URL);
        driver.manage().window().maximize();


        Assert.assertTrue(false);
        testPass("Assert failed intentionally");
    }

    @Test(groups = "Test", description = "Adding text to the first input and verifying if it was entered")
    public void Test_01_Verify_One_Input() throws Exception {
        String messageToBeEntered = "Yay!";

        WebDriver driver = getDriver();
        SeleniumEasyPage seleniumEasyPage = new SeleniumEasyPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_INPUTS_URL);
        driver.manage().window().maximize();

        seleniumEasyPage.setEnterMessage(messageToBeEntered);

        seleniumEasyPage.clickShowMessage();

        System.out.println("CHECKPOINT!");

        seleniumEasyPage.getYourMessage(messageToBeEntered);

    }

    @Test(groups = "Test", description = "Adding and verifying if 2 integers were added and their results")
    public void Test_01_Verify_2_Inputs() throws Exception {

        WebDriver driver = getDriver();;
        SeleniumEasyTwoInput seleniumEasyTwoInput = new SeleniumEasyTwoInput(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_INPUTS_URL);
        driver.manage().window().maximize();

        int firstNumber = 1;
        int secondNumber = 2;

        String stringFirstSum = String.valueOf(firstNumber);
        String stringSecondSum = String.valueOf(secondNumber);


        seleniumEasyTwoInput.setFirstSum(stringFirstSum);

        seleniumEasyTwoInput.setSecondSum(stringSecondSum);

        seleniumEasyTwoInput.setClickToGetTotal();

        //Convert strings to integer and then assert the result

    }

}
