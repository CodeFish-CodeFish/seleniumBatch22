package com.qa_fox.scripts;

import com.qa_fox.pages.QAMainPage;
import com.qa_fox.pages.QARegisterPage;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.TestBase;

public class QA_Fox_Tests extends TestBase {


    @Test(dataProvider = "qaFoxData", dataProviderClass = QADataProvider.class)
    public void validateUserRegisterExperience(String firstname, String lastname, String email, String telephone,
                                               String password, String confirmPassword){

        driver.get(ConfigReader.readProperty("qa_fox"));
        QAMainPage mainPage = new QAMainPage(driver);
        mainPage.clickOnRegister();

        QARegisterPage registerPage = new QARegisterPage(driver);
        registerPage.registerUser(firstname, lastname, email, telephone, password, confirmPassword);
    }


}
