package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomersPage extends Utility {

    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement nameDropDown;

    @CacheLookup
    @FindBy(xpath = "//select[@name='userSelect']/child::*")
    List<WebElement> nameOfAllList;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;


    public void selectName(String option){
        clickOnElement(nameDropDown);
        getOptions(nameOfAllList,option);
        CustomListeners.test.log(Status.PASS,"Click on Element");
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on Login button");

    }


}
