package com.devbook.pages;

import com.devbook.utilities.BrowserUtils;
import com.devbook.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.devbook.utilities.Driver.driver;

public class AdressBookPage extends BasePage {
    @FindBy(xpath = "//a[@title='My Account']/..")
    public WebElement myAccount_Btn;
    @FindBy(xpath = "(//a[text()='My Account'])[1]")
    public WebElement getMyAccount_Btn;
    @FindBy(xpath = "//a[text()='Address Book']")
    public WebElement adressBook_Btn;
    @FindBy(xpath = "//a[text()='Edit']")
    public WebElement edit_Btn;
    @FindBy(xpath = "//a[text()='Delete']")
    public WebElement delete_Btn;
    @FindBy(xpath = "//td[@class='text-left']/..")
    public WebElement deleteAdressBody;
    @FindBy(xpath = "//a[text()='New Address']")
    public WebElement newAdress_Btn;
    @FindBy(xpath = "//a[text()='Back']")
    public WebElement back_Btn;
    @FindBy(css = "#input-firstname")
    public WebElement firstName_inputbox;
    @FindBy(css = "#input-lastname")
    public WebElement lastName_inputbox;
    @FindBy(css = "#input-company")
    public WebElement company_inputbox;
    @FindBy(css = "#input-address-1")
    public WebElement adress1_inputbox;
    @FindBy(css = "#input-city")
    public WebElement city_inputbox;
    @FindBy(css = "#input-postcode")
    public WebElement postCode_inputbox;
    @FindBy(id = "input-country")
    public WebElement country_selectbox;
    @FindBy(id = "input-zone")
    public WebElement regionState_selectbox;
    @FindBy(xpath = "(//input[@name='default'])[1]")
    public WebElement defaultAdressYes_btn;
    @FindBy(xpath = "(//input[@name='default'])[2]")
    public WebElement defaultAdressNo_btn;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement continue_Btn;

    @FindBy(xpath = " //*[text()=' Your address has been successfully added']")
    public WebElement addedMessage;
    @FindBy(xpath = " //*[text()=' Your address has been successfully updated']")
    public WebElement updateMessage;
    @FindBy(xpath = "//*[text()=' Warning: You can not delete your default address!']")
    public WebElement warningMessage;
    @FindBy(xpath = "//*[text()=' Your address has been successfully deleted']")
    public WebElement deleteMessage;

    @FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
    public WebElement firstNameErrorMessage;

    public void enterCredentials_mtd(String FirstName, String LastName, String Company, String Address1, String City, String PostCode, String Country, String Region) {
        firstName_inputbox.sendKeys(FirstName);
        lastName_inputbox.sendKeys(LastName);
        company_inputbox.sendKeys(Company);
        adress1_inputbox.sendKeys(Address1);
        city_inputbox.sendKeys(City);
        postCode_inputbox.sendKeys(PostCode);
        selectCountryRegion_mtd(Country, Region);
    }

    public void selectCountryRegion_mtd(String Country, String Region) {
        Select slcCountry = new Select(country_selectbox);
        slcCountry.selectByVisibleText(Country);
        Select slcRegionState = new Select(regionState_selectbox);
        slcRegionState.selectByVisibleText(Region);
    }

    public void editAddress_mtd(String FirstName, String LastName, String Company, String Address1, String City, String PostCode, String Country, String Region) {
        firstName_inputbox.clear();
        BrowserUtils.waitFor(2);
        firstName_inputbox.sendKeys(FirstName);
        lastName_inputbox.clear();
        BrowserUtils.waitFor(2);
        lastName_inputbox.sendKeys(LastName);
        company_inputbox.clear();
        BrowserUtils.waitFor(2);
        company_inputbox.sendKeys(Company);
        adress1_inputbox.clear();
        BrowserUtils.waitFor(2);
        adress1_inputbox.sendKeys(Address1);
        city_inputbox.clear();
        BrowserUtils.waitFor(2);
        city_inputbox.sendKeys(City);
        BrowserUtils.waitFor(2);
        selectCountryRegion_mtd(Country, Region);
    }
    public void deleteAdress(){

        for (int i = 1; i <= delete_Btn.getSize().width ; i++) {
            if (defaultAdressYes_btn.isSelected()){
                delete_Btn.click();
                System.out.println("warningMessage.isDisplayed() = " + warningMessage.isDisplayed());
            }else if(defaultAdressNo_btn.isSelected()){
                delete_Btn.click();
                System.out.println("deleteMessage.isDisplayed() = " + deleteMessage.isDisplayed());
            }

        }
    }
    public void deleteAdress1(){

        for (int i = 1; i <= delete_Btn.getSize().width ; i++) {
              if(i == 1) {
                  delete_Btn.click();
                 warningMessage.isDisplayed();
                  BrowserUtils.waitFor(2);
              }else {
                delete_Btn.click();
                deleteMessage.isDisplayed();
                  BrowserUtils.waitFor(2);

              }

        }}

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

    public void radioBtn_mtd(String radiobutton) {
        if (radiobutton.equals("Yes")) {
            defaultAdressYes_btn.click();
        } else if (radiobutton.equals("No"))
            defaultAdressNo_btn.click();
    }
}
