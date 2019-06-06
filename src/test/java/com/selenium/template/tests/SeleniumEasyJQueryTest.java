package com.selenium.template.tests;

import com.selenium.template.extent_report.ExtentTestListener;
import com.selenium.template.page_objects.selenium_easy.SeleniumEasyJQueryCalendar;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.selenium.template.utils.TestData.SELENIUM_EASY_JQUERY_CALENDAR_URL;

public class SeleniumEasyJQueryTest extends ExtentTestListener {
    @Test(groups = "calendar", description = "A test for the JQuery calendar")
    public void Test_01_Verify_JQuery_Calendar() throws Exception {
        WebDriver driver = getDriver();
        SeleniumEasyJQueryCalendar seleniumEasyJQueryCalendar = new SeleniumEasyJQueryCalendar(driver);

        SeleniumWrapper.openIfLinkExists(driver, SELENIUM_EASY_JQUERY_CALENDAR_URL);
        driver.manage().window().maximize();

        seleniumEasyJQueryCalendar.clickFromDateCalendar();
        seleniumEasyJQueryCalendar.fromDateMonthSelect("May");
        seleniumEasyJQueryCalendar.setFromDateDaysTabel("27");
////A[@class='ui-state-default ui-state-hover'][text()='5']
    }
}
