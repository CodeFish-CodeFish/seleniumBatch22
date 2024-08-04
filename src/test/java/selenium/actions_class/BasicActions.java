package selenium.actions_class;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.TestBase;

public class BasicActions extends TestBase {

    @Test
    public void actionShowCase() {
        driver.get("https://the-internet.herokuapp.com/");
        Actions actions = new Actions(driver);
        actions.contextClick().perform();

        WebElement abTesting = driver.findElement(By.xpath("//a[contains(.,'A/B Testing')]"));
        actions.click(abTesting).perform();

    }

    @Test
    public void actionPractice(){

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        /*
       1. Navigate to webpage and do right-click on rightClick button
       2. Then click delete option
       3. Switch your driver to alert popup, get text from the popup and click ok
       4. Close your driver
         */

        WebElement rightClickMeButton = driver.findElement(By.xpath("//span[.='right click me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMeButton).perform();

        WebElement deleteOption = driver.findElement(By.xpath("//span[.='Delete']"));
        actions.click(deleteOption).perform();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement doubleClickBtn = driver.findElement(By.xpath("//button"));
        actions.doubleClick(doubleClickBtn).perform();

        System.out.println(alert.getText());

        alert.accept();


    }


}
