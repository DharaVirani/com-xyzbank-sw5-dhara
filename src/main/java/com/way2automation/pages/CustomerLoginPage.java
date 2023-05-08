package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//label[text()='Your Name :']")
    WebElement nameText;



    public void clickOnLogoutButton(){
        clickOnElement(logoutButton);
        CustomListeners.test.log(Status.PASS,"Click on logout button" );

    }

    public String verifyNameText(){
        CustomListeners.test.log(Status.PASS,"Get name text" );
        return getTextFromElement(nameText);

    }

    public String verifyLogoutText(){
        CustomListeners.test.log(Status.PASS,"Get logout text" );
        return getTextFromElement(logoutButton);

    }
}
