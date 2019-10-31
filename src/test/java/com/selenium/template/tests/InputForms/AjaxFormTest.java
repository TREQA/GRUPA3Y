package com.selenium.template.tests.InputForms;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.InputForms.AjaxFormPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AjaxFormTest extends ExtentTestListener {


    @Test(groups = "Test", description = "AjaxForm > Form")
    public void Test_01_Input_Forms_AjaxForm1() throws Exception {

        WebDriver driver = getDriver();
        AjaxFormPage AjaxFormPage = new AjaxFormPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_AJAXFORMSUBMIT);
        driver.manage().window().maximize();


        boolean check1 = AjaxFormPage.submitEmpty();

        AjaxFormPage.fillTitle("Hello everybody");
        AjaxFormPage.fillComment("This is a description of some sort");
        AjaxFormPage.clickSubmit();
        boolean check2 = AjaxFormPage.successCheck("Successfully!");
        Assert.assertTrue(check1 && check2);
        testPass("Assert message was received: " + (check1 && check2));
    }
}