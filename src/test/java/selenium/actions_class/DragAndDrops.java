package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

public class DragAndDrops extends TestBase {

    @Test
    public void dragAndDropPractice(){

        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");

        WebElement draggable1 = driver.findElement(By.xpath("//span[.='Draggable 1']"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[.='Draggable 2']"));
        WebElement dropArea = driver.findElement(By.cssSelector("#mydropzone"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable1, dropArea).build().perform();
        actions.dragAndDrop(draggable2, dropArea).build().perform();

        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropzone = driver.findElement(By.cssSelector("#droppable"));

        actions.dragAndDrop(draggable, dropzone).build().perform();

        WebElement droppedMessage = driver.findElement(By.xpath("//p[.='Dropped!']"));

        String actualMessage = droppedMessage.getText();
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage, expectedMessage, "Failed to validate dropped message");





    }

    @Test
    public void dragAndDropTask(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropArea = driver.findElement(By.cssSelector("div[class='test2']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropArea).build().perform();


        // reassigning to avoid StaleElementReferenceException
        dropArea = driver.findElement(By.cssSelector("div[class='test2']"));
        String actualMessage = dropArea.getText();
        String expectedMessage = "You did great!";

        Assert.assertEquals(actualMessage, expectedMessage);
    }




}
