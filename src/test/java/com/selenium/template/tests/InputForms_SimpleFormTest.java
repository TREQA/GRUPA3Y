package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.InputForms_SimpleFormPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InputForms_SimpleFormTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Input Forms > First Input Demo")
    public void Test_01_Input_Forms_First_Input_Demo() throws Exception {

        WebDriver driver = getDriver();;
        InputForms_SimpleFormPage inputFormsSimpleFormPage = new InputForms_SimpleFormPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_SIMPLEFORMDEMO);
        driver.manage().window().maximize();

        inputFormsSimpleFormPage.setSimpleFormInputMessage("Hello-message!");
        inputFormsSimpleFormPage.clickSimpleFormShowMessageBUTTON();

        String x = inputFormsSimpleFormPage.checkFormMessage();
        Assert.assertEquals(x, "Hello-message!");
        testPass("Assert message was received: " + x);   }

    @Test(groups = "Test", description = "Input Forms > First Input Demo")
    public void Test_02_Input_Forms_First_Input_Demo() throws Exception {

        WebDriver driver = getDriver();;
        InputForms_SimpleFormPage inputFieldsSimpleFormPage = new InputForms_SimpleFormPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_SIMPLEFORMDEMO);
        driver.manage().window().maximize();

        inputFieldsSimpleFormPage.setSimpleFormInputMessage("Hello-message!");
        inputFieldsSimpleFormPage.clickSimpleFormShowMessageBUTTON();

        String x = inputFieldsSimpleFormPage.checkFormMessage();
        Assert.assertEquals(x, "Hello-message!");
        testPass("Assert message was received: " + x);   }

}


