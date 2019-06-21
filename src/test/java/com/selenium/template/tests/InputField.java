package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.SimpleFormPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InputField extends ExtentTestListener {


    @Test(groups = "Test", description = "Input Forms > First Input Demo")
    public void Test_01_Input_Forms_First_Input_Demo() throws Exception {

        WebDriver driver = getDriver();;
        SimpleFormPage simpleFormPage = new SimpleFormPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_SIMPLEFORMDEMO);
        driver.manage().window().maximize();

        simpleFormPage.setSimpleFormInputMessage("Hello-message!");
        simpleFormPage.clickSimpleFormShowMessageBUTTON();

        String x = simpleFormPage.checkFormMessage();
        Assert.assertEquals(x, "Hello-message!");
        testPass("Assert message was received: " + x);    }



}


