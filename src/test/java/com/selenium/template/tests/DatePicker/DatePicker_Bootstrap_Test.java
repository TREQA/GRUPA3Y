package com.selenium.template.tests.DatePicker;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.SeleniumEasy.DatePickers.DatePicker_Bootstrap_Page;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePicker_Bootstrap_Test extends ExtentTestListener {


    @Test(groups = "Test", description = "Date Pickers Bootstrap > Date Picker 1")
    public void Test_01_DatePickers_Bootstrap_DatePickerOne() throws Exception {
        WebDriver driver = getDriver();
        DatePicker_Bootstrap_Page DatePicker_Bootstrap_Page = new DatePicker_Bootstrap_Page(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_DATE_DATE_BOOTS);
        driver.manage().window().maximize();

        String[] date = {"17", "Dec", "2011"};
        WebElement field = DatePicker_Bootstrap_Page.chooseField(1);
        DatePicker_Bootstrap_Page.dateChooser(date, field);
        String fieldDate = DatePicker_Bootstrap_Page.getFieldDate(field);
        String convertedInputDate = DatePicker_Bootstrap_Page.convertInputDate(date);
        boolean check1 = DatePicker_Bootstrap_Page.compareDates(fieldDate, convertedInputDate);
        DatePicker_Bootstrap_Page.closePicker();
        Assert.assertTrue(check1);
        testPass("Assert message was received: " + (check1));
    }

    @Test(groups = "Test", description = "Date Pickers Bootstrap > Date Picker 2")
    public void Test_02_DatePickers_Bootstrap_DatePickerTwo() throws Exception {
        WebDriver driver = getDriver();
        DatePicker_Bootstrap_Page DatePicker_Bootstrap_Page = new DatePicker_Bootstrap_Page(driver);

        SeleniumWrapper.openIfLinkExists(driver, TestData.SELENIUM_DATE_DATE_BOOTS);
        driver.manage().window().maximize();

        String[] dateStart = {"17", "Dec", "2017"};
        String[] dateEnd = {"03", "Jul", "2018"};
        WebElement fieldStart = DatePicker_Bootstrap_Page.chooseField(2);
        WebElement fieldEnd = DatePicker_Bootstrap_Page.chooseField(3);
        DatePicker_Bootstrap_Page.dateChooser(dateStart, fieldStart);
        String fieldDate = DatePicker_Bootstrap_Page.getFieldDate(fieldStart);
        String convertedInputDate = DatePicker_Bootstrap_Page.convertInputDate(dateStart);
        boolean check1 = DatePicker_Bootstrap_Page.compareDates(fieldDate, convertedInputDate);
        DatePicker_Bootstrap_Page.closePicker();
        //-------------------------------------------------------------------------//
        DatePicker_Bootstrap_Page.dateChooser(dateEnd, fieldEnd);
        fieldDate = DatePicker_Bootstrap_Page.getFieldDate(fieldEnd);
        convertedInputDate = DatePicker_Bootstrap_Page.convertInputDate(dateEnd);
        boolean check2 = DatePicker_Bootstrap_Page.compareDates(fieldDate, convertedInputDate);
        DatePicker_Bootstrap_Page.closePicker();
        Assert.assertTrue(check1&&check2);
        testPass("Assert message was received: " + (check1 && check2));
    }
}