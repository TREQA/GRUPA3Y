package com.selenium.template.page_objects.SeleniumEasy.InputForms;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class AjaxFormPage extends PageBase {

    public AjaxFormPage(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------- Ajax Elements
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleBox;

    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement commentBox;

    @FindBy(xpath = "//input[@id='btn-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='submit-control']")
    private WebElement checkMessage;

    //--------------------------------------------------- AjaxM ethods 1

    public boolean submitEmpty()
    { submitButton.click();
        long now = new Date().getTime();
        while(new Date().getTime() - now < 1000){}
        return submitButton.isDisplayed();}

    //------------------------------------------------------Ajax Methods 2

    public void fillTitle(String title) {
        titleBox.sendKeys(title);
    }

    public void fillComment(String comment) {
        commentBox.sendKeys(comment);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean successCheck(String success) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(checkMessage));
        long now = new Date().getTime();
        while(new Date().getTime() - now < 1000){}
        return checkMessage.getText().contains(success);
    }
}