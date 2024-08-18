package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BrowserUtils {


    //all methods are static

    // WebElement element = driver.findElement();
    // element.getText();
    // Thank you
    public static String getText(WebElement element) {

        return element.getText().trim();

    }

    public static String getText(WebElement element, WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();

    }


    //clears input filed and enters data into the input field
    public static void sendKeys(WebElement element, String keys) {

        element.clear();
        element.sendKeys(keys);

    }

    public static void sendKeys(WebElement element, WebDriver driver, String key) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(key);
        } catch (ElementNotInteractableException | NoSuchElementException e) {
            System.err.println("Exception occurred while sending keys attempting fluentWait " + e.getMessage());

        }


    }


    // reusable method to handle dropdowns
    public static void selectBy(WebElement element, String option, String methodName) {

        Select select = new Select(element);

        switch (methodName) {

            case "visibleText":
                select.selectByVisibleText(option);
                break;
            case "byValue":
                select.selectByValue(option);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(option));
                break;
            default:
                System.out.println("Please check your method name, the method you chose is not available");
                break;

        }


    }

    public static String firstSelectOption(WebElement element){

        Select select = new Select(element);
        return select.getFirstSelectedOption().getText().trim();

    }


    // returns list of webElement from select. It retrieves all the options from the dropdown
    public static List<WebElement> getAllSelectOptions(WebElement element) {

        Select select = new Select(element);
        return select.getOptions();

    }


    // Polymorphism
    public static void selectOptionFromAllOptions(WebElement element, String option) {

        Select select = new Select(element);
        for (WebElement e : select.getOptions()) {

            if (BrowserUtils.getText(e).equalsIgnoreCase(option)) {
                e.click();
                break;
            }

        }

    }

    public static void selectOptionFromAllOptions(List<WebElement> elementList, String option) {

        for (WebElement e : elementList) {

            if (BrowserUtils.getText(e).equalsIgnoreCase(option)) {
                e.click();
                break;
            }

        }

    }

    public static void click(WebElement element) {

        element.click();

    }

    public static void click(WebElement element, WebDriver driver){
//TimeoutException
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()",element);
        }catch (TimeoutException | ElementNotInteractableException e){

            System.err.println("JavaScript method did not work on click " + e.getMessage());

        }

    }

    public static void switch2Windows(WebDriver driver) {

        String currentID = driver.getWindowHandle();
        Set<String> allIds = driver.getWindowHandles();

        for (String id : allIds) {

            if (!id.equals(currentID)) {
                driver.switchTo().window(id);
                break;
            }

        }

    }

    public static void switchWindowWithTitle(WebDriver driver, String title) {

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }

    }


    public static void switchWindowWithURL(WebDriver driver, String url) {

        Set<String> ids = driver.getWindowHandles();

        for (String id : ids) {
            driver.switchTo().window(id);
            if (driver.getCurrentUrl().contains(url)) {
                break;
            }
        }

    }

    public static void moveToElementWithActions(WebDriver driver, WebElement element) {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }

    public static void scrollWithPoint(WebElement element, WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();
        js.executeScript("window.scrollTo(" + x + ", " + y + ")");

    }


}
