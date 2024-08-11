package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUpload {
    WebDriver driver;

    @BeforeMethod
    public void getStarted() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void uploadAFile() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileUploadInput = driver.findElement(By.cssSelector("#file-upload"));
        fileUploadInput.sendKeys("/Users/codefish/Desktop/B22HTML/breakingBad.jpeg");// provide path to you file


        Thread.sleep(3000);
        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        BrowserUtils.click(uploadButton);

        WebElement successMessage = driver.findElement(By.cssSelector("#uploaded-files"));

        String actualMessage = BrowserUtils.getText(successMessage);
        String expectedMessage = "breakingBad.jpeg";
        Assert.assertEquals(expectedMessage, actualMessage, "Failed to validate success message");
    }

    // create another test case, navigate to lambda webpage, click on Upload File link, upload a file, and validate success message

    @Test
    public void uploadFileOnLambda(){

        driver.get("https://www.lambdatest.com/selenium-playground/");
        WebElement uploadFileLink = driver.findElement(By.linkText("Upload File Demo"));
        BrowserUtils.click(uploadFileLink);

        WebElement chooseFile = driver.findElement(By.id("file"));
        BrowserUtils.sendKeys(chooseFile, "/Users/codefish/Desktop/B22HTML/breakingBad.jpeg");

        WebElement successMessage = driver.findElement(By.cssSelector("#error"));
        String actualMessage = BrowserUtils.getText(successMessage);
        String expectedMessage= "File Successfully Uploaded";

        Assert.assertEquals(actualMessage, expectedMessage, "Failed to validate success message");
        Assert.assertTrue(successMessage.isDisplayed(), "Message is not displayed");


    }





    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(4000);
        driver.quit();
    }


}
