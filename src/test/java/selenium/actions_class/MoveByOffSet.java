package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.List;

public class MoveByOffSet extends TestBase {

    @Test
    public void moveByOffSetPractice(){

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(50, 0).build().perform();

    }

    @Test
    public void practiceMoveByOffSet(){
        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");

        List<WebElement> allSliders = driver.findElements(By.xpath("//input[@class='sp__range']"));

        Actions actions = new Actions(driver);
        for (int i = 0; i < allSliders.size(); i++) {

            actions.clickAndHold(allSliders.get(i)).moveByOffset(120, 0).build().perform();


        }

    }

    @Test
    public void moveByOffSetYX() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable1 = driver.findElement(By.xpath("//span[contains(.,'Draggable 1')]"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[contains(.,'Draggable 2')]"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable1).moveByOffset(90, 0).release().build().perform();
        actions.clickAndHold(draggable2).moveByOffset(90, 0).release().build().perform();

        Thread.sleep(3000);

        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));

        actions.clickAndHold(draggable).moveByOffset(500, -700).release().build().perform();



    }



}
