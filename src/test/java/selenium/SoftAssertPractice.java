package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {

    public int num(int num1, int num2){

        return num1+num2;
    }


    @Test
    public void softAssertShowCase(){

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1+2, 4);
        softAssert.assertEquals(1+6, 4);
        softAssert.assertEquals(1+6, 7);
        System.out.println("This line of code will be executed");
        
        // wraps up all the validation in the console at the end of test execution
        softAssert.assertAll("Failed to validate below mentioned data");



       // Assert.assertEquals(3+3, 5); // Hard-assert
        System.out.println("This line of code will not be executed");





    }



}
