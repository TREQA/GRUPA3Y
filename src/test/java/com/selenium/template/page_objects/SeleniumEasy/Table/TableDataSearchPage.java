package com.selenium.template.page_objects.SeleniumEasy.Table;

import com.selenium.template.page_objects.PageBase;
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

    private WebElement selectFieldsTableOne(String keywords) {
        return driver.findElement(By.xpath("//H3[@class='panel-title'][text()='Tasks']/../..//TD[text()='" + keywords + "']"));
    }

    @FindBy(xpath = "//td[contains(text(),'No results found')]")
    private WebElement noResultsElem;

    //------------------------------------------------------- Table 2 Elements

    @FindBy(xpath = "//div[@class='panel panel-primary filterable']")
    private WebElement tableTwo;

    private WebElement selectInputFieldsTable2(int i) {
        i++;
        return driver.findElement(By.cssSelector("tr.filters > th:nth-of-type(" + i + ") > input.form-control"));
    }

    private WebElement selectOutputFieldsTable2(String keywords) {
        return driver.findElement(By.xpath("//H3[@class='panel-title'][text()='Listed Users']/../..//TD[text()='" + keywords + "']"));
    }

    @FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-filter']")
    private WebElement filterButton;

    @FindBy(xpath = "//td[contains(text(),'No result found')]")
    private WebElement noResultsElemTable2;

    //---------------------------------------------------------- Table 1 Methods (POSITIVE)

    public boolean searchTableOne(String[] keywords) {
        boolean check1 = true;
        for (int i = 0; i < keywords.length; i++) {
            filterOne.sendKeys(keywords[i]);
            if (!selectFieldsTableOne(keywords[i]).isDisplayed()) {
                check1 = false;
            }
            filterOne.clear();
        }
        return check1;
    }
//----------------------------------------------------------------- Table 1 Methods (NEGATIVE)

    public boolean noResultsOne(String garbage) {
        filterOne.sendKeys(garbage);
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOf(noResultsElem));
        return noResultsElem.isDisplayed();
    }
//----------------------/////////////////////////////////----------------------Table 2 Methods

    public void clickFilter() {
        filterButton.click();
    }

    public boolean filterTable(String[] keywords) {
        boolean check2 = true;
        for (int i = 0; i < keywords.length; i++) {
            selectInputFieldsTable2(i).sendKeys(keywords[i]);
            if (!selectOutputFieldsTable2(keywords[i]).isDisplayed()) {
                check2 = false;
            }
            selectInputFieldsTable2(i).clear();
        }
        return check2;
    }

    //--------------------------------------------------------------------------Table 2 Methods (NEGATIVE)
    public boolean noResults2(String[] keywords, String garbage) {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        boolean check = true;
        for (int i = 0; i < keywords.length; i++) {
            selectInputFieldsTable2(i).sendKeys(garbage);
            wait.until(ExpectedConditions.visibilityOf(noResultsElemTable2));
            if (!noResultsElemTable2.isDisplayed()) {
                check = false;
            }
            selectInputFieldsTable2(i).clear();

        }
        return check;
    }
}