package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	
	public Readconfig()  {
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream des = new FileInputStream(src);
			pro=new Properties();
			pro.load(des);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getresurl() {
		String urlreg=pro.getProperty("Appurlreg");
		return urlreg;
	}
	
	public String getloginurl() {
		String urllogin=pro.getProperty("Appurllogin");
		return urllogin;
	}
	
	public String getuser() {
		String username=pro.getProperty("Email");
		return username;
	}
	
	public String getpassword() {
		String password=pro.getProperty("Password");
		return password;
	}
	
}
