package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v124.overlay.model.LineStyle;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Dropdowns {
    WebDriver driver;

    @BeforeMethod
    public void getStarted() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownShowCase() {
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropdownLink = driver.findElement(By.xpath("//a[.='Dropdown']"));
        dropdownLink.click();

        // Now we need to handle the dropdown itself

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select = new Select(dropdown);
        // select.selectByVisibleText("Option 2");
        //select.selectByValue("2");
        //select.selectByIndex(2);


        List<WebElement> selectOptions = select.getOptions();
        for (int i = 0; i < selectOptions.size(); i++) {

            if (selectOptions.get(i).getText().equals("Option 2")) {
                selectOptions.get(i).click();
            }

        }


    }

    @Test
    public void dropdownPractice() {

        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");

        /*
        1. Navigate to webpage
        2. Handle the dropdown by choosing Show All Rows
        3. Store lastName and email into Map
        4. Print out the map
         */

        WebElement dropdown = driver.findElement(By.xpath("//select[@id='maxRows']"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("Show ALL Rows");

        List<WebElement> allLastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, String> customerInfo = new HashMap<>();

        for (int i = 0; i < allLastNames.size(); i++) {

            customerInfo.put(allLastNames.get(i).getText(), allEmails.get(i).getText());

        }
        System.out.println(customerInfo);


//        Map<String, String> customerInfo = new HashMap<>();
//        for (int i = 0; i < driver.findElements(By.xpath("//tr//td[3]")).size(); i++) {
//
//            String singleLastName = driver.findElements(By.xpath("//tr//td[3]")).get(i).getText();
//            String singleEmail = driver.findElements(By.xpath("//tr//td[4]")).get(i).getText();
//
//            customerInfo.put(singleLastName, singleEmail);
//
//        }
//        System.out.println(customerInfo);


    }


    @Test
    public void practice() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        /*
        1. Navigate to Lambda webpage
        2. Fill out the input forms
        3. For the country dropdown choose your country with Select getOptions method by looping through each option
        if option has your country click on it
        4. Submit the form
        5. Validate the success message at the end
         */

        WebElement name = driver.findElement(By.id("name"));
        BrowserUtils.sendKeys(name, "Kobe Abdy");

        WebElement email = driver.findElement(By.xpath("//input[@id='inputEmail4']"));
        BrowserUtils.sendKeys(email, "test@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword4']"));
        password.sendKeys("123456789");

        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("IBM");

        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("www.ibm.com");

        // Country will be dealt here
        Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));

        for (int i = 0; i < select.getOptions().size(); i++) {

            if (select.getOptions().get(i).getText().equalsIgnoreCase("united kingdom")) {
                select.getOptions().get(i).click();
                break;
            }

        }


        Thread.sleep(3000);
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Chitown");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("1234 test st");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("4321 test avenue");

        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("IL");

        WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCode.sendKeys("60656");


        WebElement submitBtn = driver.findElement(By.xpath("//button[.='Submit']"));
        submitBtn.click();

        WebElement successMessage = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));

        String actualMessage = successMessage.getText();
        String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";

        Assert.assertEquals(actualMessage, expectedMessage, "Failed to validate success message on the submit page");
    }

    @Test
    public void bookFlight() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        // clicking One Way Radio button
        WebElement radioButtonOneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        radioButtonOneWay.click();

        // select passenger number
        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passenger, "3", "index");

        // select departing city
        WebElement departingCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
        BrowserUtils.selectBy(departingCity, "Zurich", "visibleText");

        // select departing on month
        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonth, "9", "byValue");

        // select departing day
        WebElement departingDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(departingDay, "21", "visibleText");

        // select arriving city
        WebElement arriveCity = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arriveCity, "Sydney", "visibleText");

        // select returning month
        WebElement returnMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(returnMonth, "11", "index");

        // select returning day
        WebElement returnDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(returnDay, "25", "byValue");

        // click on First Class radio button
        WebElement firstClassRadioButton = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassRadioButton.click();

        // loop through select options and select unified airlines with getOptions method from select class
        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));

        // getting all options from the dropdown, and looping through them. Also, declaring if condition to check if my desired option is available, if true it clicks on it
        List<WebElement> options = BrowserUtils.getAllSelectOptions(airlines);
        BrowserUtils.selectOptionFromAllOptions(options, "Unified Airlines");

        Thread.sleep(3000);


        // click on continue button
        WebElement continueBtn = driver.findElement(By.name("findFlights"));
        BrowserUtils.click(continueBtn);


        // Validate the message on submitted page
        WebElement message = driver.findElement(By.xpath("//b//font[@size='4']"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "After flight finder - No Seats Avaialble";
        System.out.println(BrowserUtils.getText(message));
        Assert.assertEquals(expectedMessage, actualMessage, "Failed to validate message on submitted page");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(4000);
        driver.quit();
    }


}
