package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class CssLocators {


    @Test
    public void cssLocatorShowCase() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement nameField = driver.findElement(By.cssSelector("input[id='title']")); // xpath expression for css locator
        BrowserUtils.sendKeys(nameField, "TEST TEST TEST");

        WebElement messageField = driver.findElement(By.cssSelector("#description"));// id for css locator
        BrowserUtils.sendKeys(messageField, "This message is for general manager of your hamburger join");

        WebElement submitBtn = driver.findElement(By.cssSelector("input[name='btn-submit']"));// xpath expression for css locator
        BrowserUtils.click(submitBtn);








    }


}
