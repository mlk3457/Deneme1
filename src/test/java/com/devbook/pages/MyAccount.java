package com.devbook.pages;

import com.devbook.utilities.BrowserUtils;
import com.devbook.utilities.ConfigurationReader;
import com.devbook.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{
    @FindBy(xpath= "//span[text()='My Account']")
    public WebElement MyAccountBtn;
    @FindBy(id= "pt-login-link")
    public WebElement loginBtn;
    @FindBy(xpath= "//input[@id='input-email']")
    public WebElement email_inputBtn;
    @FindBy(xpath= "//input[@id='input-password']")
    public WebElement password_inputBtn;
    @FindBy(xpath = "(//button[@class='button btn'])[1]")
    public WebElement login_clickBtn;
    @FindBy(xpath= "(//a[contains(.,'My Account')])[2]")
    public WebElement childMyAccountBtn;
    @FindBy(xpath= "//a[text()='Edit Account']")
    public WebElement editAccountBtn;
    @FindBy(xpath= "//input[@id='input-firstname']")
    public WebElement firstName_Btn;
    @FindBy(xpath= "//input[@id='input-lastname']")
    public WebElement lastName_Btn;
    @FindBy(xpath= "//input[@id='input-email']")
    public WebElement email_Btn;
    @FindBy(xpath= "//input[@id='input-telephone']")
    public WebElement telephone_Btn;
    @FindBy(xpath= "//input[@type='submit']")
    public WebElement continue_Btn;
    @FindBy(xpath = "//*[text()=' Success: Your account has been successfully updated.")
    public WebElement successVerify;
    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!")
    public WebElement warningMessageFirstName;
    @FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!")
    public WebElement warningMessageLastName;
    @FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!")
    public WebElement warningMessageEmail;
    @FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
    public WebElement warningMessageTelephone;

    public void login(){
        email_inputBtn.sendKeys(ConfigurationReader.get("loginEmail"));
        password_inputBtn.sendKeys(ConfigurationReader.get("loginPassword"));
        login_clickBtn.click();
    }
    public void editMyAccountLogin(String firstName, String lastName, String email, String telefon){
        firstName_Btn.clear();
        firstName_Btn.sendKeys(firstName);
        lastName_Btn.clear();
        lastName_Btn.sendKeys(lastName);
        email_Btn.clear();
        email_Btn.sendKeys(email);
        telephone_Btn.clear();
        telephone_Btn.sendKeys(telefon);
    }
    public void dataStandardizesLogin(){
        editAccountBtn.click();
        firstName_Btn.clear();
        BrowserUtils.waitFor(1);
        firstName_Btn.sendKeys("nesibe");
        lastName_Btn.clear();
        lastName_Btn.sendKeys("oguz");
        email_inputBtn.clear();
        email_inputBtn.sendKeys(ConfigurationReader.get("loginEmail"));
    }
   public void verifyMessage(String expectedMessage) {
        WebElement element = Driver.get().findElement((By.xpath("//*[text()=' " + expectedMessage + "']")));
        String acutuelMessage = element.getText();
        Assert.assertEquals(acutuelMessage, expectedMessage);

    }
    public void errorVerifyMessage(String expectedMessage) {
        WebElement element = Driver.get().findElement((By.xpath("//div[text()='" + expectedMessage + "']")));
        String acutuelMessage = element.getText();
        Assert.assertEquals(acutuelMessage, expectedMessage);
    }



}
