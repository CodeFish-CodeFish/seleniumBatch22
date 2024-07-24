package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumBasics {

    // Important NOTE:

    //

    @Test
    public void TC_01() {

        WebDriver driver = new ChromeDriver();

        String googleURL = "https://www.google.com/";

        driver.get(googleURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        // Validating google's title
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("title was different, failed");
        }

    }


    // Task, create another test case - navigate to ebay, validate its title
    // Electronics, Cars, Fashion, Collectibles & More | eBay

    @Test
    public void TC_02(){

        // This was a task
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualTitle = driver.getTitle();
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }

    }

    @Test
    public void TC_03(){
        WebDriver driver = new SafariDriver();

        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.google.com/";

        if (actualURL.equals(expectedURL)){
            System.out.println("Google url validated successfully");
        }else {
            System.out.println("Google url validation failed");
        }


        driver.navigate().to("https://www.youtube.com/");
        String youtubeTitle = driver.getTitle();
        System.out.println(youtubeTitle);

        driver.get("https://www.facebook.com/");

        String faceBookTitle = driver.getTitle();
        System.out.println(faceBookTitle);

        driver.manage().window().minimize();
        driver.manage().window().maximize();

        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();

    }






}
