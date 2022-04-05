package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchproduct {
	
	WebDriver driver;

	@FindBy(id="small-searchterms") WebElement serach;
	@FindBy(linkText="Search") WebElement pclick;
	
	public Searchproduct(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	public void sercpro(String product) {
		serach.sendKeys(product);
	}
	
	public void sercclick() {
		 pclick.click();
	}
}
