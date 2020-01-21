package com.selenium.template.page_objects.SeleniumEasy.DatePickers;

import com.selenium.template.page_objects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Toolkit;
import java.awt.datatransfer.*;

import java.io.IOException;
import java.lang.*;


import java.time.Month;

public class DatePicker_Bootstrap_Page<rearrange> extends PageBase {

    public DatePicker_Bootstrap_Page(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------ Date Picker One Elements

    @FindBy(xpath = "//DIV[@class='panel-heading'][text()='Date Example :']/..//INPUT[@type='text']")
    private WebElement dateFieldOne;

    @FindBy(css = "div.datepicker-days > table.table-condensed > thead > tr:nth-of-type(2) > th.datepicker-switch")
    private WebElement monthButton;

    @FindBy(css = "div.datepicker-months > table.table-condensed > thead > tr:nth-of-type(2) > th.prev")
    private WebElement prevButton;

    @FindBy(xpath = "//div[@class='datepicker-months']//th[@class='datepicker-switch']")
    private WebElement checkYear;

        private WebElement chooseMonth(String month) {
        return driver.findElement(By.xpath("//span[contains(text(),'" + month + "')]"));
    }

    private WebElement chooseDay(String day) {
        return driver.findElement(By.xpath("//td[contains(text(),'" + day + "')]"));
    }

    //------------------------------------------------Date Picker 2-Start Elements

    @FindBy(xpath = "//input[@placeholder='Start date']")
    private WebElement dateField2Start;

      //------------------------------------------------Date Picker 2-End Elements

    @FindBy(xpath = "//DIV[@class='panel-heading'][text()='Date Example :']/..//INPUT[@type='text']")
    private WebElement dateField2End;

    private WebElement field[] = {dateFieldOne, dateField2Start, dateField2End};

    //------------------------------///////////////////////////////////////////-------------------------Date Picker Universal Methods

    public void dateChooser(String[] date, WebElement field) {
        field.click();
        monthButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 4);
        for (int i = 0; i < 100; i++) {
            if (!checkYear.getText().contains(date[2])) {
                wait.until(ExpectedConditions.elementToBeClickable(prevButton));
                prevButton.click();
            } else break;

        }
        chooseMonth(date[1]).click();
        chooseDay(date[0]).click();
    }

    public String getFieldDate(WebElement field) {
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        String copyToClipboard = Keys.chord(Keys.CONTROL, "c");
        field.sendKeys(selectAll);
        field.sendKeys(copyToClipboard);
        String result = "";
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        // odd: the Object param of getContents is not currently used
        Transferable contents = clipboard.getContents(null);
        boolean hasTransferableText = (contents != null)
                && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            try {
                result = (String) contents
                        .getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        return result;

    }

    public String convertInputDate(String[] date) {
        String[] sMonths = new String[12];
        int intMonth = 0;
        for (int i = 0; i < sMonths.length; i++) {
            sMonths[i] = Month.values()[i].name().toLowerCase();
        }
        for (int i = 0; i < sMonths.length; i++) {
            try {
                if (sMonths[i].contains(date[1].toLowerCase())) {
                    intMonth = i + 1;
                }
            } catch (Exception e) {
                System.out.println("Month wasn't encountered!");
            }
        }
        String rearrange;
        if (intMonth < 10) {
            rearrange = date[0] + "/0" + intMonth + "/" + date[2];
        } else rearrange = date[0] + "/" + intMonth + "/" + date[2];
        return rearrange;
    }

    public boolean compareDates(String fieldDate, String convertedInputDate) {
        return fieldDate.contains(convertedInputDate);
    }

    public WebElement chooseField(int i){
        return field[i-1];

    }


}