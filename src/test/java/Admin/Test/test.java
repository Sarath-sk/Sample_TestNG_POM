package Admin.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class test {
	
	WebDriver driver;
	LoginPage lp;
	
	public test() {
		driver = new EdgeDriver();
		lp=new LoginPage(driver);
		
	}
	
	@Test
	public void SiteLogin() {
		try {
			lp.Login();
		}
		catch(Exception e){
			System.out.println("LoginPage is not accessible..!!" + e.getMessage());
		}
		finally {
			driver.close();
		}
	}
	

}
