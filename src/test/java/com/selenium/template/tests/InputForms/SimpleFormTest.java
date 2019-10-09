package com.selenium.template.tests.InputForms;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.InputForms.SimpleFormPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SimpleFormTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Input Forms > Single Input Field")
    public void Test_01_Input_Forms_First_Input_Demo() throws Exception {

        WebDriver driver = getDriver();;
        SimpleFormPage inputFormsSimpleFormPage = new SimpleFormPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_SIMPLEFORMDEMO);
        driver.manage().window().maximize();

        inputFormsSimpleFormPage.setSimpleFormInputMessage("Hello-message!");
        inputFormsSimpleFormPage.clickSimpleFormShowMessageBUTTON();

        String x = inputFormsSimpleFormPage.checkFormMessage();
        Assert.assertEquals(x, "Hello-message!");
        testPass("Assert message was received: " + x); }

    @Test(groups = "Test", description = "Input Forms > Two Input Fields TODOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO")
    public void Test_02_Input_Forms_First_Input_Demo() throws Exception {

        WebDriver driver = getDriver();;
        SimpleFormPage inputFieldsSimpleFormPage = new SimpleFormPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_SIMPLEFORMDEMO);
        driver.manage().window().maximize();

        inputFieldsSimpleFormPage.setSimpleFormInputMessage("Hello-message!");
        inputFieldsSimpleFormPage.clickSimpleFormShowMessageBUTTON();

        String x = inputFieldsSimpleFormPage.checkFormMessage();
        Assert.assertEquals(x, "Hello-message!");
        testPass("Assert message was received: " + x);   }

}


