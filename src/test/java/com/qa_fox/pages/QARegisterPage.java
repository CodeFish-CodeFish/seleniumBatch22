package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class QARegisterPage {

    public QARegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-firstname")
    WebElement firstname;

    @FindBy(css = "#input-lastname")
    WebElement lastname;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-telephone")
    WebElement telephone;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;

    @FindBy(xpath = "//label[@class='radio-inline']//input[@value='1']")
    WebElement yesRadioButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitBtn;

    public void registerUser(WebDriver driver, String firstname, String lastname, String email, String telephone,
                             String password, String confirmPassword){

        BrowserUtils.sendKeys(this.firstname, driver, firstname);
        BrowserUtils.sendKeys(this.lastname, driver, lastname);
        BrowserUtils.sendKeys(this.email, driver, email);
        BrowserUtils.sendKeys(this.telephone, driver, telephone);
        BrowserUtils.sendKeys(this.password, driver, password);
        BrowserUtils.sendKeys(this.confirmPassword, driver, confirmPassword);

        BrowserUtils.click(this.yesRadioButton, driver);
        BrowserUtils.click(this.checkBox, driver);
        BrowserUtils.click(this.submitBtn, driver);



    }

}
