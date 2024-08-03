package selenium;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite Annotation");
        // we use this before our testing by configuring our chromedriver properties
        // runs only once
        // deleting cookies
    }


    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test Annotation");
        // Normally used to make connection with Database before running tests
        // this runs only once
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class Annotation");
        // This is also used for common set up before executing test cases
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method Annotation");
        // This runs before our test cases
        // Here we can initialize our driver etc
        // This runs depending on how many test annotations we have
        // if we have multiple test annotations, beforeMethod will multiple times as well
    }

    @Test
    public void test(){
        System.out.println("Test annotation");
        // This is where are test cases are executed
        // we can have multiple test annotations
    }

    @Test
    public void test2(){
        System.out.println("Test Annotation 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
        // Closing/quiting drivers here
        // Take screenshot etc
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class Annotation");
        // Closing connections etc
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test Annotation");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite Annotation");
        // All test execution stopped here
    }



}
