package com.devbook.pages;

import com.devbook.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[text()='Close']")
    public WebElement popUpClose_Btn;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement email_inputBox;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement password_inputBox;

    @FindBy(xpath = "(//button[@class='button btn'])[1]")
    public WebElement login_Btn;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement loginAlert_msgText;

    public void loginPage(String email, String password) {
        email_inputBox.sendKeys(email);
        password_inputBox.sendKeys(password);
        login_Btn.click();
    }

    @FindBy(xpath = "//a[text()='Close']")
    public WebElement cookiesClose;

}
