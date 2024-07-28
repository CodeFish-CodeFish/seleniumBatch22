package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationsIntro {


    @Test
    public void assertionsShowCase(){

        String str1 = "kuba";
        String str2 = "kuba";

        Assert.assertEquals(str1, str2, "Validation of 2 strings have failed");
        // will see the message only when validation fails

        System.out.println("End of code");

        String s = "bob";

       // Assert.assertTrue(s.contains("c"), "A specified character was missing in the string");
        Assert.assertFalse(s.contains("c"), "A specified character was missing in the string");
    }


}
