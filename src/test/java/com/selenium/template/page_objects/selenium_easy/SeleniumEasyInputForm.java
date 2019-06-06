package com.selenium.template.page_objects.selenium_easy;

import com.selenium.template.page_objects.PageBase;
import com.selenium.template.utils.SeleniumWrapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SeleniumEasyInputForm extends PageBase {
    public SeleniumEasyInputForm(WebDriver driver) {super(driver);}

    @FindBy (css = "#contact_form > fieldset > div:nth-child(2) > div > div > input")
    WebElement firstName;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(3) > div > div > input")
    WebElement lastName;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(4) > div > div > input")
    WebElement eMail;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(5) > div > div > input")
    WebElement phoneNumber;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(6) > div > div > input")
    WebElement address;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(7) > div > div > input")
    WebElement city;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(8) > div > div > select")
    WebElement state;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(9) > div > div > input")
    WebElement zipCode;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(10) > div > div > input")
    WebElement websiteOrDomainName;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(11) > div > div:nth-child(1) > label > input[type=radio]")
    WebElement yesCheckboxHosting;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(11) > div > div:nth-child(2) > label > input[type=radio]")
    WebElement noCheckboxHosting;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(12) > div > div > textarea")
    WebElement projectDescription;

    @FindBy (css = "#contact_form > fieldset > div:nth-child(14) > div > button")
    WebElement sendForm;

    public void setName(String firstNameInput, String lastNameInput){
        SeleniumWrapper.sendKeys(firstName, firstNameInput, "First name input");
        SeleniumWrapper.sendKeys(lastName, lastNameInput, "Last name input");
    }
    public void setContactDetails(String eMailAddressInput, String phoneNumberInput){
        SeleniumWrapper.sendKeys(eMail, eMailAddressInput, "E-Mail address input");
        SeleniumWrapper.sendKeys(phoneNumber, phoneNumberInput, "Phone Number Input");
    }
    public void setAddressDetails(String addressInput, String cityInput, String zipCodeInput, int indexNumber){
        SeleniumWrapper.sendKeys(address, addressInput, "Address Input");
        SeleniumWrapper.sendKeys(city, cityInput, "City Input");
        SeleniumWrapper.sendKeys(zipCode, zipCodeInput, "Zip code input");

        Select stateDropdown = new Select(state);
        stateDropdown.selectByIndex(indexNumber);
    }
    public void setWebsiteOrDomainName(String websiteOrDomainInput){
        SeleniumWrapper.sendKeys(websiteOrDomainName, websiteOrDomainInput, "Website/Domain input");
    }
    public void clickHostingNoButton(){
        SeleniumWrapper.clickElement(driver, noCheckboxHosting, "No checkbox for hosting");
    }
    public void clickHostingYesButton(){
        SeleniumWrapper.clickElement(driver, yesCheckboxHosting, "Yes checkbox for hostin");
    }
    public void setProjectDescription(String projectDescriptionInput){
        SeleniumWrapper.sendKeys(projectDescription, projectDescriptionInput, "Input for project description");
    }
    public void clickSendForm(){
        SeleniumWrapper.clickElement(driver, sendForm, "Send form button");
    }
    public String projectDescriptionText(){
        return projectDescription.getText();
    }
}
