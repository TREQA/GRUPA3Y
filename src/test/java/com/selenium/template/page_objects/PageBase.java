package com.selenium.template.page_objects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageBase {

    //Declare WebDriver
    protected static WebDriver driver;

    public PageBase(WebDriver passedDriver) {
        this.driver = passedDriver;
        PageFactory.initElements(passedDriver, this);
    }

    // ---------------------------------------------------------------------------- Locators



    // ---------------------------------------------------------------------------- Metods



}