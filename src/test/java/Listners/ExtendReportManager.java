package Listners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageObjectModel.testngpom;

public class ExtendReportManager  implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	 public ExtentReports extent;
	 public ExtentTest test;
	 String repName;
	 public void onStart(ITestContext context) {
		 
		 sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/Hackathon Reports/myTestNGReports.html");
		 sparkReporter.config().setDocumentTitle("Automation Report");
		 sparkReporter.config().setReportName("Hackathon-Finding Hospital");
		 sparkReporter.config().setTheme(Theme.DARK);
		 extent=new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 extent.setSystemInfo("Computer Name","localhost");
		 extent.setSystemInfo("Environment","QEA");
		 extent.setSystemInfo("Tester Name","Sourabh");
		 extent.setSystemInfo("OS","Windows10");
		 extent.setSystemInfo("Browser name","Chrome");
	 }
	
	 
	 public void onTestSuccess(ITestResult result) {
		 test= extent.createTest(result.getName());
		 test.log(Status.PASS,"Test case PASSED is:"+result.getName());
		 String path = (System.getProperty("user.dir")+"/Screenshot/"+result.getName()+".png");
	        TakesScreenshot screenshot = (TakesScreenshot) testngpom.driver;
	        try {
				FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE), new File(path));
			} catch (WebDriverException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		    test.addScreenCaptureFromPath(path);
		    System.out.println("Screenshot Captured");
	 }
	 
	 public void onTestFailure(ITestResult result) {
		 test = extent.createTest(result.getName());
		 test.log(Status.FAIL,"Test case FAILED is:" +result.getName());
		 test.log(Status.FAIL,"Test case FAILED cause is: "+result.getThrowable());
		 
	 }
	 
	 public void onTestSkipped(ITestResult result) {
		 test= extent.createTest(result.getName());
		 test.log(Status.SKIP,"Test case SKIPPED is :" + result.getName());
	}
	 
	 public void onFinish(ITestContext context) {
		 extent.flush();
	 }

}



