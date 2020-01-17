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

    @FindBy(xpath="//input[@placeholder='dd/mm/yyyy']")
    private WebElement dateFieldOne;

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

    //------------------------------------------------Date Picker 2 Elements

    //------------------------------///////////////////////////////////////////-------------------------Date Picker One Methods

        public void dateChooserOne(String[] date){
        dateFieldOne.click();
        monthButtonOne.click();
        for (int i = 0; i == 100; i++){
            if (!checkYearOne(date[2]).isDisplayed()){
                prevButtonOne.click();
            }
            else break;

        }
        chooseMonthOne(date[1]).click();
        chooseDayOne(date[0]).click();
    }

        public boolean checkDateOne(String[] date){
        String dateV=date[0]+"/"+date[1]+"/"+date[2];
        return dateFieldOne.getText().contains(dateV);
        }

}