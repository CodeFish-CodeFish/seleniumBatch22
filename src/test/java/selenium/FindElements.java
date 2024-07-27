package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindElements {

    WebDriver driver;

    @BeforeMethod
    public void getStarted() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void findElementsPractice() {

//        WebElement element = driver.findElement(By.xpath("")); // returns single element --> throws noSuchElementException if element is missing
//        String str = element.getText();



        List<WebElement> elements = driver.findElements(By.tagName("li"));//returns multiple elements --> does not throw an exception, instead it will return empty list if
        //element is missing

        int count = 0;
        for (int i = 0; i < elements.size(); i++) {

           // loop through elements, get text length, if the length is less than 6, print out and count all these printed string
            String str = elements.get(i).getText();

            if (str.length() < 12){
                System.out.println(elements.get(i).getText());
                count++;
            }
        }

        int coun2 = 0;
        for (WebElement element :elements){

            if (element.getText().length() < 12){
                System.out.println(element.getText());
                coun2++;
            }

        }
        System.out.println(coun2);

        System.out.println("count is " + count);





























    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(4000);
        driver.quit();
    }
}
