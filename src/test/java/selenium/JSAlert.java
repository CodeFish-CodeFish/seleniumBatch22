package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

public class JSAlert extends TestBase {

    @Test
    public void practicePopUpHandle() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(.,'Click for JS Alert')]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        String textFromAlert = alert.getText().trim();

        Assert.assertEquals(textFromAlert, "I am a JS Alert");

        System.out.println(textFromAlert);
        alert.accept();

        WebElement jsConfirm = driver.findElement(By.xpath("//button[contains(.,'Click for JS Confirm')]"));
        jsConfirm.click();
        Thread.sleep(3000);

        alert.dismiss();

        // NOTE: We have not handled popup alert yet. We are trying to click after popup alert is displayed

        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(.,'Click for JS Prompt')]"));
        jsPrompt.click();

        alert.sendKeys("Codefish, Java, Selenium, TestNG");
        Thread.sleep(3000);
        alert.accept();

        WebElement enteredText = driver.findElement(By.cssSelector("#result"));
        System.out.println(BrowserUtils.getText(enteredText));


    }

    @Test
    public void normalAlertPractice() throws InterruptedException {

        driver.get("https://sweetalert.js.org/");
        WebElement preview1 = driver.findElement(By.xpath("//h5[contains(.,'Normal alert')]//following-sibling::button"));
        preview1.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.accept();

        WebElement preview2 = driver.findElement(By.xpath("//h5[contains(text(),'SweetAlert')]//following-sibling::button"));
        preview2.click();

        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();







    }

}
