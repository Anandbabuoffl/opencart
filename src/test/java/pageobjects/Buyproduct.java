package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Buyproduct {

	WebDriver driver;
	Select s;
	JavascriptExecutor js;

	public Buyproduct(WebDriver d) {
		driver=d;
		PageFactory.initElements(d,this);
	}
	// checkout
	@FindBy(xpath = "//button[@class='button-2 product-box-add-to-cart-button']")
	WebElement addcart;
	@FindBy(linkText = "Shopping cart")
	WebElement clickcart;
	@FindBy(id = "termsofservice")
	WebElement agreetc;
	@FindBy(id = "checkout")
	WebElement checkout;

	// billing address
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement ddcountry;
	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement ddstate;
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipcode;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phone;
	@FindBy(xpath = "//button[text()='Continue'][@onclick='Billing.save()']")
	WebElement contine1;

	// shipping method
	@FindBy(id = "shippingoption_1")
	WebElement shipair;
	@FindBy(xpath = "//button[text()='Continue'][@onclick='ShippingMethod.save()']")
	WebElement contine2;

	// payment method
	@FindBy(id = "paymentmethod_1")
	WebElement pay;
	@FindBy(xpath = "//button[text()='Continue'][@onclick='PaymentMethod.save()']")
	WebElement contine3;

	// payement info
	@FindBy(xpath = "//button[text()='Continue'][@onclick='PaymentInfo.save()']")
	WebElement contine4;

	// conform
	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement orderplace;

	// 1
	public void addcart() {
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,600)");
		addcart.click();
	}

	public void addshop() {
		js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].ScrollIntoView()",clickcart);
		clickcart.click();
	}

	public void agree() {
		agreetc.click();
	}

	public void checkout() {
		checkout.click();
	}

	// 2
	public void selectcountry(String visibletext) {
		s = new Select(ddcountry);
		s.deselectByVisibleText(visibletext);
	}

	public void selectsatate(String visibletext) {
		s = new Select(ddstate);
		s.deselectByVisibleText(visibletext);
	}

	public void city(String entercity) {
		city.sendKeys(entercity);
	}

	public void adress(String address1) {
		address.sendKeys(address1);
	}

	public void zipcode(String zip) {
		zipcode.sendKeys(zip);
	}

	public void phone(String ph) {
		phone.sendKeys(ph);
	}

	public void continead() {
		contine1.click();
	}
   //3
	public void shipmethod() {
		shipair.click();
	}
	public void contineship() {
		contine2.click();
	}
	//4
	public void paymethod() {
		pay.click();
	}
	public void continepay() {
		contine3.click();
	}
	//5
	public void info() {
		contine4.click();
	}
	//6
	public void conform() {
		orderplace.click();
	}
}
