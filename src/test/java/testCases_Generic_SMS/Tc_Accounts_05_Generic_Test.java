package testCases_Generic_SMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.FileUtility;
import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Accounts_05_Generic_Test {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib =  new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);
		
		String URL = fLib.readDatafromPropertyFile("url");	
		String USERNAME = fLib.readDatafromPropertyFile("username");
		String PASSWORD = fLib.readDatafromPropertyFile("password");
		
		driver.get(URL);
		
		int rn=jLib.getRandomNo();

		String userNAME = eLib.readDataFromExcelFile("Accounts_Tc_Accounts_01", 0, 1)+rn;
		String passWORD = eLib.readDataFromExcelFile("Accounts_Tc_Accounts_01", 1, 1);
		String name = eLib.readDataFromExcelFile("Accounts_Tc_Accounts_01", 2, 1);

		//Login Page
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();

		//Home Page ---> Navigating to the Administrator Page
		driver.findElement(By.xpath("//a[text()=' Accounts']")).click();
		driver.findElement(By.xpath("//a[text()=' Administrator']")).click();

		//Add Admin Page
		driver.findElement(By.id("add_admin")).click();	
		driver.findElement(By.name("username")).sendKeys(userNAME);
		driver.findElement(By.name("password")).sendKeys(passWORD);
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("save_admin")).click();
		
		WebElement sizeDropDowm = driver.findElement(By.xpath("//select[@name='table_length']"));
		wLib.selectValue(sizeDropDowm, "100");

		String expectedUserName=userNAME;
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(expectedUserName);
		
		String actualUserName = driver.findElement(By.xpath("//tbody//td[text()='"+expectedUserName+"']")).getText();
		if (expectedUserName.equals(actualUserName)) {
			System.out.println("The Username : "+expectedUserName+" details is valid and displayed.");
		}else {
			System.out.println("The Username : "+expectedUserName+" details is not present in the Module.");
		}
		//Logout
		driver.findElement(By.xpath("//a[text()=' Options']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		
		driver.quit();
	}
}
