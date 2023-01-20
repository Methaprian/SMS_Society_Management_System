package com.SM.SocialManagementSystem.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.SM.SocialManagementSystem.ObjectPage.HomePage;
import com.SM.SocialManagementSystem.ObjectPage.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver edriver;
	public DataBaseUtility dLib = new DataBaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	@BeforeSuite	//(groups = {"smoke","regression"})
	public void configBS() throws Throwable {
		dLib.connectToDatabase();
		System.out.println("Database Conncetion Successful");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass	//(groups = {"smoke","regression"})
	public void configBC() throws Throwable {     //String BROWSER
		wLib.launchBrowser(driver);
		String BROWSER = fLib.readDatafromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser : Check for the Browser");
		}
		edriver=driver;
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);
		System.out.println("Browser Launched Successfully");
	}
	
	@BeforeMethod	//(groups = {"smoke","regression"})
	public void configBM() throws Throwable {
		String URL = fLib.readDatafromPropertyFile("url");
		driver.get(URL);
		LoginPage logPage = new LoginPage(driver);
		String USERNAME = fLib.readDatafromPropertyFile("username");
		String PASSWORD = fLib.readDatafromPropertyFile("password");
		logPage.Login(fLib, USERNAME, PASSWORD);
		System.out.println("Login Successfull");
	}
	
	@AfterMethod	//(groups = {"smoke","regression"})
	public void configAM() {
		HomePage home = new HomePage(driver);
		home.logOut();
		System.out.println("Logged Out Successfully");
	}
	
	@AfterClass	//(groups = {"smoke","regression"})
	public void configAC() {
		wLib.quitBrowser(driver);
		System.out.println("Browser Terminated Successfully");
	}
	
	@AfterSuite	//(groups = {"smoke","regression"})
	public void configAS() throws Throwable {
		dLib.closeDB();
		System.out.println("Database Disconnected Successfully");
	}

}
