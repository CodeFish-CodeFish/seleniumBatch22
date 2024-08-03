package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

import java.util.List;

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
        BrowserUtils.sendKeys(firstName, "Kobe");

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
        BrowserUtils.sendKeys(uploadFile, "/Users/codefish/Desktop/B22HTML/breakingBad.jpeg");


    }

    @Test
    public void createAccount() throws InterruptedException {

        /*

        1. Navigate to this webpage --> https://tutorialsninja.com/demo/index.php?route=account/register
        2. Fill out the form NOTE: each automation run needs unique test email
        3. Radio button, click yes only if the text is 'Yes'
        4. Validate congratulation message on submitted page



         */


        // Congratulations! Your new account has been successfully created!

        ////p[contains(.,'Congratulations')]

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");


        WebElement firstName = driver.findElement(By.cssSelector("#input-firstname")); //storing in a webelement
        firstName.sendKeys("Kuba");


        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Test");// not storing in a webElement


       WebElement email = driver.findElement(By.cssSelector("#input-email"));
       email.sendKeys("ggg@ggg.com");

       WebElement tel = driver.findElement(By.xpath("//input[@id='input-telephone']"));
       BrowserUtils.sendKeys(tel, "3124343434343");


       WebElement password = driver.findElement(By.cssSelector("input[id='input-password']"));
       password.sendKeys("23232132423");

       WebElement passwordConfirm = driver.findElement(By.cssSelector("input[id='input-confirm']"));
       BrowserUtils.sendKeys(passwordConfirm, "23232132423");

        List<WebElement> radioButtons = driver.findElements(By.xpath("//label[@class='radio-inline']"));

        for (int i = 0; i < radioButtons.size(); i++) {

            if (BrowserUtils.getText(radioButtons.get(i)).equalsIgnoreCase("yes")){

                BrowserUtils.click(radioButtons.get(i));

            }

        }

        Thread.sleep(3000);
        WebElement agreeCheckBox = driver.findElement(By.xpath("//input[@name='agree']"));
        BrowserUtils.click(agreeCheckBox);

        WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
        BrowserUtils.click(continueBtn);

        WebElement successMessage = driver.findElement(By.xpath("//p[contains(.,'Congratulations')]"));

        String actualMessage = BrowserUtils.getText(successMessage);
        String expectedMessage ="Congratulations! Your new account has been successfully created!";

        Assert.assertEquals(actualMessage, expectedMessage, "Failed to validate success message");

    }

    @Test
    public void testDiary() throws InterruptedException {
        /*

        1. Navigate to test diary webpage
        2. Uncheck Rest API by leveraging isSelected method and click
        3. Check Selenium by using isSelected method and click
        4. Select Java
        5. Click on Hyperlinks 'Test Diary' and get the text and navigate back to main page
        6. Click on 'Test Diary Selenium learning' get the text and navigate back to main page
        7. Dropdowns, select both yellow
        8. Finally, fill out contact form and click send button
         */
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");

        WebElement restApiBox = driver.findElement(By.cssSelector("input[id='restapibox']"));
        if (restApiBox.isSelected()){
            restApiBox.click();
        }


        WebElement seleniumBox = driver.findElement(By.cssSelector("#seleniumbox"));
        if (!seleniumBox.isSelected()){
            seleniumBox.click();
        }


        WebElement javaRadio = driver.findElement(By.cssSelector("#java1"));
        javaRadio.click();

        WebElement testDiaryLink = driver.findElement(By.linkText("Test Diary"));
        testDiaryLink.click();

        WebElement testDiaryText = driver.findElement(By.xpath("//h1"));
        System.out.println(BrowserUtils.getText(testDiaryText));

        driver.navigate().back();

        WebElement seleniumLearning = driver.findElement(By.partialLinkText("Selenium Learning"));
        seleniumLearning.click();

        WebElement seleniumText = driver.findElement(By.xpath("//h1"));
        System.out.println(BrowserUtils.getText(seleniumText));

        driver.navigate().back();

        WebElement shirtDropdown = driver.findElement(By.cssSelector("#Shirts"));
        BrowserUtils.selectBy(shirtDropdown, "Yellow Shirt", "visibleText");


        WebElement skirtDropdown = driver.findElement(By.cssSelector("#Skirts"));
        BrowserUtils.selectBy(skirtDropdown, "Yellow Skirt", "visibleText");

        WebElement nameField = driver.findElement(By.xpath("//input[@name='your-name']"));
        BrowserUtils.sendKeys(nameField, "kobe abdy");

        WebElement emailField = driver.findElement(By.xpath("//input[@name='your-email']"));
        BrowserUtils.sendKeys(emailField, "email@test.com");

        WebElement subjectField = driver.findElement(By.cssSelector("input[name='your-subject']"));
        BrowserUtils.sendKeys(subjectField, "Subject of the message");

        WebElement messageBox = driver.findElement(By.cssSelector("textarea[name='your-message']"));
        BrowserUtils.sendKeys(messageBox, "Please review my code");

        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        BrowserUtils.click(submitBtn);















    }


}
