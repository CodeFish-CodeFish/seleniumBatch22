package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.time.Duration;

public class TestBase {

    public ExtentReports extent;

    public ExtentTest test;

    public WebDriver driver;

    @BeforeTest
    public void startTest(){
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void initializeDriver(Method method) {

        test = extent.createTest(method.getName());
        driver = DriverHelper.getDriver();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {

        if (result.getStatus() == ITestResult.FAILURE){
            String base = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
            test.addScreenCaptureFromBase64String(base,"Screenshot last page");
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String base = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
            test.addScreenCaptureFromBase64String(base, "Screenshot last page");
            test.pass("Test case has passed");
        }

        Thread.sleep(4000);
        driver.quit();
    }

    @AfterTest
    public void exitTest(){

        if (extent != null){
            extent.flush();
        }

    }


}
