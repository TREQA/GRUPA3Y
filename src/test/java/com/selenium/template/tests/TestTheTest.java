package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.google_example.GoogleSearchPage;
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

        WebDriver driver = getDriver();;
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.YAHOO_URL);
        driver.manage().window().maximize();


        Assert.assertTrue(false);
        testPass("Assert failed intentionally");
    }





}


