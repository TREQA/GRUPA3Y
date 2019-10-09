package com.selenium.template.page_objects.SeleniumEasy.InputForms;
import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends PageBase {

    public CheckboxPage (WebDriver driver){
        super(driver);
    }

    @FindBy(id = "isAgeSelected")
    private WebElement FirstCheckBox;

    @FindBy(id = "txtAge")
    private WebElement FirstCheckboxMessage;
//--------------------------------------------------------------------------------------Test 2 FindBys
    @FindBy(id = "check1")
    private WebElement CheckButton;

    @FindBy(className = "cb1-element")
    private WebElement Option1Checkbox;

//------------------------------------------------------------------------------------Test 1
    public void clickFirstCheckbox() {
        SeleniumWrapper.clickElement(driver, FirstCheckBox, "Click First Checkbox");
    }
    public boolean checkFirstCheckboxMessage(String string) {
        return FirstCheckboxMessage.getText().contains(string);
            }

    //-----------------------------------------------------------------------------------------Test 2
    public void clickCheckAllButton() {
        SeleniumWrapper.clickElement(driver, CheckButton, "Click Check All Button");
    }
    public void uncheckOption1() {
        SeleniumWrapper.clickElement(driver, Option1Checkbox, "Uncheck Option 1");
    }
    public boolean checkButtonName (String string){
        return CheckButton.getAttribute("value").contains(string);
            }
}