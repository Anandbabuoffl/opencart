package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Base.Baseline;
import pageobjects.Login;

public class LoginTC2 extends Baseline{
	
	Login l;
	
	@Test
	public void login() {
		l=new Login(driver);
		log.info("app");
		log.fatal("click");
		log.info("logged in");
		l.clicklogin();
		l.getemail(username);
		l.getpwd(password);
		l.click();
		Baseline.takescreenshot("login");
		String actual=driver.getTitle();
		String expected="nopCommerce demo store";
		
		
	}

}