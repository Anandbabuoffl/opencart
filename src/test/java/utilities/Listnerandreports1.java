package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base.Baseline;

public class Listnerandreports1 extends Baseline implements ITestListener
{
ExtentReports extent;
ExtentTest test;
SimpleDateFormat format;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test is started "+ result.getName());
		test=extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is success");
		test.log( Status.PASS,""+result.getMethod().getMethodName()+ " is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is failed");
		test.log( Status.FAIL,""+result.getMethod().getMethodName()+ " is failed");
		test.log(Status.FAIL,result.getThrowable());
		
		format=new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date date=new Date();
		String actualtime=format.format(date);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/Screenshot "+ actualtime +" .png");
	    try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skipped");
			}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution started");
		
		format=new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
		Date date=new Date();
		String actualtime=format.format(date);
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/testreports "+ actualtime +" .html");
		extent=new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Host name", "Local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user name", "Anand");
		
		spark.config().setDocumentTitle("Opencart");
		spark.config().setReportName("Functional");
		spark.config().setTheme(Theme.DARK);
		
		
		}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution is completed");
		extent.flush();
	}



}
