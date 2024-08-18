package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class BlazeMainPage {

    private WebDriver driver;

    public BlazeMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //alt + insert Windows users
    // macOS users command + n

    @FindBy(xpath = "//a[.='Laptops']")
    WebElement laptopsButton;

    @FindBy(xpath = "//a[.='MacBook Pro']")
    WebElement macBookPro;

    public void chooseMacBook(){
        BrowserUtils.click(this.laptopsButton, driver);
        BrowserUtils.click(this.macBookPro, driver);
    }





}
