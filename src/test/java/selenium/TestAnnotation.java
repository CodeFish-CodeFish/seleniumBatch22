package selenium;

import org.testng.annotations.Test;

public class TestAnnotation {

    @Test(priority = 1)
    public void u(){
        System.out.println("Test u");
        //
    }

    @Test(priority = 2)
    public void b(){
        System.out.println("Test b");
    }

    @Test(priority = 3)
    public void c(){
        System.out.println("Test c");
    }

    @Test(priority = 4)
    public void d(){
        System.out.println("Test d");
    }

    @Test(priority = 5)
    public void e(){
        System.out.println("Test e");
    }

}
