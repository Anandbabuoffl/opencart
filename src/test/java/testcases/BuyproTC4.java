package testcases;

import org.testng.annotations.Test;

import Base.Baseline;
import pageobjects.Buyproduct;

public class BuyproTC4 extends Baseline{
	
	Buyproduct b;
	
	@Test(priority=1)
	public void check() throws InterruptedException {
		b=new Buyproduct(driver);
		Thread.sleep(3000);
		b.addcart();
		Thread.sleep(3000);
		b.addshop();
		b.agree();
		b.checkout();
	}

	@Test(priority=2)
	public void billingaddress() {
		b=new Buyproduct(driver);
		b.selectcountry("Unitedstates");
		b.selectsatate("washington");
		b.city("seattle");
		b.adress(" first street");
		b.zipcode("235623");
		b.phone("7827783132");
		b.continead();
	}
	
	@Test(priority=3)
	public void shipmethod() {
		b=new Buyproduct(driver);
		b.shipmethod();
		b.contineship();
	}
	
	@Test(priority=4)
	public void pay() {
		b=new Buyproduct(driver);
		b.paymethod();
		b.continepay();
	}
	
	@Test(priority=5)
	public void info() {
		b=new Buyproduct(driver);
		b.info();
	}
	
	@Test(priority=6)
	public void conformorder() {
		b=new Buyproduct(driver);
		b.conform();
	}
}
