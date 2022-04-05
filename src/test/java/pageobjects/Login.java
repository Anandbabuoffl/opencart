package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	@FindBy(linkText="Log in") WebElement login;
	@FindBy(id="Email") WebElement email;
	@FindBy(id="Password") WebElement pasword;
	@FindBy(xpath="//button[text()='Log in']") WebElement sumit;
	
	
	public Login(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clicklogin() {
		login.click();
	}
	public void getemail(String uemail) {
		email.sendKeys(uemail);
		
	}
	
	public void getpwd(String upwd) {
		pasword.sendKeys(upwd);
		
	}
	
	public void click() {
		sumit.click();
		
	}
}
