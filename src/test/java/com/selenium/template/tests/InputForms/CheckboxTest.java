package com.selenium.template.tests.InputForms;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.InputForms.CheckboxPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckboxTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Input Forms > First Checkbox")
    public void Test_01_Input_Forms_Checkbox_Demo() throws Exception {

        WebDriver driver = getDriver();
        CheckboxPage CheckboxPage = new CheckboxPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_CHECKBOX);
        driver.manage().window().maximize();

        CheckboxPage.clickFirstCheckbox();
        boolean message = CheckboxPage.checkFirstCheckboxMessage("Success");
                Assert.assertTrue(message);
        testPass("Assert message was received: " + message); }


    @Test(groups = "Test", description = "Input Forms > Check All")
    public void Test_02_Input_Forms_Checkbox_Demo() throws Exception {

        WebDriver driver = getDriver();;
        CheckboxPage CheckboxPage = new CheckboxPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_CHECKBOX);
        driver.manage().window().maximize();

        CheckboxPage.clickCheckAllButton();
        boolean message1 = CheckboxPage.checkButtonName("Uncheck");
        CheckboxPage.uncheckOption1();
        boolean message2 = !CheckboxPage.checkButtonName("Uncheck");
        Assert.assertEquals(message1, message2);
        testPass("Assert message was received: " + message1+" & "+ message2); }}