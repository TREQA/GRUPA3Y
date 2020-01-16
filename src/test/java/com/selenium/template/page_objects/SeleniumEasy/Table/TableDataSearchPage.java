package com.selenium.template.page_objects.SeleniumEasy.Table;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableDataSearchPage extends PageBase {

    public TableDataSearchPage(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------  Table 1 Elements

    @FindBy(xpath = "//input[@id='task-table-filter']")
    private WebElement filterOne;

    @FindBy(xpath = "//div[@class='panel panel-primary']")
    private WebElement tableOne;

    @FindBy(xpath="//th[contains(text(),'#')]")
    private WebElement hashtag;

    @FindBy(xpath="//th[contains(text(),'Task')]")
    private WebElement Task;

    @FindBy(xpath="//th[contains(text(),'Assignee')]")
    private WebElement Assignee;

    @FindBy(xpath="//th[contains(text(),'Status')]")
    private WebElement Status;

    //------------------------------------------------------- Table 2 Elements

@FindBy(xpath = "//div[@class='panel panel-primary filterable']")
private WebElement tableTwo;

    private WebElement selectField(String fieldname) {
        return driver.findElement(By.xpath("//input[@placeholder='"+fieldname+"']"));
    }

    @FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-filter']")
    private WebElement filterButton;

    //---------------------------------------------------------- Table 1 Methods

  public void searchTableOne(String keyword){

      }
}