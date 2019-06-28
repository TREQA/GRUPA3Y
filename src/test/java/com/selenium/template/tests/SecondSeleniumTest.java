package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.CheckboxMultiple;
import com.selenium.template.page_objects.selenium_easy.CheckboxSinglePage;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondSeleniumTest extends ExtentTestListener {

    @Test(groups = "Second Test", description = "The single checkbox ")
    public void Test_02_Verify_Single_Checkbox() throws Exception {

        WebDriver driver = getDriver();
        CheckboxSinglePage checkboxSinglePage = new CheckboxSinglePage(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_CHECKBOX_URL);
        driver.manage().window().maximize();

        checkboxSinglePage.setClickCheckbox();

        checkboxSinglePage.setMessageCheckboxClicked();
    }
    @Test(groups = "Second Test", description = "Verify multiple checkbox selection")
    public void Test_02_Verify_Multiple_Checkbox() throws Exception {

        WebDriver driver = getDriver();
        CheckboxMultiple checkboxMultiple = new CheckboxMultiple(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_EASY_CHECKBOX_URL);
        driver.manage().window().maximize();

        checkboxMultiple.clickCheckAllButton();
        checkboxMultiple.verifyCheckAllButtonIsTrue();

        Assert.assertEquals(checkboxMultiple.verifyUncheckAllButtonIsTrue(), "Uncheck All");

        checkboxMultiple.clickOptionTwoCheckbox();
        checkboxMultiple.verifyUncheckAllButtonIsTrue();

        Assert.assertEquals(checkboxMultiple.verifyCheckAllButtonIsTrue(), "Check All");
        testPass("The checkboxes are checked succesfully.");
    }

}
