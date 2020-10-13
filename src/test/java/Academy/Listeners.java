package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;
import resources.base;
import java.io.IOException;

public class Listeners extends base implements ITestListener {
    ExtentTest test;
    ExtentReports extent=ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>(); // create an object for ThreadLocal class
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();
    }

    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
       test=extent.createTest(result.getMethod().getMethodName()); // creating test so extent object is aware there is one testcase which is being executed
        extentTest.set(test); //add test object into ThreadLocal pool
    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
       extentTest.get().log(Status.PASS,"Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        extentTest.get().fail(result.getThrowable());
        WebDriver driver = null;
        String testMethodName = result.getMethod().getMethodName();
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {

        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }





    }
