package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

public class Practice1 extends TestBase {

    /*
    1. Navigate to webpage https://www.techlistic.com/p/selenium-practice-form.html
    2. Fill out firstName, LastName
    3. Choose gender and years of experience as 7 years
    4. Enter date and check automation tester, along with selenium webDriver
    5. Select North America and WebElement options from both dropdown
    6. Upload a file

     */

    @Test
    public void techlisticWebPage() throws InterruptedException {

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        BrowserUtils.sendKeys(firstName,"Kobe");

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        BrowserUtils.sendKeys(lastName, "Abdy");

        WebElement gender = driver.findElement(By.cssSelector("input[value='Male']"));
        BrowserUtils.click(gender);

        WebElement yearOfEx = driver.findElement(By.cssSelector("input[id='exp-6']"));
        BrowserUtils.click(yearOfEx);

        WebElement datePicker = driver.findElement(By.cssSelector("input[id='datepicker']"));
        BrowserUtils.sendKeys(datePicker, "09/09/2024");
        Thread.sleep(4000);
        WebElement automationTester = driver.findElement(By.cssSelector("input[id='profession-1']"));
        BrowserUtils.click(automationTester);

        WebElement seleniumWebDr = driver.findElement(By.cssSelector("input[id='tool-2']"));
        BrowserUtils.click(seleniumWebDr);

        WebElement continents = driver.findElement(By.cssSelector("select[id='continents']"));
        BrowserUtils.selectBy(continents, "North America", "visibleText");

        WebElement seleniumCommands = driver.findElement(By.cssSelector("select[id='selenium_commands']"));
        BrowserUtils.selectBy(seleniumCommands, "WebElement Commands", "visibleText");


        WebElement uploadFile = driver.findElement(By.cssSelector("input[id='photo']"));
        BrowserUtils.sendKeys(uploadFile,"/Users/codefish/Desktop/B22HTML/breakingBad.jpeg");








    }



}
