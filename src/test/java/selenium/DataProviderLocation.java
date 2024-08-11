package selenium;

import org.testng.annotations.DataProvider;

public class DataProviderLocation {


    @DataProvider
    public Object[][]testData() {

        return new Object[][]{
                // This will iterate all these test data
                {"Ular", "ID"},
                {"Petko", "String"},
                {"Viktor", "test"},
                {"Meryem", "Tester"},
                {"Calga", "QA"},
                {"Iliya", "SDET"},
                {"John", "Dev"},
                {"Doe", "Ops"},

        };


    }



}
