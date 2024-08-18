package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement card;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;


    public void checkoutInputForm(String name, String country, String city,
                                  String card, String month, String year){

        BrowserUtils.click(this.placeOrderButton, driver);
        BrowserUtils.sendKeys(this.name, driver, name);
        BrowserUtils.sendKeys(this.country, driver, country);
        BrowserUtils.sendKeys(this.city, driver, city);
        BrowserUtils.sendKeys(this.card, driver, card);
        BrowserUtils.sendKeys(this.month, driver, month);
        BrowserUtils.sendKeys(this.year, driver, year);
        BrowserUtils.click(this.purchaseButton, driver);






    }
}
