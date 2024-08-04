package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

public class Iframes extends TestBase {

    @Test
    public void showTest() {

        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");

        //switching our driver into iFrame
        // driver.switchTo().frame("iFrame1");


        // switching to iframe with webElement
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iFrame1']"));
        driver.switchTo().frame(iframe);

        WebElement element = driver.findElement(By.xpath("//div[.='Your content.']"));
        element.clear();
        element.sendKeys("test step");


    }

    @Test
    public void nestedIframe() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // switching driver to an iframe
        driver.switchTo().frame("frame-top");

        // switching driver to an iframe
        driver.switchTo().frame("frame-left");


        WebElement leftText = driver.findElement(By.xpath("//body[contains(.,'LEFT')]"));
        System.out.println(leftText.getText());

//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");


        WebElement bottomText = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        System.out.println(bottomText.getText());


    }


    @Test
    public void iFramePractice() throws InterruptedException {

        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame1");

        WebElement category1 = driver.findElement(By.linkText("Category1"));
        category1.click();

        BrowserUtils.switch2Windows(driver);
        WebElement header1 = driver.findElement(By.xpath("//h1"));
        System.out.println(header1.getText());
        BrowserUtils.switch2Windows(driver);

        driver.switchTo().frame("Frame2");

        driver.findElement(By.linkText("Category3")).click();

        BrowserUtils.switchWindowWithURL(driver, "https://qavalidation.com/category/softwaretesting/");
        WebElement header2 = driver.findElement(By.xpath("//h1"));
        System.out.println(header2.getText());

        BrowserUtils.switchWindowWithURL(driver, "https://skpatro.github.io/demo/iframes/");

        System.out.println(driver.getTitle());








    }
}
