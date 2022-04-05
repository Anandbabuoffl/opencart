package Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Readconfig;

public class Baseline {
	public static WebDriver driver;
	public static Logger log;

	Readconfig rc = new Readconfig();
    
	public String regurl=rc.getresurl();
	public String loginurl = rc.getloginurl();
	public String username = rc.getuser();
	public String password = rc.getpassword();

	@Parameters({"Browser","url"})

	@BeforeSuite
	public void launchbrowser(String Browser,String url) throws InterruptedException {
		log= LogManager.getLogger(getClass());
		switch (Browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		Thread.sleep(5000);
		if(url.equals("reg"))
		{
			driver.get(regurl);
		}else  {
			driver.get(loginurl);
		}
		driver.manage().window().maximize();
		log.error("App home page");
	}
public static void takescreenshot(String stname) {
	SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
	Date date=new Date();
	String actualtime=sdf.format(date);
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest=new File("./Screenshoot "+stname+actualtime+".png");
    try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@AfterSuite
	public void teardown() {
		driver.quit();
	}
}
