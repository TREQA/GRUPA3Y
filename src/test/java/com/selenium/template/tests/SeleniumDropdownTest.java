package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.DropdownFirstPage;
import com.selenium.template.page_objects.selenium_easy.DropdownSecondPage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumDropdownTest extends ExtentTestListener {
    @Test(groups = "dropdown", description = "Test to verify the dropdowns")
    public void Test_01_Verify_Dropdown() throws Exception {

        WebDriver driver = getDriver();
        DropdownFirstPage dropdownFirstPage = new DropdownFirstPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_DROPDOWN_URL);
        driver.manage().window().maximize();
        dropdownFirstPage.selectDropdown();

        Assert.assertEquals(dropdownFirstPage.checkDropdownElement(), "Day selected :- Monday");
    }
    @Test(groups = "dropdown", description = "Test to verify the dropdowns")
    public void Test_02_Verify_Dropdown() throws Exception {

        WebDriver driver = getDriver();
        DropdownSecondPage dropdownSecondPage = new DropdownSecondPage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_DROPDOWN_URL);
        driver.manage().window().maximize();

        dropdownSecondPage.scrollDropdownPage();
        dropdownSecondPage.setMultiSelectDropdown();
        dropdownSecondPage.clickGetAllSelectedButton();

        dropdownSecondPage.textSelectedResult();

        Assert.assertEquals(dropdownSecondPage.textSelectedResult(), "Options selected are : New York,Ohio");
    }
}