package selenium;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class LocatorsIntro {


    @Test
    public void interactWithWebElement() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement searchBar = driver.findElement(By.id("APjFqb"));
//        searchBar.sendKeys("iPhone");

//        WebElement searchBar = driver.findElement(By.name("q"));
//        searchBar.sendKeys("Breaking Bad");

        WebElement searchBar = driver.findElement(By.tagName("textarea"));
        searchBar.sendKeys("Prison Break");


        // So far we got, id, name, tagName
        // next -> className, linkText, and partialLinkText

        driver.get("https://the-internet.herokuapp.com/abtest");


        WebElement text = driver.findElement(By.className("example"));
        String textFromWebPage = text.getText(); // getText() method is from WebElement interface

        String s = textFromWebPage.toUpperCase();
        System.out.println(s);

//        WebElement linkText = driver.findElement(By.linkText("Elemental Selenium"));
//        linkText.click();

        WebElement partialLinkText = driver.findElement(By.partialLinkText("Elemental"));
        partialLinkText.click();

        // basic selenium locators = id, tagName, className, name, linkText, and partialLinkText

        driver.quit();
    }


    @Test
    public void task() throws InterruptedException {

        //
        WebDriver driver = new ChromeDriver();
        String surveyURL = "file:///Users/codefish/Desktop/B22HTML/codefishSurvey.html";
        driver.get(surveyURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // sendKeys into text area, and print out the title of the webpage

        Thread.sleep(2000); // this does not belong to Selenium, this class belongs to Java, and not RECOMMENDED TO USE IN REAL WORLD!!!!
        WebElement textarea = driver.findElement(By.name("comment"));
        textarea.sendKeys("Leaving a comment for the survey");

        System.out.println(driver.getTitle());

        Thread.sleep(2000);

         driver.quit(); // all window tabs will shut down
        //driver.close(); // only the current view

        // after

        // captcha - anti robot tool that cannot be automated


    }


    @Test
    public void getTExtFromWeb(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement text1 = driver.findElement(By.tagName("h1")); // NoSuchElementException
        String text = text1.getText();
        String[] s = text.split(" ");
        System.out.println(Arrays.toString(s));

        WebElement text2 = driver.findElement(By.tagName("h2"));
        String str = text2.getText();
        String[] s1 = str.split(" ");
        System.out.println(Arrays.toString(s1));
        driver.quit();

        //xpath
    }




}
