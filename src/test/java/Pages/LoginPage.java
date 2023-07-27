package Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.CSS, using="#Email")
	public WebElement Email;
	
	@FindBy(how=How.CSS, using="#Password")
	public WebElement Pswd;
	
	@FindBy(how=How.XPATH, using="//button[text()='Log in']")
	public WebElement Login_btn;
	
	@FindBy(how=How.CSS, using=".content-header")
	public WebElement VerifySite;
	
	@FindBy(how=How.LINK_TEXT, using="Logout")
	public WebElement Logout_btn;
	
	@FindBy(how=How.XPATH, using="//h1[text()='Admin area demo']")
	public WebElement VerifyAdminArea;
	
	
	
	public void Login() {
		driver.navigate().to("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Email.clear();
		Email.sendKeys("admin@yurstore.com");
		Pswd.clear();
		Pswd.sendKeys("admin");
		Login_btn.click();
		Assert.isTrue(VerifySite.getText().contains("Dashboard"),"Site is not logged in");
		Logout_btn.click();
		Assert.isTrue((VerifyAdminArea.getText().contains("Admin area demo")), "Admin site is not loaded");
		
	}
	



	
	
		
}
	


