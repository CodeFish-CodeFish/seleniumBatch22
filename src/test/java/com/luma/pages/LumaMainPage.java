package com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LumaMainPage {

    public LumaMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[.='Gear']")
    WebElement gear;

    @FindBy(xpath = "//span[.='Bags']")
    WebElement bags;

    public void clickOnBags(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(this.gear).click(this.bags).build().perform();
    }









}
