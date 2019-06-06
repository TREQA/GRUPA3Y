package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumEasyDoubleCalendar extends PageBase {
    public SeleniumEasyDoubleCalendar (WebDriver driver){super(driver);}

    @FindBy (xpath = "//*[@id=\"datepicker\"]/input[1]")
    WebElement startDateCalendar;

    @FindBy (xpath = "/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")
    WebElement monthsStartDateCalendar;

    @FindBy(xpath = "/html/body/div[3]/div[2]/table/thead/tr[2]/th[2]")
    WebElement yearsStartDateCalendar;

    @FindBy (xpath = "//*[@id=\"datepicker\"]/input[2]")
    WebElement endDateCalendar;

    @FindBy (xpath = "/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")
    WebElement monthsEndDateCalendar;

    @FindBy(xpath = "/html/body/div[3]/div[2]/table/thead/tr[2]/th[2]")
    WebElement yearsEndDateCalendar;

    public void scrollCalendarPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
    }


    public void clickStartDateCalendar(){
        SeleniumWrapper.clickElement(driver, startDateCalendar, "Start Date Calendar");
    }

    public void clickMonthsStartDateCalendar(){
        SeleniumWrapper.clickElement(driver, monthsStartDateCalendar, "Months on the Start Date Calendar");
    }

    public void clickYearsStartDateCalendar(){
        SeleniumWrapper.clickElement(driver, yearsStartDateCalendar, "Years on the Start Date Calendar");
    }

    public void setStartDateYear(String chosenYear){
        WebElement year = driver.findElement(By.xpath("//SPAN[@class='year'][text()='"+chosenYear+"']"));
        year.click();
    }

    public void setStartDateMonth(String chosenMonth){
        WebElement month = driver.findElement(By.xpath("//SPAN[@class='month'][text()='"+chosenMonth+"']"));
        month.click();
    }

    public void setStartDateDay(String chosenDay){
        WebElement day = driver.findElement(By.xpath("//TD[@class='day'][text()='"+chosenDay+"']"));
        day.click();
    }

    public void clickEndDateCalendar(){
        SeleniumWrapper.clickElement(driver, endDateCalendar, "End Date Calendar");
    }

    public void clickMonthsEndDateCalendar(){
        SeleniumWrapper.clickElement(driver, monthsEndDateCalendar, "Months on the End Date Calendar");
    }

    public void clickYearsEndDateCalendar(){
        SeleniumWrapper.clickElement(driver, yearsEndDateCalendar, "Years on the End Date Calendar");
    }

    public void setEndDateYear(String enteredYear){
        WebElement year = driver.findElement(By.xpath("//SPAN[@class='year'][text()='"+enteredYear+"']"));
        year.click();
    }

    public void setEndDateMonth(String enteredMonth){
        WebElement month = driver.findElement(By.xpath("//SPAN[@class='month'][text()='"+enteredMonth+"']"));
        month.click();
    }

    public void setEndDateDay(String enteredDay){
        WebElement day = driver.findElement(By.xpath("//TD[@class='day'][text()='"+enteredDay+"']"));
        day.click();
    }

    public String startDateResult(){
        return startDateCalendar.getAttribute("value");
    }

    public String endDateRessult(){
        return endDateCalendar.getAttribute("value");
    }


}
