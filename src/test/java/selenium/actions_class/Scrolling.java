package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

public class Scrolling extends TestBase {

    @Test
    public void scrollToElementPractice() throws InterruptedException {

        driver.navigate().to("https://www.lambdatest.com/selenium-playground/hover-demo");

        //h2[.='Flashing']//following-sibling::div//img
        //div[@class='hover11 s__column']//img
        //div[@class='ml-15 mt-15 h-265']//img

        WebElement flashingImage = driver.findElement(By.xpath("//h2[.='Flashing']//following-sibling::div//img"));

        Actions actions = new Actions(driver);

        // scrolling to the element
        actions.scrollToElement(flashingImage).build().perform();
        //actions.scrollByAmount(0, 3000).build().perform();



        //Hover over
        BrowserUtils.moveToElementWithActions(driver, flashingImage);


    }

}
