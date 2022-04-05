package testcases;

import org.testng.annotations.Test;

import Base.Baseline;
import pageobjects.Searchproduct;

public class SearchTC3 extends Baseline {
	Searchproduct sp;
	
	@Test
	public void searchpro() {
		sp=new Searchproduct(driver);
		sp.sercpro("laptop");
		sp.sercclick();
	}
}
