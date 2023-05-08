package com.way2automation.pages;

import com.aventstack.extentreports.Status;
import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement  transactionsTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement  depositTab;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement  withdrawalTab;

    @CacheLookup
    @FindBy(xpath = "//input[@type='number']")
    WebElement  amtDepositedField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement  depositButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement  depositText;

    @CacheLookup
    @FindBy(xpath = "//input[@type='number']")
    WebElement  amountToBeWithdrawnField;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement  withdrawButton;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement  withdrawSuccessfulMessage;


    public void clickOnTransactionTab(){
        clickOnElement(transactionsTab);
    }

    public void clickOnDepositTab(){
        clickOnElement(depositTab);
        CustomListeners.test.log(Status.PASS,"Click on Deposit tab");

    }

    public void clickOnWithdrawalTab(){
        clickOnElement(withdrawalTab);
        CustomListeners.test.log(Status.PASS,"Click on Withdrawal tab");

    }

    public void enterDepositAmount(String amount){
        sendTextToElement(amtDepositedField, amount);
        CustomListeners.test.log(Status.PASS,"Enter deposit amount" + amount);
    }

    public void clickOnDepositButton(){
        clickOnElement(depositButton);
        CustomListeners.test.log(Status.PASS,"Click on Deposit tab");
    }

    public String verifyDepositMessage(){
        CustomListeners.test.log(Status.PASS,"Get deposited message");
        return getTextFromElement(depositText);
    }

    public void enterAmountToWithdraw(String amount){
        sendTextToElement(amountToBeWithdrawnField,amount);
        CustomListeners.test.log(Status.PASS,"Entered amount to withdraw" + amount);
    }

    public void clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
        CustomListeners.test.log(Status.PASS,"Click on  withdraw button");
    }

    public String verifyTransactionSuccessfulMessage(){
        CustomListeners.test.log(Status.PASS,"Get transaction successful message");
        return getTextFromElement(withdrawSuccessfulMessage) ;
    }
}
