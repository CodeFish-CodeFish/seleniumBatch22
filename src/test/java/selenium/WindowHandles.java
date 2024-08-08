package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.TestBase;

import java.util.Set;

public class WindowHandles extends TestBase {


    @Test
    public void switchWindowTest() {

        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement link = driver.findElement(By.linkText("Click Here"));

        link.click();

        String currentWindowID = driver.getWindowHandle();

        Set<String> allWindowIDs = driver.getWindowHandles();

        System.out.println(allWindowIDs);
        //[EBA39AE895B8CAD741AD7D8D3B4B71B2, 69DAA8BD2FC36529F8C1CE1AD6B8052B]

        for (String id : allWindowIDs) { // Enhance for loop

            if (!id.equals(currentWindowID)) {
                driver.switchTo().window(id);
                break;
            }

        }


        WebElement newWindowText = driver.findElement(By.xpath("//h3[contains(.,'New Window')]"));
        System.out.println(BrowserUtils.getText(newWindowText));

    }

    @Test
    public void switchWindowsTask() throws InterruptedException {
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
        SoftAssert softAssert = new SoftAssert();
        WebElement button2 = driver.findElement(By.cssSelector("#newTabBtn"));
        button2.click();


        BrowserUtils.switch2Windows(driver);

        Thread.sleep(5000);
        WebElement alertBtn = driver.findElement(By.cssSelector("#alertBox"));
        alertBtn.click();

        Alert alert = driver.switchTo().alert();

        String actualAlertText = alert.getText();
        String expectedAlertText = "I am an alert box!";
        softAssert.assertEquals(actualAlertText, expectedAlertText, "Failed to validate");
      //  Assert.assertEquals(actualAlertText, expectedAlertText, "Failed to validate alert text");

        softAssert.assertAll();// if this one is not used, it will not show validation failures
        alert.accept();
    }


    @Test
    public void multipleWindows() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");

        //Twitter window opened separately
        WebElement twitter = driver.findElement(By.partialLinkText("Twitter"));
        twitter.click();

        Thread.sleep(3000);
        //Facebook window opened separately
        WebElement facebook = driver.findElement(By.partialLinkText("Facebook"));
        facebook.click();

        Thread.sleep(3000);
        //LinkedIn window opened separately
        WebElement linkedIn = driver.findElement(By.partialLinkText("Linkedin"));
        linkedIn.click();

        //Switching driver with the help of title of the web page
        String facebookTitle = "LambdaTest | San Francisco CA | Facebook";
        BrowserUtils.switchWindowWithTitle(driver, facebookTitle);
        System.out.println(driver.getTitle());


    }


}
