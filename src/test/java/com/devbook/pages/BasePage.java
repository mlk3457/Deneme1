package com.devbook.pages;

import com.devbook.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@title='My Account']/..")
    public WebElement myAccount_Btn;
    @FindBy(xpath = "//a[@id='pt-login-link']/..")
    public WebElement accountLogin_Btn;
    @FindBy(xpath = "//div[@id='logo']")
    public WebElement homeLogo_icon;
    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    public WebElement cartIcon_Btn;
    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
    public WebElement cartProduct_list;
    @FindBy(xpath = "//span[text()='Category']/../..")
    public WebElement category_Btn;
    @FindBy(xpath = "//a[@id='pt-logout-link']/..")
    public WebElement logout_Btn;
    @FindBy(xpath = "//a[text()='My Account'][1]")
    public WebElement myAccountShow_Btn;

}
