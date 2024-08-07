package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoverOver extends TestBase {

    @Test
    public void hoverOverPractice() throws InterruptedException {

        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allImages = driver.findElements(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        List<WebElement> userNamesWebElement = driver.findElements(By.xpath("//h5"));

        List<String> userNames = new ArrayList<>();
        Actions actions = new Actions(driver);

        for (int i = 0; i < allImages.size(); i++) {

            Thread.sleep(400);
            //WebElement element = allImages.get(i);
            actions.moveToElement(allImages.get(i)).build().perform();


            //String user = userNamesWebElement.get(i).getText();
            userNames.add(userNamesWebElement.get(i).getText());


        }

        System.out.println("Actual usernames from web app" + userNames);


    }


    @Test
    public void menuTask() throws InterruptedException {

        /*
        navigate to webpage
        hover over each item
        get the price and name of the product
        store product and price in Map interface
        product as a key and price as a value

         */

        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> productNames = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product-description']//p"));

        Actions actions = new Actions(driver);

        Map<String, String> productInfo = new HashMap<>();

        for (int i = 0; i < allImages.size(); i++) {

            Thread.sleep(300);
            // mouse hover over to each element on the webpage
            actions.moveToElement(allImages.get(i)).build().perform();


            //storing product and price into Map by replacing dollar sign
            String singleProduct = productNames.get(i).getText();
            String price = prices.get(i).getText().replace("$", "");
            productInfo.put(singleProduct, price);


        }
        System.out.println(productInfo);


    }

}
