package com.selenium.template.page_objects.SeleniumEasy;
import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import com.selenium.template.utils.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.selenium.template.utils.TestData.SHORT_WAIT;

public class ProgressBar_BootstrapPage extends PageBase {

    public ProgressBar_BootstrapPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="circle-btn")
    private WebElement BootstrapDownloadButton;

    @FindBy (className="percenttext")
    private WebElement BootstrapPercentText;

//------------------------------------------------------
    public void clickBootstrapDownloadButton(){
    SeleniumWrapper.clickElement(driver, BootstrapDownloadButton, "Click Bootstrap Download Button");
}

    public boolean checkCompletionPercentage () {
            if (.getText.BootstrapPercentText != 100)
            { return false; SHORT_WAIT}
            else {
                return true;
            }
    }}
