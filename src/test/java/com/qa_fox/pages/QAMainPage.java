package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.DriverHelper;

import javax.sql.rowset.BaseRowSet;

public class QAMainPage {

    private WebDriver driver;

    public QAMainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//span[.='My Account']")
    WebElement myAccount;

    @FindBy(xpath = "//a[.='Register']")
    WebElement register;


    public void clickOnRegister(){

        BrowserUtils.click(this.myAccount, driver);
        BrowserUtils.click(this.register, driver);

    }


}
