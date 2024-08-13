package com.sauce_labs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ProductPage {

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select")
    WebElement priceDropdown;

    @FindBy(css = "#react-burger-menu-btn")
    WebElement hamburgerMenu;



    public void sanityCheck(){

        BrowserUtils.selectBy(this.priceDropdown, "Price (high to low)","visibleText");
        BrowserUtils.click(this.hamburgerMenu);
    }





}
