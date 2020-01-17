package com.selenium.template.tests.DatePicker;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.DatePickers.DatePicker_Bootstrap_Page;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePicker_Bootstrap_Test extends ExtentTestListener {


    @Test(groups = "Test", description = "Date Pickers Bootstrap > Date Picker 1")
    public void Test_01_DatePickers_Bootstrap_DatePickerOne() throws Exception {
        WebDriver driver = getDriver();
        DatePicker_Bootstrap_Page DatePicker_Bootstrap_Page = new DatePicker_Bootstrap_Page(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_DATE_DATE_BOOTS);
        driver.manage().window().maximize();

        String[] date = {"17", "Nov", "1997"};
        DatePicker_Bootstrap_Page.dateChooserOne(date);
        String fieldDate = DatePicker_Bootstrap_Page.getFieldDate();
        String convertedInputDate = DatePicker_Bootstrap_Page.convertInputDate(date);
        boolean check1 = DatePicker_Bootstrap_Page.compareDates(fieldDate, convertedInputDate);
        Assert.assertTrue(check1);
        testPass("Assert message was received: " + (check1));
    }
}