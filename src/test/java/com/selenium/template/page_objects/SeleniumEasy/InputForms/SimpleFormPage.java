package com.selenium.template.page_objects.SeleniumEasy.InputForms;
import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleFormPage extends PageBase {

    public SimpleFormPage(WebDriver driver){
        super(driver);
    }

    // ------------------------------------------------------- Single Input Field Elements

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//INPUT[@id='user-message']")
    private WebElement SimpleFormInputMessage;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//BUTTON[@type='button'][text()='Show Message']")
    private WebElement SimpleFormShowMessageBUTTON;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//SPAN[@id='display']")
    private WebElement SimpleFormCheckMessage;
    //----------------------------------------------------------------------------- Two Input Fields Elements
    @FindBy(id = "sum1")
    private WebElement SimpleFormEnterA;

    @FindBy(id = "sum2")
    private WebElement SimpleFormEnterB;

    @FindBy(xpath = "//DIV[@class='col-md-6 text-left']//BUTTON[@type='button'][text()='Get Total']")
    private WebElement SimpleFormGetTotalBUTTON;

    @FindBy(id = "displayvalue")
    private WebElement SimpleFormCheckTotal;

    // ------------------------------------------------------- Test 1 Methods

    public void setSimpleFormInputMessage(String message){
        SimpleFormInputMessage.sendKeys(message);
    }
    public void clickSimpleFormShowMessageBUTTON(){
        SeleniumWrapper.clickElement(driver, SimpleFormShowMessageBUTTON, "Click Show Message Button");
    }
    public String checkFormMessage() {
        return SimpleFormCheckMessage.getText();
    }

// ------------------------------------------------------------------------------ Test 2 Methods

    public void setEnterA(int inputNumber1){
        SimpleFormEnterA.sendKeys(Integer.toString(inputNumber1));
    }

    public void setEnterB(int inputNumber2){
        SimpleFormEnterB.sendKeys(Integer.toString(inputNumber2));
    }

    public void clickGetTotal()
      { SimpleFormGetTotalBUTTON.click(); }

    public int checkSumTotal(){
        return Integer.valueOf(SimpleFormCheckTotal.getText());
    }
}

