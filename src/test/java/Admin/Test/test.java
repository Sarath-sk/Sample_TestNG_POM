package Admin.Test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Pages.LoginPage;

public class test {
	
	WebDriver driver;
	LoginPage lp;
	ExtentReports extent;
	ExtentSparkReporter spark;
	//File DesFile;
	
	public test() {
		driver = new EdgeDriver();
		lp=new LoginPage(driver);
		
	}
	@BeforeClass
	public void report() {
		extent = new ExtentReports();
		 spark = new ExtentSparkReporter("C:\\Users\\Sarath\\eclipse-workspace\\Sample_TestNG\\Reports\\report.html");
		extent.attachReporter(spark);
	}
	public void TestcaseIfPassed(String title, String message) {
		
		ExtentTest test = this.extent.createTest(title);
		test.pass(message);
	}
	
	public void TestcaseIfFailed(String title, String message, Exception e) {
		ExtentTest test = this.extent.createTest(title);
		test.fail(message + e.getMessage());
		//this.Screenshot(driver, title);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		this.extent.flush();
	}
	
	/*
	 * public void Screenshot(WebDriver driver, String FilePath)throws Exception {
	 * TakesScreenshot scrshot = ((TakesScreenshot)driver); File
	 * SrcFile=scrshot.getScreenshotAs(OutputType.FILE); String DesFilePath =
	 * System.getProperty("user.dir")+"\\Screenshots"+getName()+ DesFile= new
	 * File("C:\\Users\\Sarath\\eclipse-workspace\\Sample_TestNG\\ScreenShots");
	 * FileHandler.copy(SrcFile, DesFile); }
	 */
	
	
	
	
	@Test
	public void SiteLogin() {
		//lp.Login();
		
		 try { 
			 lp.Login(); 
			 this.TestcaseIfPassed("SiteLogin", "Site got logged in successfully!!");
			 } 
		 catch(Exception e){
			 System.out.println("LoginPage is not accessible..!!" + e.getMessage()); 
			 this.TestcaseIfFailed("SiteLogin", "Site login is not successfull!!", e);
			 //this.TestcaseIfFailed(driver, DesFile, e);
			 
			 throw(e);
			 //this.Screenshot();
		 	}
		 finally {
			 
			 driver.close(); 
			 }
		 
	}
	

}
