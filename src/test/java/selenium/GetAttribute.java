package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.TestBase;

import javax.swing.*;
import java.util.List;

public class GetAttribute extends TestBase {

    @Test
    public void getAttributeShowCase(){
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");

        WebElement messageBox = driver.findElement(By.xpath("//textarea[@id='description']"));

        String classAttribute = messageBox.getAttribute("rows");
        System.out.println(classAttribute);

        if (classAttribute.contains("5")){
            messageBox.sendKeys("KUba kuba kUBA KUBA KuBa");
        }





    }

    @Test
    public void getAttributePractice() throws InterruptedException {

        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        WebElement button = driver.findElement(By.xpath("//button"));
        BrowserUtils.click(button);

        List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[@role='checkbox']"));

//        for (WebElement element :allCheckBoxes){
//            Thread.sleep(400);
//            if (element.getAttribute("aria-checked").equalsIgnoreCase("false")){
//                BrowserUtils.click(element);
//            }
//
//        }

        // either way will work
        for (int i = 0; i < allCheckBoxes.size(); i++) {

            WebElement element = allCheckBoxes.get(i);

            if (element.getAttribute("aria-checked").equalsIgnoreCase("false")){
                element.click();
            }

        }




    }





}
