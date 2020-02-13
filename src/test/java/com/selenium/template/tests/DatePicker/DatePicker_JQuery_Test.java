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

        String[] dateStart = {"04", "Jul", "2018"};
        String[] dateEnd = {"27", "Sep", "2019"};
        WebElement fieldStart = DatePicker_JQuery_Page.chooseField(1);
        WebElement fieldEnd = DatePicker_JQuery_Page.chooseField(2);
        DatePicker_JQuery_Page.dateChooser(dateStart, fieldStart);
        String fieldDate = DatePicker_JQuery_Page.getFieldDate(fieldStart);
        String convertedInputDate = DatePicker_JQuery_Page.convertInputDate(dateStart);
        boolean check1 = DatePicker_JQuery_Page.compareDates(fieldDate, convertedInputDate);
        DatePicker_JQuery_Page.closePicker();
        DatePicker_JQuery_Page.dateChooser(dateEnd, fieldEnd);
        fieldDate = DatePicker_JQuery_Page.getFieldDate(fieldEnd);
        convertedInputDate = DatePicker_JQuery_Page.convertInputDate(dateEnd);
        boolean check2 = DatePicker_JQuery_Page.compareDates(fieldDate, convertedInputDate);
        Assert.assertTrue(check1 && check2);
        testPass("Assert message was received: " + (check1 && check2));
    }

    @Test(groups = "Test", description = "Date Pickers > Jquery")
    public void Test_02_JQueryDatePickers_Limit() throws Exception {

        WebDriver driver = getDriver();
        DatePicker_JQuery_Page DatePicker_JQuery_Page = new DatePicker_JQuery_Page(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_DATE_DATE_JQUERY);
        driver.manage().window().maximize();

        String[] dateStart = {"15", "Aug", "2019"};
        String[] dateEnd = {"14", "Aug", "2019"};
        WebElement fieldStart = DatePicker_JQuery_Page.chooseField(1);
        WebElement fieldEnd = DatePicker_JQuery_Page.chooseField(2);
        DatePicker_JQuery_Page.dateChooser(dateStart, fieldStart);
        String fieldDate = DatePicker_JQuery_Page.getFieldDate(fieldStart);
        String convertedInputDate = DatePicker_JQuery_Page.convertInputDate(dateStart);
        boolean check1 = DatePicker_JQuery_Page.compareDates(fieldDate, convertedInputDate);
        convertedInputDate = DatePicker_JQuery_Page.convertInputDate(dateEnd);
        DatePicker_JQuery_Page.sendKeys(convertedInputDate, fieldEnd);
        fieldDate = DatePicker_JQuery_Page.getFieldDate(fieldStart);
        boolean check2 = DatePicker_JQuery_Page.compareDates(fieldDate, convertedInputDate);
        Assert.assertTrue(check1 && check2);
        testPass("Assert message was received: " + (check1 && check2));
    }
}
