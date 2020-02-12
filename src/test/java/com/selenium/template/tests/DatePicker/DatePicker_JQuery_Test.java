package com.selenium.template.tests.DatePicker;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.DatePickers.DatePicker_JQuery_Page;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePicker_JQuery_Test extends ExtentTestListener {
@Test(groups = "Test", description = "Date Pickers > Jquery")
    public void Test_01_JQueryDatePickers() throws Exception {

        WebDriver driver = getDriver();
        DatePicker_JQuery_Page DatePicker_JQuery_Page = new DatePicker_JQuery_Page(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_DATE_DATE_JQUERY);
        driver.manage().window().maximize();
}
