package testcases;

import org.testng.annotations.Test;

import Base.Baseline;
import pageobjects.Registrationpage;

public class RegTC1 extends Baseline {

	/*
	 * public static void main(String[] args) {
	 * 
	 * WebDriverManager.firefoxdriver().setup();
	 * 
	 * driver=new FirefoxDriver();
	 * driver.get("https://demo.opencart.com/index.php?route=account/register");
	 */
	
		Registrationpage reg;

	
	@Test
	public void reg() {
		reg = new Registrationpage(driver);
		reg.setfname("anand");
		reg.setlname("babu");
		reg.setemail("des@gmail.com");
		reg.setph("9273787664");
		reg.setpwd("1234");
		reg.setconph("1234");
		reg.checkprivary();
		reg.sumit();

	}

}
