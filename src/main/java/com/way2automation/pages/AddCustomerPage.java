package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCodeField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;


    public void enterFirstName(String firstname){
        sendTextToElement(firstNameField, firstname);
        CustomListeners.test.log(Status.PASS,"Enter first name" + firstname);

    }

    public void enterLastName(String lastname){
      sendTextToElement(lastNameField,lastname);
      CustomListeners.test.log(Status.PASS,"Enter lastname" + lastname);
    }

    public void enterPostCode(String postcode){
      sendTextToElement(postCodeField, postcode);
      CustomListeners.test.log(Status.PASS,"Enter post code" + postcode);
    }

    public void clickOnAddToCustomerButton(){
        clickOnElement(addCustomerButton);
        CustomListeners.test.log(Status.PASS,"Click on add to customer button" );
    }

    public String verifyMessageFromPopUp(){
        CustomListeners.test.log(Status.PASS,"Get message from pop up" );
        return getTextFromAlert();
    }

    public void clickOkOnAccept(){
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Click on accept");
    }
}
