package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyDoubleCalendar;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasySingleCalendar;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.selenium.template.utils.TestData.SELENIUM_EASY_CALENDAR_URL;

public class SeleniumEasyCalendarTest extends ExtentTestListener {
    @Test(groups = "calendar", description = "A test that verifies the calendar")
    public void Test_01_Verify_Calendar() throws Exception{
        WebDriver driver = getDriver();
        SeleniumEasySingleCalendar seleniumEasySingleCalendar = new SeleniumEasySingleCalendar(driver);

        SeleniumWrapper.openIfLinkExists(driver, SELENIUM_EASY_CALENDAR_URL);
        driver.manage().window().maximize();

        seleniumEasySingleCalendar.clickSelectDateField();
        seleniumEasySingleCalendar.clickCalendarMonthsField();
        seleniumEasySingleCalendar.clickTensYears();
        seleniumEasySingleCalendar.selectTheChosenYear("2013");
        seleniumEasySingleCalendar.setCalendarMonthsField("Jan");
        seleniumEasySingleCalendar.clickCalendarField("15");
        Assert.assertEquals(seleniumEasySingleCalendar.setDateResult(), "15/01/2013");
    }
    @Test(groups = "calendar", description = "A test that verifies divided calendar")
    public void Test_02_Verify_Calendar() throws Exception{
        WebDriver driver = getDriver();
        SeleniumEasyDoubleCalendar seleniumEasyDoubleCalendar = new SeleniumEasyDoubleCalendar(driver);

        SeleniumWrapper.openIfLinkExists(driver, SELENIUM_EASY_CALENDAR_URL);
        driver.manage().window().maximize();

        seleniumEasyDoubleCalendar.scrollCalendarPage();
        seleniumEasyDoubleCalendar.clickStartDateCalendar();
        seleniumEasyDoubleCalendar.clickMonthsStartDateCalendar();
        seleniumEasyDoubleCalendar.clickYearsStartDateCalendar();
        seleniumEasyDoubleCalendar.setStartDateYear("2018");
        seleniumEasyDoubleCalendar.setStartDateMonth("Jan");
        seleniumEasyDoubleCalendar.setStartDateDay("1");
        seleniumEasyDoubleCalendar.clickEndDateCalendar();
        seleniumEasyDoubleCalendar.clickMonthsEndDateCalendar();
        seleniumEasyDoubleCalendar.clickYearsEndDateCalendar();
        seleniumEasyDoubleCalendar.setEndDateYear("2019");
        seleniumEasyDoubleCalendar.setEndDateMonth("Feb");
        seleniumEasyDoubleCalendar.setEndDateDay("1");

        Assert.assertEquals(seleniumEasyDoubleCalendar.startDateResult(), "01/01/2018");
        Assert.assertEquals(seleniumEasyDoubleCalendar.endDateRessult(), "01/02/2019");


    }

}
