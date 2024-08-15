package com.luma.tests;

import com.luma.pages.CheckoutPage;
import com.luma.pages.LumaMainPage;
import com.luma.pages.ProductListPage;
import org.testng.annotations.Test;
import utils.TestBase;

public class LumaTests extends TestBase {


    @Test
    public void validatePurchaseExperience() throws InterruptedException {

        driver.get("https://magento.softwaretestingboard.com/");
        LumaMainPage mainPage = new LumaMainPage(driver);
        mainPage.clickOnBags(driver);

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.chooseProductAndClickCheckout(driver);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.customerInfo(driver, "test@gmail.com", "John", "Snow",
                                  "Michigan ave", "Seattle", "Washington", "60656",
                                    "United States", "3123456446546");

    }

    @Test
    public void testGoogleWithXml(){
        driver.get("https://www.google.com/");
        System.out.println("We navigated to google home page");
    }


}
