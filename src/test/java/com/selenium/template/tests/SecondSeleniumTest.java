package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.SeleniumMultipleCheckbox;
import com.selenium.template.page_objects.selenium_easy.SeleniumSingleCheckbox;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondSeleniumTest extends ExtentTestListener {

    @Test(groups = "Second Test", description = "The single checkbox ")
    public void Test_02_Verify_Single_Checkbox() throws Exception {

        WebDriver driver = getDriver();
        SeleniumSingleCheckbox seleniumSingleCheckbox = new SeleniumSingleCheckbox(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_CHECKBOX_URL);
        driver.manage().window().maximize();

        seleniumSingleCheckbox.setClickCheckbox();

        seleniumSingleCheckbox.setMessageCheckboxClicked();
    }
    @Test(groups = "Second Test", description = "Verify multiple checkbox selection")
    public void Test_02_Verify_Multiple_Checkbox() throws Exception {

        WebDriver driver = getDriver();
        SeleniumMultipleCheckbox seleniumMultipleCheckbox = new SeleniumMultipleCheckbox (driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_CHECKBOX_URL);
        driver.manage().window().maximize();

        seleniumMultipleCheckbox.clickCheckAllButton();
        seleniumMultipleCheckbox.verifyCheckAllButtonIsTrue();

        Assert.assertEquals(seleniumMultipleCheckbox.verifyUncheckAllButtonIsTrue(), "Uncheck All");

        seleniumMultipleCheckbox.clickOptionTwoCheckbox();
        seleniumMultipleCheckbox.verifyUncheckAllButtonIsTrue();

        Assert.assertEquals(seleniumMultipleCheckbox.verifyCheckAllButtonIsTrue(), "Check All");
        testPass("The checkboxes are checked succesfully.");
    }

}
