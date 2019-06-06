package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyFirstDropdown;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasySecondDropdown;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDropdownTest extends ExtentTestListener {
    @Test(groups = "dropdown", description = "Test to verify the dropdowns")
    public void Test_01_Verify_Dropdown() throws Exception {

        WebDriver driver = getDriver();
        SeleniumEasyFirstDropdown seleniumEasyFirstDropdown = new SeleniumEasyFirstDropdown(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_DROPDOWN_URL);
        driver.manage().window().maximize();
        seleniumEasyFirstDropdown.selectDropdown();

        Assert.assertEquals(seleniumEasyFirstDropdown.checkDropdownElement(), "Day selected :- Monday");
    }
    @Test(groups = "dropdown", description = "Test to verify the dropdowns")
    public void Test_02_Verify_Dropdown() throws Exception {

        WebDriver driver = getDriver();
        SeleniumEasySecondDropdown seleniumEasySecondDropdown = new SeleniumEasySecondDropdown(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_DROPDOWN_URL);
        driver.manage().window().maximize();

        seleniumEasySecondDropdown.scrollDropdownPage();
        seleniumEasySecondDropdown.setMultiSelectDropdown();
        seleniumEasySecondDropdown.clickGetAllSelectedButton();

        seleniumEasySecondDropdown.textSelectedResult();

        Assert.assertEquals(seleniumEasySecondDropdown.textSelectedResult(), "Options selected are : New York,Ohio");
    }
}