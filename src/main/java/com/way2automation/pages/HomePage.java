package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLoginButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginButton;


    public void clickOnCustomerLoginButton(){
        clickOnElement(customerLoginButton);
        CustomListeners.test.log(Status.PASS,"Click on customer login button" );

    }

    public void clickOnBankManagerLoginButton(){
        clickOnElement(bankManagerLoginButton);
        CustomListeners.test.log(Status.PASS,"Click on Bank manager login button" );

    }
}
