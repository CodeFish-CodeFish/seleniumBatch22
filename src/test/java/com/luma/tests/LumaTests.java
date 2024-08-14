package com.luma.tests;

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

    }


}
