package com.sauce_labs.tests;

import com.sauce_labs.pages.LoginPage;
import org.testng.annotations.Test;
import utils.TestBase;

public class SauceLabTests extends TestBase {

    @Test
    public void TC_01(){


        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");




    }


}
