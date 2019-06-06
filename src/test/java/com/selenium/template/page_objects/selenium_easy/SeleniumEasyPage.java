package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SeleniumEasyPage extends PageBase {
    public SeleniumEasyPage(WebDriver driver){
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"user-message\"]" )
    private WebElement enterMessage;

    @FindBy (xpath = "//*[@id=\"get-input\"]/button")
    private WebElement showMessage;

    @FindBy (xpath = "//*[@id=\"display\"]")
    private WebElement yourMessage;

    public void setEnterMessage(String messageToBeEntered){
        SeleniumWrapper.sendKeys(enterMessage, messageToBeEntered, "enter message");
    }
    public void clickShowMessage(){
        SeleniumWrapper.clickElement(driver, showMessage, "show message");
    }
    public void getYourMessage(String messageToBeEntered) {
        String messageWrote = yourMessage.getText(); // Your message: $mesajul

        Assert.assertEquals(messageWrote, messageToBeEntered);
    }



}
