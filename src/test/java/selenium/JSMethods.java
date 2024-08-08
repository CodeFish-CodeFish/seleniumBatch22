package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

public class JSMethods extends TestBase {


    // Implementing some JavaScript methods
    @Test
    public void getTitleWithJS() {


        driver.get("https://www.abt.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualTitle = js.executeScript("return document.title").toString();
        String expectedTitle = "Abt: Appliances and Electronics Store | Refrigerators, Appliances, TVs";
        Assert.assertEquals(actualTitle, expectedTitle, "Failed to validate title of abt.com");
        System.out.println(actualTitle);

    }

    @Test
    public void clickWithJS() {

        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[.='About us']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);




    }

    @Test
    public void scrollWithJs(){
        driver.get("https://codefish.io/");
        WebElement faceBookLogo = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", faceBookLogo);


    }

    @Test
    public void getURlWithJS(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://codefish.io/')");
        js.executeScript("window.open('https://www.google.com/')");
        js.executeScript("window.open('https://www.costco.com/')");

        String expectedTitle = "Google";

        BrowserUtils.switchWindowWithTitle(driver, expectedTitle);
        System.out.println(driver.getTitle());








    }




}
