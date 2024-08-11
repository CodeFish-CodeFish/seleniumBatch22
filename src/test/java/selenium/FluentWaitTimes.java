package selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

import java.time.Duration;

public class FluentWaitTimes extends TestBase {

    @Test
    public void fluentWaitExample(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement button1 = driver.findElement(By.xpath("//button[.='Remove']"));
        button1.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // general wait for the specific webElement (Not Global Wait!!!)
                .pollingEvery(Duration.ofSeconds(2)) // interval of 2 seconds
                .ignoring(ElementClickInterceptedException.class);
        WebElement text1 = driver.findElement(By.xpath("//p[@id='message']"));

        fluentWait.until(ExpectedConditions.visibilityOf(text1));
        System.out.println(text1.getText());





    }

    @Test
    public void fluentWaitExample2(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton = driver.findElement(By.xpath("//button[.='Enable']"));
        enableButton.click();

       // Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(ElementNotInteractableException.class);

        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']"));

       // wait.until(ExpectedConditions.elementToBeClickable(inputField));
        BrowserUtils.sendKeys(inputField, driver, "test test test");



    }

}
