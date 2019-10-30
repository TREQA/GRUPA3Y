package com.selenium.template.tests.InputForms;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.InputForms.DropdownPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DropDownTest extends ExtentTestListener {


    @Test(groups = "Test", description = "Input Forms > First Dropdown")
    public void Test_01_Input_Forms_DropDown() throws Exception {

        WebDriver driver = getDriver();
        DropdownPage DropdownPage = new DropdownPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_DROPDOWNLIST);
        driver.manage().window().maximize();

        DropdownPage.clickDropDown();
        String weekday = "Wednesday";
        DropdownPage.selectWeekDay(weekday);
        boolean testcheck = DropdownPage.checkMessage1(weekday);
        Assert.assertTrue(testcheck);
        testPass("Assert message was received: " + (testcheck));}

    @Test(groups = "Test", description = "Input Forms > First Dropdown")
    public void Test_01_Input_Forms_DropDown2() throws Exception {

        WebDriver driver = getDriver();
        DropdownPage DropdownPage = new DropdownPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_INPUTFORMS_DROPDOWNLIST);
        driver.manage().window().maximize();

        String[] states = {"Texas", "New York", "Washington"};
        DropdownPage.stateSelector(states);}}