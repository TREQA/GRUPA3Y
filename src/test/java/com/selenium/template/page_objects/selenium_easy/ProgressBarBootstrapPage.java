package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBarBootstrapPage extends PageBase {
    public ProgressBarBootstrapPage(WebDriver driver){super (driver);}

    @FindBy (className = "percenttext")
    WebElement circlePercentage;

    @FindBy (id = "cricle-btn")
    WebElement circleButton;


    public void clickCircleButton(){
        SeleniumWrapper.clickElement(driver, circleButton, "Circle Button");
    }

    public String getCirclePercentage(){
        return SeleniumWrapper.getText(circlePercentage, "Circle Percentage");
    }

    public boolean isFileDownloadComplete(){
        boolean isFinished = true;

        while (isFinished){
            isFinished = !circlePercentage.getText().equals("100%");
        }


        return !isFinished;
    }
}
