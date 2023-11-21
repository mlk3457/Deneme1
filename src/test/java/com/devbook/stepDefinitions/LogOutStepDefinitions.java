package com.devbook.stepDefinitions;

import com.devbook.pages.HomePage;
import com.devbook.pages.LoginPage;
import com.devbook.utilities.BrowserUtils;
import com.devbook.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogOutStepDefinitions {
    HomePage homePage = new HomePage();
    LoginPage loginPage=new LoginPage();
    String unExpectedWindowId="";
    @When("The user clicks to My Account button")
    public void the_user_clicks_to_my_account_button() {
        BrowserUtils.waitForClickablility(homePage.myAccount_Btn,3);
        homePage.myAccount_Btn.click();
    }
    @When("The user clicks to Logout button")
    public void the_user_clicks_to_logout_button() {
        Assert.assertFalse("Account logout box should not be displayed", homePage.accountLogout_box.isDisplayed());
        homePage.logout_Btn.click();
    }
    @Then("Verify that the user has securely terminated the session and sees the Account Logout Page")
    public void verify_that_the_user_has_securely_terminated_the_session_and_sees_the_account_logout_page() {
        BrowserUtils.waitForVisibility(homePage.accountLogout_box, 3);
        Assert.assertTrue("Account logout box should be displayed", homePage.accountLogout_box.isDisplayed());
    }
    @When("The user clicks to Exit Button \\(X)  for the browser close")
    public void the_user_clicks_to_exit_button_x_for_the_browser_close() throws InterruptedException {
        unExpectedWindowId= Driver.get().getWindowHandle();
        Driver.closeDriver();
        Thread.sleep(3000);
    }
    @Then("The user verify that current browser is not old browser")
    public void the_user_verify_that_current_browser_is_not_old_browser() {
        Assert.assertNotEquals(unExpectedWindowId,Driver.get().getWindowHandle());
    }
    @Then("Verify that the user has securely terminated the session and the login panel page is open")
    public void verify_that_the_user_has_securely_terminated_the_session_and_the_login_panel_page_is_open() {
        String actualMessage= Driver.get().findElement(By.xpath("//h5[text()='Please Enter Your Username and Password']")).getText();
        Assert.assertEquals("Please Enter Your Username and Password",actualMessage);
    }
    @Then("The user clicks to Go Back Button")
    public void the_user_clicks_to_go_back_button() {
        Driver.get().navigate().back();
    }
    @Then("Verify that successfully logged out")
    public void verify_that_successfully_logged_out() {
        loginPage.popUpClose_Btn.click();
        loginPage.myAccount_Btn.click();
        Assert.assertTrue(loginPage.accountLogin_Btn.isDisplayed());
    }
    @When("The user waits {int} minutes without any movement on the web site")
    public void the_user_waits_minutes_without_any_movement_on_the_web_site(int waitMinutes) {
        BrowserUtils.waitFor(waitMinutes*60);
    }
    @When("The user clicks to Refresh button")
    public void the_user_clicks_to_refresh_button() {
        Driver.get().navigate().refresh();
        loginPage.popUpClose_Btn.click();
    }
    @Then("Verify that automatic logged out of the web site")
    public void verify_that_automatic_logged_out_of_the_web_site() {
        Assert.assertFalse(loginPage.logout_Btn.isDisplayed());
    }
    @When("The user navigates to url {string}")
    public void the_user_navigates_to_url(String url) {
        Driver.get().navigate().to(url);
        BrowserUtils.waitForPageToLoad(3);

    }
    @Then("Verify that the url {string} page opens")
    public void verify_that_the_url_page_opens(String expUrl) {
        Assert.assertEquals(expUrl,Driver.get().getCurrentUrl());
    }
    @Then("The user  waits  {int} minutes and clicks to *Click to go back button*")
    public void the_user_waits_minutes_and_clicks_to_click_to_go_back_button(int waitMinutes) {
        BrowserUtils.waitFor(waitMinutes*60);
        Driver.get().navigate().back();
        loginPage.popUpClose_Btn.click();
        homePage.myAccount_Btn.click();
    }
}
