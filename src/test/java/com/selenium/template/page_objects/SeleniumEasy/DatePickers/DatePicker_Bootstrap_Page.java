package com.selenium.template.page_objects.SeleniumEasy.DatePickers;

import com.selenium.template.page_objects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Month;

public class DatePicker_Bootstrap_Page<rearrange> extends PageBase {

    public DatePicker_Bootstrap_Page(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------ Date Picker One Elements

    @FindBy(xpath = "//input[@placeholder='dd/mm/yyyy']")
    private WebElement dateFieldOne;

    @FindBy(css = "div.datepicker-days > table.table-condensed > thead > tr:nth-of-type(2) > th.datepicker-switch")
    private WebElement monthButtonOne;

    @FindBy(css = "div.datepicker-months > table.table-condensed > thead > tr:nth-of-type(2) > th.prev")
    private WebElement prevButtonOne;

    @FindBy(xpath = "//div[@class='datepicker-months']//th[@class='datepicker-switch']")
    private WebElement checkYearOne;

    private WebElement chooseMonthOne(String month) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + month + "')]"));
    }

    private WebElement chooseDayOne(String day) {
        return driver.findElement(By.xpath("//td[contains(text(),'" + day + "')]"));
    }

    //------------------------------------------------Date Picker 2 Elements

    //------------------------------///////////////////////////////////////////-------------------------Date Picker One Methods

    public void dateChooserOne(String[] date) {
        dateFieldOne.click();
        monthButtonOne.click();
        WebDriverWait wait = new WebDriverWait(driver, 4);
        for (int i = 0; i < 100; i++) {
            if (!checkYearOne.getText().contains(date[2])) {
                wait.until(ExpectedConditions.elementToBeClickable(prevButtonOne));
                prevButtonOne.click();
            } else break;

        }
        chooseMonthOne(date[1]).click();
        chooseDayOne(date[0]).click();
    }

    public String getFieldDate() {
        return dateFieldOne.getText();
    }

    public String convertInputDate(String[] date) {
        Month[] months = Month.values();
        String rearrange = date[0] + "/" + date[1] + "/" + date[2];
        String finalDate = rearrange.replaceAll("(\\d\\d\\/)(\\d\\d)(\\/\\d\\d)", "$2");
        int monthSortedOut = Integer.parseInt(finalDate) - 1;
        if (monthSortedOut < 10) {
            rearrange = rearrange.replaceAll("(\\d\\d\\/\\d)(\\d)(\\/\\d\\d)", "$1" + monthSortedOut + "$3");
        } else rearrange = rearrange.replaceAll("(\\d\\d\\/)(\\d\\d)(\\/\\d\\d)", "$1" + monthSortedOut + "$3");
        return rearrange;
    }

    public boolean compareDates(String a, String b) {
        return a == b;
    }
}