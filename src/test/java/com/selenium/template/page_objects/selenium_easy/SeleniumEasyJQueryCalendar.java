package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumEasyJQueryCalendar extends PageBase {
    public SeleniumEasyJQueryCalendar(WebDriver driver){super(driver);}

    @FindBy (id = "from")
    WebElement fromDateCalendar;

    @FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/div/div/select")
    WebElement fromDateMonthsDropdown;

    @FindBy (xpath = "//*[@id=\"ui-datepicker-div\"]/table")
    WebElement fromDateDaysTabel;


    public void clickFromDateCalendar(){
        SeleniumWrapper.clickElement(driver, fromDateCalendar, "From Date Calendar");
    }

    public void fromDateMonthSelect(String desiredMonth){
        Select select = new Select(fromDateMonthsDropdown);
        select.selectByVisibleText(desiredMonth);
    }

    public void setFromDateDaysTabel (String desiredDay){//#ui-datepicker-div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a
        WebElement day = driver.findElement(By.xpath("//A[@class='ui-state-default ui-state-hover'][text()='5']"));
        day.click();

    }
}
