package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SeleniumEasySecondDropdown extends PageBase {
    public SeleniumEasySecondDropdown (WebDriver driver) {super(driver);}

    @FindBy (id = "multi-select")
    WebElement multiSelectDropdown;

    @FindBy (id = "printAll")
    WebElement getAllSelectedButton;

    @FindBy (id = "printMe")
    WebElement getFirstSelected;

    @FindBy (css = "div.text-left > div:nth-of-type(2) > div.panel-body > p:nth-of-type(2)")
    WebElement selectedResult;

    public void scrollDropdownPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
    }

    public void setMultiSelectDropdown(){
//        Select multiDropdown = new Select(multiSelectDropdown);

        Select select = new Select(multiSelectDropdown);
        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(select.getOptions().get(3)).click(select.getOptions().get(4)).keyUp(Keys.CONTROL);
        builder.build().perform();



        //        WebElement newYork = driver.findElement(By.cssSelector("#multi-select > option:nth-child(4)"));
//        WebElement ohio = driver.findElement(By.cssSelector("#multi-select > option:nth-child(5)"));
//        Actions action = new Actions(driver);
//        action.keyDown(Keys.CONTROL).click(newYork).click(ohio).build().perform();
////        multiDropdown.selectByVisibleText("New York");
////        multiDropdown.selectByVisibleText("Ohio");
    }
    public void clickGetAllSelectedButton(){
        SeleniumWrapper.clickElement(driver,getAllSelectedButton, "Get All Selected button");
    }
    public String textSelectedResult(){
        return selectedResult.getText();
    }
}
