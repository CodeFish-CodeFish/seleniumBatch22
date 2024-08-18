package com.blaze.tests;

import com.aventstack.extentreports.Status;
import com.blaze.pages.BlazeMainPage;
import com.blaze.pages.CartPage;
import com.blaze.pages.DescriptionPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.TestBase;

public class BlazeTests extends TestBase {

    @Parameters({"name", "country", "city", "card", "month", "year"})
    @Test
    public void validatePurchaseExperience(String name, String country, String city,
                                           String card, String month, String year){

        driver.get(ConfigReader.readProperty("blazeurl"));
        test.log(Status.INFO, "Successfully landed on main page");

        BlazeMainPage mainPage = new BlazeMainPage(driver);
        mainPage.chooseMacBook();
        test.log(Status.INFO, "MacBook pro is selected on this page " + driver.getCurrentUrl());

        DescriptionPage descriptionPage = new DescriptionPage(driver);
        descriptionPage.addProductToCart();
        test.log(Status.INFO, "Product is successfully verified in product description page");

        CartPage cartPage = new CartPage(driver);
        cartPage.checkoutInputForm(name, country, city, card, month, year);
        test.log(Status.INFO, "User successfully performed a purchase");





    }


}
