package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeleniumEasyTablePagination extends PageBase {
    public SeleniumEasyTablePagination(WebDriver driver){super(driver);}

    @FindBy (css = "#myPager > li:nth-child(5) > a")
    WebElement nextPage;

    @FindBy (css = "#myPager > li:nth-child(1) > a")
    WebElement prevPage;

    @FindBy (id = "myPager")
    WebElement pages;


    public void clickNextPage(){
        SeleniumWrapper.clickElement(driver, nextPage, "Next Page button");
    }

    public void clickPrevPage() {
        SeleniumWrapper.clickElement(driver, prevPage, "Previous Page button");
    }

    public void selectPages(String desiredPage){
        driver.findElement(By.xpath("//A[@href='#'][text()='"+desiredPage+"']")).click();

    }
}
