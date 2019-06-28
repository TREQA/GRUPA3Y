package com.selenium.template.page_objects.selenium_easy;


import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TwoInputsPage extends PageBase {
    public TwoInputsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "sum1")
    private WebElement firstSum;

    @FindBy(id = "sum2")
    private WebElement secondSum;

    @FindBy (xpath = "//*[@id=\"gettotal\"]/button")
    private WebElement clickToGetTotal;

    @FindBy (id = "displayvalue")
    private WebElement result;

    public void setFirstSum (String firstSumEntered){
        SeleniumWrapper.sendKeys(firstSum, firstSumEntered, "First Sum");
    }

    public void setSecondSum(String secondSumEntered){
        SeleniumWrapper.sendKeys(secondSum, secondSumEntered, "Second Sum");
    }

    public void setClickToGetTotal(){
        SeleniumWrapper.clickElement(driver, clickToGetTotal, "Get Total Button");
    }

    public void getResult(int finalResult, int firstNumber, int secondNumber){
        String textFinalResult = result.getText();
        finalResult = Integer.parseInt(textFinalResult);

        Assert.assertEquals(finalResult, firstNumber + secondNumber);
    }
}
