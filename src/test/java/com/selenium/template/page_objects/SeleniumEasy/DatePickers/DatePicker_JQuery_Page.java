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

public class DatePicker_JQuery_Page<rearrange> extends PageBase {

    public DatePicker_JQuery_Page(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------ Date Picker One Elements

    @FindBy(xpath = "//input[@id='to']")
    private WebElement dateFieldTo;

    @FindBy(xpath = "//input[@id='from']")
    private WebElement dateFieldFrom;

    @FindBy (xpath="//span[@class='ui-icon ui-icon-circle-triangle-w']")
private WebElement prevButton;

    @FindBy (xpath="//span[@class='ui-datepicker-year']")
    private WebElement yearChooser;

    @FindBy(xpath="//select[@class='ui-datepicker-month']")
private WebElement monthChooser;

    private WebElement dayChooser (int i){
    return driver.findElement(By.xpath("//a[contains(text(),'"+i+"')]"));}


}