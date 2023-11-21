package com.devbook.stepDefinitions;

import com.devbook.pages.AdressBookPage;
import com.devbook.pages.LoginPage;
import com.devbook.pages.LoginPanel;
import com.devbook.pages.MyAccount;
import com.devbook.utilities.BrowserUtils;
import com.devbook.utilities.ConfigurationReader;
import com.devbook.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount_step {
 MyAccount myAccount=new MyAccount();
    @Given("The user clicks on the Edit Account button")
    public void the_user_clicks_on_the_edit_account_button() {
       myAccount.editAccountBtn.click();
    }
    @When("The user clicks on {string} box,{string} box,{string} box,{string} box select enters valid data")
    public void the_user_clicks_on_box_box_box_box_select_enters_valid_data(String FirstName, String LastName , String Email, String Telephone) {
       myAccount.editMyAccountLogin(FirstName,LastName,Email,Telephone);
    }
    @When("The user click continue button")
    public void the_user_click_continue_button() {
       myAccount.continue_Btn.click();
    }
    @Then("Verify that you can receive a my account verification message {string}")
    public void verify_that_you_can_receive_a_my_account_verification_message(String message) {
        BrowserUtils.waitFor(1);
       myAccount.verifyMessage(message);
    }

    @When("The user clicks on {string} box,{string} box,{string} box,{string} box select enters invalid data")
    public void the_user_clicks_on_box_box_box_box_select_enters_invalid_data(String FirstName, String LastName , String Email, String Telephone) {
       myAccount.editMyAccountLogin(FirstName,LastName,Email,Telephone);
    }
    @Then("Verify that you can receive my account alert message {string}")
    public void verify_that_you_can_receive_my_account_alert_message(String message) {
        myAccount.errorVerifyMessage(message);
    }
    @Then("The use standardizes login data")
    public void the_use_standardizes_login_data() {
        myAccount.dataStandardizesLogin();
    }

}
