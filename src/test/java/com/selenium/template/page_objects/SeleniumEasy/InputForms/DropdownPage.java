package com.selenium.template.page_objects.SeleniumEasy.InputForms;

import com.selenium.template.page_objects.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DropdownPage extends PageBase {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    // ------------------------------------------------------- Select List Elements

    @FindBy(className = "form-control")
    private WebElement DropDown;

    private WebElement selectDropDay(String value) {
        return driver.findElement(By.xpath("//button[@type='button'][@value='" + value + "']"));
    }

    @FindBy(className = "selected-value")
    private WebElement checkDay;
    // -------------------------------------------------------- Multi Select Elements


    @FindBy(className = "getall-selected")
    private WebElement stateSelectionCheck;

    @FindBy(xpath = "//button[@type='button'][@value='Print First']")
    private WebElement buttonFirst;

    @FindBy(xpath = "//button[@type='button'][@value='Print All']")
    private WebElement buttonAll;

//-----------------------------------------------------------------Single Select Methods

    public void clickDropDown() {
        DropDown.click();
    }

    public void selectWeekDay(String day) {
        selectDropDay(day).click();
    }


    Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).build().perform();