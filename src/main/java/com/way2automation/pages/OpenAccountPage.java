package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerDropdown;

    @CacheLookup
    @FindBy(xpath = "//form[@role='form']/child::div[1]/select/child::*")
    List<WebElement> customerAllOptionsDropdown;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement processButton;


    public void clickOnCustomerName(){
        clickOnElement(customerDropdown);
        CustomListeners.test.log(Status.PASS,"Click on customer name" );

    }

    public void selectCustomerDropDown(String option){
        getOptions(customerAllOptionsDropdown,option);
        CustomListeners.test.log(Status.PASS,"Select customer dropdown" );

    }

    public void selectCurrencyDropdown(String option){
        clickOnElement(currencyDropdown);
        selectByValueFromDropDown(currencyDropdown,option);
        CustomListeners.test.log(Status.PASS,"Select currency dropdown" );

    }

    public void clickOnProcessButton(){
        clickOnElement(processButton);
        CustomListeners.test.log(Status.PASS,"Click on process button" );

    }


    public String verifyMessageFromPopUp(){
        CustomListeners.test.log(Status.PASS,"Get message from pop up" );
        return getTextFromAlert();
    }

    public void clickOkOnAccept(){
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Click on accept for alert" );

    }
}
