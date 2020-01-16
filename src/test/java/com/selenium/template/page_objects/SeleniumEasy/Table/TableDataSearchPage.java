package com.selenium.template.page_objects.SeleniumEasy.Table;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableDataSearchPage extends PageBase {

    public TableDataSearchPage(WebDriver driver) {
        super(driver);
    }

    //------------------------------------------------------  Table 1 Elements

    @FindBy(xpath = "//input[@id='task-table-filter']")
    private WebElement filterOne;

     @FindBy(css="#task-table > tbody > tr:nth-of-type(1) > td:nth-of-type(1)")
    private WebElement hashtag;

    @FindBy(css="#task-table > tbody > tr:nth-of-type(1) > td:nth-of-type(2)")
    private WebElement task;

    @FindBy(css="#task-table > tbody > tr:nth-of-type(1) > td:nth-of-type(3)")
    private WebElement assignee;

    @FindBy(css="#task-table > tbody > tr:nth-of-type(1) > td:nth-of-type(4)")
    private WebElement status;

    @FindBy(xpath="//td[contains(text(),'No results found')]")
            private WebElement noResultsElem;

    WebElement[] table1Elems = {hashtag, task, assignee, status};
    //------------------------------------------------------- Table 2 Elements

@FindBy(xpath = "//div[@class='panel panel-primary filterable']")
private WebElement tableTwo;

    private WebElement selectField(String fieldname) {
        return driver.findElement(By.xpath("//input[@placeholder='"+fieldname+"']"));
    }

    @FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-filter']")
    private WebElement filterButton;

    //---------------------------------------------------------- Table 1 Methods (POSITIVE)

  public boolean searchTableOne(String[] keywords){
      boolean check1 = true;
      for (int i=0; i<keywords.length() ; i++){
             filterOne.click();
             filterOne.clear();
             filterOne.sendKeys(keywords[i]);
          if (!table1Elems[i].getText().equals(keywords[i])) {
              check1 = false;
          }
      }
}
//----------------------------------------------------------------- Table 1 Methods (NEGATIVE)

    public boolean noResults(String garbage){
      filterOne.sendKeys(garbage);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsElem);
        return driver.findElement(noResultsElem).isEnabled();
    }
//-----------------------------------------------------------Table 2 Methods

    public void clickFilter(){
      filterButton.click();
    }

    public boolean filterTable(String[] keywords){

    }
}