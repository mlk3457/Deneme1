package com.devbook.pages;

import com.devbook.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPanel extends BasePage {
    @FindBy(css = "input[name='email']")
    public WebElement loginPanelEmail_inputBox;
    @FindBy(css = "input[name='password']")
    public WebElement loginPanelPassword_inputBox;
    @FindBy(css = "input[name='login']")
    public WebElement loginPanelLogin_Btn;
    public void loginPanel() {
        loginPanelEmail_inputBox.sendKeys(ConfigurationReader.get("userName"));
        loginPanelPassword_inputBox.sendKeys(ConfigurationReader.get("password"));
        loginPanelLogin_Btn.click();

    }
}
