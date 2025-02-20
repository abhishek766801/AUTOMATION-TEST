package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import driver.DriverManager;
import reports.ExtentReportManager;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportListner implements ITestListener{

	 private static ExtentReports extent;
	    private static ExtentTest test;
	 
	    @Override
	    public void onStart(ITestContext context) {
	        ExtentReportManager.getInstance();
	    }
	 
	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentReportManager.createTest(result.getMethod().getMethodName());
	    }
	 
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        ExtentReportManager.getTest().log(Status.PASS, "Test Passed");
	    }
	 
	    @Override
	    public void onTestFailure(ITestResult result) {
	        ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
	        WebDriver driver = DriverManager.getDriver();
		       String screenshotPath = DriverManager.captureScreenshot(driver, result.getMethod().getMethodName());
		      
	    }
	 
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped");
	    }
	 
	    @Override
	    public void onFinish(ITestContext context) {
	        ExtentReportManager.flushReport();
	    
	    }
	 
	    // Log failure and attach 

}
