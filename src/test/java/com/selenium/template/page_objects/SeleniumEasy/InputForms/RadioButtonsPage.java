package com.selenium.template.page_objects.SeleniumEasy.InputForms;
import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonsPage extends PageBase {

    public RadioButtonsPage (WebDriver driver){
        super(driver);
    }

//----------------------------------------------------- Elements Test 1
    @FindBy(id = "buttoncheck")
    private WebElement GetCheckedValuesButton;

    private WebElement firstRadioOption(String value) {
        return driver.findElement(By.xpath("//input[@name='optradio'][@value='" + value + "']"));
    }

    @FindBy(className = "radiobutton")
    private WebElement checkFirstMessage;

    //------------------------------------------------------ Test 1 Methods
    public void checkFirstBox(String string) {
        firstRadioOption(string).click();
    }
    public void clickGetCheckedValuesButton(){
        GetCheckedValuesButton.click();
    }
    public boolean checkFirstMessage(String string) {
        return checkFirstMessage.getText().contains(string);
    }

    //----------------------------------------------------- Elements Test 2
    private WebElement GenderOption(String value) {
        return driver.findElement(By.xpath("//input[@name='gender'][@value='" + value + "']"));
    }

    private WebElement AgeGroupOption(String value) {
        return driver.findElement(By.xpath("//input[@name='ageGroup'][@value='" + value + "']"));
    }

    @FindBy(className = "button.btn.btn-default")
    private WebElement GetValuesButton;

    @FindBy(className = "groupradiobutton")
    private WebElement ValuesMessage;

    //---------------------------------------------------- Test 2 Methods

    public void checkGenderBox(String string) {
        GenderOption(string).click();
    }
    public void checkAgeBox(String string) {
        AgeGroupOption(string).click();
    }
    public void clickGetValuesButton(){
        GetValuesButton.click();
    }
    public boolean checkSecondMessage(String string) {
        return ValuesMessage.getText().contains(string);
    }}

