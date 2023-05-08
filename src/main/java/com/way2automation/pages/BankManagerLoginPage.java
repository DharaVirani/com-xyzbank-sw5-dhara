package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomerTab;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersButton;



    public void clickOnAddCustomerTab(){
        clickOnElement(addCustomerTab);
        CustomListeners.test.log(Status.PASS,"Click on add customer tab" );

    }

    public void clickOnOpenAccountTab(){
        clickOnElement(openAccountButton);
        CustomListeners.test.log(Status.PASS,"Click on open account tab" );
    }

    public void clickOnCustomersTab(){
        clickOnElement(customersButton);
        CustomListeners.test.log(Status.PASS,"Click on  customer tab" );

    }

}
