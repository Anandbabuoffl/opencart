package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Baseline;
import pageobjects.Registrationpage;
import utilities.Excelreadwrite;

public class DatadrivenregTC3 extends Baseline{
	
	@Test(dataProvider="reg")
	public void reg(String fna,String lna,String eml,String phone,String ps,String cps) throws InterruptedException {
		Registrationpage regs=new Registrationpage(driver);
		regs.setfname(fna);
		regs.setlname(lna);
		regs.setemail(eml);
		regs.setph(phone);
		regs.setpwd(ps);
		regs.setconph(cps);
		regs.checkprivary();
		Thread.sleep(5000);
		regs.sumit();
		
		String ex=driver.getTitle();
		String ac="opencart1";
		Assert.assertEquals(ac, ex);
	}
	
	@DataProvider(name="reg")
	public Object[][] getdatafromexcel() throws IOException {
		Excelreadwrite es=new Excelreadwrite("./src/test/resources/Test1.xlsx");
		int rowcount=es.rowcount("Sheet0");
		int columncount=es.columncount("Sheet0", 0);
		
		Object reg[][]=new Object[rowcount][columncount];
		
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				 reg[i][j]=es.getcellvalue("Sheet0",i, j);
			}
			
		}
		return reg;
		
	}

}
