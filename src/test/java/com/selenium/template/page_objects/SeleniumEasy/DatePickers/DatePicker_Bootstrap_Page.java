package com.selenium.template.page_objects.SeleniumEasy.DatePickers;
import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePicker_Bootstrap_Page extends PageBase {

    public DatePicker_Bootstrap_Page(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------------------------------ Date Picker One Elements

    @FindBy(xpath="//div[@class='input-group date']//span[@class='input-group-addon']")
    private WebElement datePickerbuttonOne;

    @FindBy(css="div.datepicker-days > table.table-condensed > thead > tr:nth-of-type(2) > th.datepicker-switch")
    private WebElement monthButtonOne;

    @FindBy(xpath="//div[@class='datepicker-months']//th[@class='prev'][contains(text(),'«')]")
    private WebElement prevButtonOne;

    private WebElement checkYearOne(String year) {
        return driver.findElement(By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch'][contains(text(),'"+year+"')]"));
    }

    private WebElement chooseMonthOne(String month) {
        return driver.findElement(By.xpath("//span[contains(text(),'"+month+"')]"));
    }

    private WebElement chooseDayOne(String day) {
        return driver.findElement(By.xpath("//td[contains(text(),'"+day+"')]"));
    }

    @FindBy   //input[@placeholder='dd/mm/yyyy']

//------------------------------------------------------------------------------------------Date Picker 2 Elements







}