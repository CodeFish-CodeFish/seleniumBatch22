package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.TestBase;

public class ClickAndHold extends TestBase {


    @Test
    public void clickAndHoldPractice(){

        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropzone = driver.findElement(By.xpath("//div[@id='draggable']//following-sibling::div"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable).moveToElement(dropzone).release().build().perform();





    }

    @Test
    public void clickAndHoldTask() throws InterruptedException {
        driver.get("https://demoqa.com/droppable");
        WebElement acceptTab = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptTab.click();

        WebElement draggable = driver.findElement(By.cssSelector("#acceptable"));
        WebElement dropzone = driver.findElement(By.xpath("//div[@id='acceptable']//..//following-sibling::div[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(dropzone).release().build().perform();
        Thread.sleep(3000);
        String backgroundColor = dropzone.getCssValue("font-family");
        System.out.println(backgroundColor);






    }


}
