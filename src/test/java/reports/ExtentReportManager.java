package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	  private static ExtentReports extent;
	    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
	    private static ExtentTest test;
	    public static ExtentReports getInstance() {
	        if (extent == null) {
	            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
	            htmlReporter.config().setTheme(Theme.STANDARD);
	            htmlReporter.config().setDocumentTitle("Test Report");
	            htmlReporter.config().setReportName("Automation Test Results");
	 
	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);
	        }
	        return extent;
	    }
	 
	    public static void createTest(String testName) {
	        test = extent.createTest(testName);
	        testThread.set(test);
	    }
	 
	    public static ExtentTest getTest() {
	        return testThread.get();
	    }
	 
	    public static void flushReport() {
	        if (extent != null) {
	            extent.flush();
	        }
	    }
	    
	    public static void testReport(Status status,String msg)
	    {
	    	test.log(status,msg);
	    	
	    }
}
