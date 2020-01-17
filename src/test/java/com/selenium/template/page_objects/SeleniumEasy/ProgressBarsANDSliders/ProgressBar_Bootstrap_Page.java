package com.selenium.template.page_objects.SeleniumEasy.ProgressBarsANDSliders;
import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgressBar_Bootstrap_Page extends PageBase {

    public ProgressBar_Bootstrap_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "cricle-btn")
    private WebElement BootstrapDownloadButton;

    @FindBy(className = "percenttext")
    private WebElement BootstrapPercentText;

    //------------------------------------------------------
    public void clickBootstrapDownloadButton() {
        SeleniumWrapper.clickElement(driver, BootstrapDownloadButton, "Click Bootstrap Download Button");
    }

    public boolean checkPercentText() {
        boolean x = BootstrapPercentText.getText().contains("100");
        return x;
    }
    public void checkCompletionPercentage() throws InterruptedException {
        while (!checkPercentText()) {
            Thread.sleep(6000);
            System.out.println(checkPercentText());
        }
  }}