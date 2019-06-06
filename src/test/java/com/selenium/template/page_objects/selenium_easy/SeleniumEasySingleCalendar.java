package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumEasySingleCalendar extends PageBase {
    public SeleniumEasySingleCalendar (WebDriver driver) {super(driver);}

    @FindBy(className = "day")
    private List<WebElement> dayOfCurrentMonth;

    @FindBy (css = "#sandbox-container1 > div")
    WebElement selectDateField;

    @FindBy (xpath = "/html/body/div[3]/div[1]/table")
    WebElement calendarDaysField;

    @FindBy (xpath = "/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")
    WebElement calendarMonthsField;

    @FindBy (xpath = "/html/body/div[2]/div/div[2]/div[1]/div/div[1]")
    WebElement clickToCloseDateTable;

    @FindBy (xpath = "/html/body/div[3]/div[2]/table/thead/tr[2]/th[2]")
    WebElement tensYears;

    @FindBy (xpath = "/html/body/div[3]/div[3]/table/thead/tr[2]/th[2]")
    WebElement hundredsYears;

    @FindBy (xpath = "/html/body/div[3]/div[4]/table/thead/tr[2]/th[2]")
    WebElement thousandsYears;

    @FindBy (css = "#sandbox-container1 > div > input")
    WebElement dateResult;

    public void clickSelectDateField(){
        SeleniumWrapper.clickElement(driver, selectDateField, "Select Date Field");
    }

    public void clickCalendarField(String enteredDate){
        WebElement dateToBeChosen = driver.findElement(By.xpath("//TD[@class='day'][text()='"+enteredDate+"']"));
        dateToBeChosen.click();
    }

    public void clickCalendarMonthsField(){
        SeleniumWrapper.clickElement(driver,calendarMonthsField,"calendar months field");
    }

    public void setCalendarMonthsField (String enteredMonth) {
       WebElement monthToBeChosen = driver.findElement(By.xpath("//SPAN[@class='month'][text()='"+enteredMonth+"']"));
       monthToBeChosen.click();
    }
    public void setClickToCloseDateTable(){
        SeleniumWrapper.clickElement(driver, clickToCloseDateTable, "Click to close the date table");
    }

    public void clickTensYears(){
        SeleniumWrapper.clickElement(driver, tensYears, "Years from 10 to 10");
    }

    public void selectTheChosenYear(String enteredYear){
        WebElement yearToBeChosen = driver.findElement(By.xpath("//SPAN[@class='year'][text()='"+enteredYear+"']"));
        yearToBeChosen.click();
    }

    public String setDateResult(){
        String whatever = dateResult.getAttribute("value");
        return whatever;
    }

}
