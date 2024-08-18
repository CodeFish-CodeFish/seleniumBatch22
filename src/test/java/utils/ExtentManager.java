package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    private static ExtentTest test;


    public static ExtentReports getInstance(){

        if (extent == null){
            extent = new ExtentReports();

            ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
            extent.attachReporter(reporter);
        }
        return extent;

    }

    public static ExtentTest createTest(String testName){

        test = extent.createTest(testName);
        return test;

    }

    public static void flush(){

        if (extent != null){
            extent.flush();
        }

    }



}
