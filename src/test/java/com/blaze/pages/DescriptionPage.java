package com.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class DescriptionPage {
    private WebDriver driver;

    public DescriptionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartLink;

    public void addProductToCart(){

        BrowserUtils.click(this.addToCartButton, driver);

        String textFromAlert = BrowserUtils.getTextFromAlert(driver);
        System.out.println(textFromAlert);

        BrowserUtils.acceptJsAlert(driver);

        BrowserUtils.click(this.cartLink, driver);

    }



}
