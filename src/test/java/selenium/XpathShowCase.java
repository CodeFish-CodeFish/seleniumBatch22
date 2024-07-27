package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathShowCase {

    @Test
    public void xpathLocator() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement searchBar = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBar.sendKeys("Breaking Bad");


    }

    @Test
    public void xpathPractice() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement abTesting = driver.findElement(By.xpath("//a[@href='/abtest']"));
//        abTesting.click();
//
//        WebElement elementalSelenium = driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']"));
//        elementalSelenium.click();

        WebElement abTesting = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        abTesting.click();

        WebElement absoluteXpath = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")); // absolute xpath
        System.out.println(absoluteXpath.getText());

        WebElement elementalSelenium = driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        elementalSelenium.click();





    }


}
