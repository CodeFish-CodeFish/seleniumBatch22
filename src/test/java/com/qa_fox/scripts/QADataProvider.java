package com.qa_fox.scripts;

import org.testng.annotations.DataProvider;

public class QADataProvider {

    @DataProvider(name = "qaFoxData")
    public Object [][]qaFoxData(){

        return new Object[][]{

                {"Kobe", "Abdy", "test@email.com", "3123232323", "kjdhsfkhjdskjf", "kjdhsfkhjdskjf"}

        };

    }

}
