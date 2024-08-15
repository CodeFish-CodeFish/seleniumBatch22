package com.luma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Alt + Insert for Windows users to generate constructor

    @FindBy(xpath = "//div[@class='control _with-tooltip']//input[@id='customer-email']")
    WebElement emailAddress;

    @FindBy(css = "input[name='firstname']")
    WebElement firstName;

    @FindBy(css = "input[name='lastname']")
    WebElement lastName;

    @FindBy(css = "input[name='street[0]']")
    WebElement address;

    @FindBy(css = "input[name='city']")
    WebElement city;

    @FindBy(css = "select[name='region_id']")
    WebElement stateDropdown;

    @FindBy(css = "input[name='postcode']")
    WebElement zipcode;

    @FindBy(css = "select[name='country_id']")
    WebElement countryDropdown;

    @FindBy(css = "input[name='telephone']")
    WebElement phoneNumber;

    @FindBy(xpath = "//span[.='Next']")
    WebElement nextButton;

    public void customerInfo(WebDriver driver, String emailAddress, String firstName, String lastName,
                             String address, String city, String state, String zipcode, String country,
                             String phone) {

        BrowserUtils.sendKeys(this.emailAddress, driver, emailAddress);
        BrowserUtils.sendKeys(this.firstName, driver, firstName);
        BrowserUtils.sendKeys(this.lastName, driver, lastName);
        BrowserUtils.sendKeys(this.address, driver, address);
        BrowserUtils.sendKeys(this.city, driver, city);
        BrowserUtils.selectBy(this.stateDropdown, state,"visibleText");
        BrowserUtils.sendKeys(this.zipcode, driver, zipcode);
        BrowserUtils.scrollWithPoint(this.nextButton, driver);
        String actualFirstOption = BrowserUtils.firstSelectOption(this.countryDropdown);

        Assert.assertEquals(actualFirstOption, country, "Failed to validate first select option");
        BrowserUtils.sendKeys(this.phoneNumber, driver, phone);
        BrowserUtils.click(this.nextButton, driver);



    }


}
