package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import driver.DriverManager;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportListner implements ITestListener{

	 private static ExtentReports extent;
	    private static ExtentTest test;
	 
	    // Initialize the Extent Report
	    public void onStart(ITestContext context) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
	        htmlReporter.config().setDocumentTitle("Automation Report");
	        htmlReporter.config().setReportName("Selenium Test Report");
	        htmlReporter.config().setTheme(Theme.STANDARD);
	 
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }
	 
	    // Start a new test entry
	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }
	 
	    // Log pass status
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	    }
	 
	    // Log failure and attach screenshot
	    public void onTestFailure(ITestResult result) {
	        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
	        test.log(Status.FAIL, result.getThrowable());
	 
	        // Capture screenshot on failure
	        WebDriver driver = DriverManager.getDriver();
	       String screenshotPath = DriverManager.captureScreenshot(driver, result.getMethod().getMethodName());
	       // test.addScreenCaptureFromPath(screenshotPath);
	    }
	 
	    // Log skipped test
	    public void onTestSkipped(ITestResult result) {
	        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	    }
	 
	    // Generate report after tests
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }

}
