package com.way2automation.testsuite;

import com.way2automation.customlisteners.CustomListeners;
import com.way2automation.pages.*;
import com.way2automation.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully(){
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();

        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerTab();

        //	enter FirstName
        addCustomerPage.enterFirstName("Hermoine");

        //	enter LastName
        addCustomerPage.enterLastName("Grangor");

        //	enter PostCode
        addCustomerPage.enterPostCode("NW7");

        //	click On "Add Customer" Button
        addCustomerPage.clickOnAddToCustomerButton();

        //	popup display
        //	verify message "Customer added successfully"
        Assert.assertEquals(addCustomerPage.verifyMessageFromPopUp(), "Customer added successfully with customer id :6");

        //	click on "ok" button on popup.
        addCustomerPage.clickOkOnAccept();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {

        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();

        //	click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccountTab();

        //	Search customer that created in first test
        openAccountPage.clickOnCustomerName();
        Thread.sleep(1000);
        openAccountPage.selectCustomerDropDown("Hermoine Granger");

        //	Select currency "Pound"
        openAccountPage.selectCurrencyDropdown("Pound");

        //	click on "process" button
        openAccountPage.clickOnProcessButton();

        //	popup displayed
        //	verify message "Account created successfully"
        Assert.assertEquals(openAccountPage.verifyMessageFromPopUp(), "Account created successfully with account Number :1016");

        //	click on "ok" button on popup
        openAccountPage.clickOkOnAccept();


    }

    @Test(groups = {"regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();

        //	search customer that you created.
        Thread.sleep(1000);
        customersPage.selectName("Hermoine Granger");

        //	click on "Login" Button
        customersPage.clickOnLoginButton();

        //	verify "Logout" Tab displayed.
        Assert.assertEquals(customerLoginPage.verifyLogoutText(),"");

        //	click on "Logout"
        customerLoginPage.clickOnLogoutButton();

        //	verify "Your Name" text displayed.
        Assert.assertEquals(customerLoginPage.verifyNameText(), "Your Name :");
    }

    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully(){
       //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();

        //	search customer that you created.
        customersPage.selectName("Hermoine Granger");

        //	click on "Login" Button
        customersPage.clickOnLoginButton();

        //	click on "Deposit" Tab
        accountPage.clickOnDepositTab();


        //	Enter amount 100
        accountPage.enterDepositAmount("100");

        //	click on "Deposit" Button
        accountPage.clickOnDepositButton();


        //	verify message "Deposit Successful"
        accountPage.verifyDepositMessage();
        Assert.assertEquals(accountPage.verifyDepositMessage(),"Deposit Successful");


    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        homePage.clickOnCustomerLoginButton();

        //	search customer that you created.
        Thread.sleep(1000);
        customersPage.selectName("Hermoine Granger");

        //	click on "Login" Button
        customersPage.clickOnLoginButton();

        //	click on "Withdrawl" Tab
        accountPage.clickOnWithdrawalTab();

        //	Enter amount 50
        accountPage.enterAmountToWithdraw("50");

        //	click on "Deposit" Button
        accountPage.clickOnWithdrawButton();

        //	verify message "Transaction Successful"
        Assert.assertEquals(accountPage.verifyTransactionSuccessfulMessage(),"Transaction successful");
    }
}
