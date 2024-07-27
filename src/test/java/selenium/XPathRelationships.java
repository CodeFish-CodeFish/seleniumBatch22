package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class XPathRelationships {

    WebDriver driver;

    @BeforeMethod
    public void getStarted() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void xpathRelationshipShowCase() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
       // WebElement slider1 = driver.findElement(By.xpath("//div[@id='slider1']//div//input")); // parent/child relationship

        List<WebElement> allSliders = driver.findElements(By.xpath("//input[@class='sp__range']"));
        List<WebElement> allText = driver.findElements(By.xpath("//output"));

        for (int i = 0; i < allSliders.size(); i++) {

           while (!allText.get(i).getText().equals("95")){

               allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);
           }

        }




    }

    @Test
    public void codeFishWebPage(){
        driver.get("https://codefish.io/");
        ////div[@class='gradient-block']//p

        // Task, print out text from codefish under this xpath -> //div[@class='gradient-block']//p

        List<WebElement> textFromCodeFish = driver.findElements(By.xpath("//div[@class='gradient-block']//p"));
        for (int i = 0; i < textFromCodeFish.size(); i++) {

            String eachText = textFromCodeFish.get(i).getText();
            System.out.println(eachText);


        }



    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(4000);
        driver.quit();
    }
}
