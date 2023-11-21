package com.devbook.stepDefinitions;

import com.devbook.pages.HomePage;
import com.devbook.pages.LoginPage;
import com.devbook.pages.LoginPanel;
import com.devbook.utilities.BrowserUtils;
import com.devbook.utilities.ConfigurationReader;
import com.devbook.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPanel loginPanel=new LoginPanel();
    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();
    @Given("The user navigate to web page")
    public void the_user_navigate_to_web_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters login panel credential and clicks login button")
    public void the_user_enters_login_panel_credential_and_clicks_login_button() {
        loginPanel.loginPanel();
    }
    @When("The user closes cookies page")
    public void the_user_closes_cookies_page() {
        loginPage.popUpClose_Btn.click();
    }
    @Then("Verify that the user sees the homepage logo")
    public void Verify_that_the_user_sees_the_homepage_logo() {
        Assert.assertTrue(loginPage.homeLogo_icon.isDisplayed());
    }
    @When("The user clicks the login under the my account")
    public void the_user_clicks_the_login_under_the_my_account() {
        loginPage.myAccount_Btn.click();
        loginPage.accountLogin_Btn.click();
    }
    @When("The user enters account credentials {string} and {string} and clicks login")
    public void the_user_enters_account_credentials_and_and_clicks_login(String email, String password) {
        loginPage.loginPage(email, password);
        BrowserUtils.waitFor(2);
    }
    @Then("Verify that the user is on home page")
    public void verify_that_the_user_is_on_home_page() {
        Assert.assertTrue(homePage.loginSuccessfully_msg.isDisplayed());
    }
    @Then("Verify that the error message is displayed")
    public void verify_that_the_error_message_is_displayed() {
        String actualWarningMessage=loginPage.loginAlert_msgText.getText();
        Assert.assertTrue(actualWarningMessage.contains("Warning: "));
    }

}
