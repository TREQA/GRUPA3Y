package com.selenium.template.page_objects.SeleniumEasy;
import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputForms_SimpleFormPage extends PageBase {

    public InputForms_SimpleFormPage(WebDriver driver){
        super(driver);
    }

    // ------------------------------------------------------- Single Input Field

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//INPUT[@id='user-message']")
    private WebElement SimpleFormInputMessage;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//BUTTON[@type='button'][text()='Show Message']")
    private WebElement SimpleFormShowMessageBUTTON;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//SPAN[@id='display']")
    private WebElement SimpleFormCheckMessage;
    //----------------------------------------------------------------------------- Two Input Fields
    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//INPUT[@id='sum1']")
    private WebElement SimpleFormEnterA;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//INPUT[@id='sum2']")
    private WebElement SimpleFormEnterB;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//BUTTON[@type='button'][text()='Get Total']")
    private WebElement SimpleFormGetTotalBUTTON;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//SPAN[@id='displayvalue']")
    private WebElement SimpleFormCheckTotal;

    // ------------------------------------------------------- Methods

    // ---- setters

    public void setSimpleFormInputMessage(String textToBeSearched){
        SeleniumWrapper.sendKeys(SimpleFormInputMessage, textToBeSearched, "Simple Form Message");
    }
    public void clickSimpleFormShowMessageBUTTON(){
        SeleniumWrapper.clickElement(driver, SimpleFormShowMessageBUTTON, "Click Show Message Button");
    }
    public String checkFormMessage() {
        return SimpleFormCheckMessage.getText();
    }

}