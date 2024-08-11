package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

import java.time.Duration;

public class ExplicitWaitTimes extends TestBase {


    @Test
    public void explicitWaitExample(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();

        WebElement helloWorldText = driver.findElement(By.cssSelector("div[id='finish']"));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

        String text = BrowserUtils.getText(helloWorldText, driver);
        System.out.println(text);

    }


}
