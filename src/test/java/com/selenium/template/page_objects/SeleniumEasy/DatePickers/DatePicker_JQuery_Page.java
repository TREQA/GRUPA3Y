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

public class DatePicker_JQuery_Page extends PageBase {

    public DatePicker_JQuery_Page(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------ Date Picker One Elements

    @FindBy(xpath = "//input[@id='to']")
    private WebElement dateFieldTo;

    @FindBy(xpath = "//input[@id='from']")
    private WebElement dateFieldFrom;

    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
    private WebElement prevButton;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    private WebElement yearChooser;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    private WebElement monthChooser;

    private WebElement monthChecker(String month) {
        return driver.findElement(By.xpath("//option[contains(text(),'"+month+"')]"));}

    private WebElement dayChooser(int i) {
        return driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]"));
    }

    @FindBy(xpath = "//div[@class='container-fluid text-center']//div[@class='row']")
    private WebElement close;

    private WebElement field[] = {dateFieldFrom, dateFieldTo};

    //==================================================================================== Methods


    public void dateChooser(String[] date, WebElement field) {
        field.click();
        WebDriverWait wait = new WebDriverWait(driver, 4);
        for (int i = 0; i < 100; i++) {
            if (!yearChooser.getText().contains(date[2])) {
                wait.until(ExpectedConditions.elementToBeClickable(prevButton));
                prevButton.click();
            } else break;

        }
        monthChooser.click();
        monthChecker(date[1]).click();
        int intDate = Integer.parseInt(date[0]);
        dayChooser(intDate).click();
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
            rearrange = "0" + intMonth + "/" + date[0] + "/" + date[2];
        } else rearrange = intMonth + "/" + date[0] + "/" + date[2];
        return rearrange;
    }

    public boolean compareDates(String fieldDate, String convertedInputDate) {
        return fieldDate.contains(convertedInputDate);
    }

    public WebElement chooseField(int i) {
        i--;
        return field[i];

    }

    public void closePicker() {
        close.click();
    }

    public void sendKeys(String input, WebElement field){
        field.sendKeys(input);
    }
}




