package com.selenium.template.page_objects.SeleniumEasy.InputForms;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Date;
import java.util.List;

public class DropdownPage extends PageBase {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    // ------------------------------------------------------- Select List Elements

    @FindBy(className = "form-control")
    private WebElement DropDown;

    private WebElement selectDropDay(String value) {
        return driver.findElement(By.xpath("//option[contains(text(),'" + value + "')]"));
    }

    @FindBy(className = "selected-value")
    private WebElement checkDay;
    // -------------------------------------------------------- Multi Select Elements

    private WebElement selectStates(String state) {
        return driver.findElement(By.xpath("//select[@name='States']/option[@value='" + state + "']"));
    }

    @FindBy(xpath = "//button[@id='printMe']")
    private WebElement buttonFirst;

    @FindBy (xpath="//select[@name='States']")
    private WebElement stateBox;

    @FindBy(xpath = "//button[@id='printAll']")
    private WebElement buttonAll;

    @FindBy(className = "getall-selected")
    private WebElement stateSelectionCheck;

//-----------------------------------------------------------------Single Select Methods

    public void clickDropDown() {
        DropDown.click();
    }

    public void selectWeekDay(String day) {
        selectDropDay(day).click();
    }

    public boolean checkMessage1(String message) {
        return checkDay.getText().contains(message);
    }

    // ---------------------------------------------------------------Multiple Select Methods

    public void stateSelector(String[] states) {
                    Actions act = new Actions(driver);
        for (String t: states) {
             act.keyDown(Keys.CONTROL).click(selectStates(t)).build().perform();
        }
    }

    public boolean buttonClickChecks(String[] states) {
        buttonFirst.click();
        boolean check1 = stateSelectionCheck.getText().contains(states[0]);
        buttonAll.click();
        boolean check2 = true;
        for (String t : states) {
            if (!stateSelectionCheck.getText().contains(t)) {
                check2 = false;
            }
        }
        return (check1 && check2);
    }
}



