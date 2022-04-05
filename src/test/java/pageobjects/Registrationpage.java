package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registrationpage {

	WebDriver driver;
	
	
	@FindBy(id="input-firstname") WebElement firstname;
	@FindBy(id="input-lastname") WebElement lastname;
	@FindBy(id="input-email") WebElement email;
	@FindBy(id="input-telephone") WebElement phnumber;
	@FindBy(id="input-password") WebElement pwd;
	@FindBy(id="input-confirm") WebElement conpwd;
	@FindBy(name="agree") WebElement privacy;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]") WebElement click;
	
     public Registrationpage(WebDriver d)
     {
    	 driver=d;
    	 PageFactory.initElements(d, this);
     }
     
     public void setfname(String fanme) {
    	 firstname.sendKeys(fanme);
     }
     
     public void setlname(String lanme) {
    	 lastname.sendKeys(lanme);
     }
     
     public void setemail(String cemail) {
    	 email.sendKeys(cemail);
     }
     
     public void setph(String ph) {
    	 phnumber.sendKeys(ph);
     }
     
     public void setpwd(String pw) {
    	 pwd.sendKeys(pw);
     }
     
     public void setconph(String cpw) {
    	 conpwd.sendKeys(cpw);
     }
     
     public void checkprivary() {
    	 privacy.click();
     }
     
     public void sumit() {
    	 click.click();
     }
}
