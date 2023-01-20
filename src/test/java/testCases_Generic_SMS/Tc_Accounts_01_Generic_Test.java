package testCases_Generic_SMS;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.FileUtility;
import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Accounts_01_Generic_Test {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib =  new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		String URL = fLib.readDatafromPropertyFile("url");	
		String USERNAME = fLib.readDatafromPropertyFile("username");
		String PASSWORD = fLib.readDatafromPropertyFile("password");

		//Pre_Conditions [ Launch and Maximize the Browser]
		//Provide ImplicitlyWait for the findElement() and findElements() methods
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		wLib.maxWindow(driver);
		driver.get(URL);
		wLib.waitForPageLoad(driver);

		int rn = jLib.getRandomNo();

		//WebElement Identification
		WebElement usernameTextField = driver.findElement(By.id("username"));
		usernameTextField.sendKeys(USERNAME);
		WebElement passwordTextField = driver.findElement(By.id("password"));
		passwordTextField.sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();

		//Home Page and Accounts Module Actions
		driver.findElement(By.xpath("//a[text()=' Accounts']")).click();
		driver.findElement(By.xpath("//a[text()=' Administrator']")).click();
		driver.findElement(By.id("add_admin")).click();

		ArrayList<String> listArray = eLib.arrayList("Accounts_Tc_Accounts_01", 0);
		
		for(int i=0 ; i<=eLib.getLastRowNo("Accounts_Tc_Accounts_01") ; i++) {
			String value = eLib.readDataFromExcelFile("Accounts_Tc_Accounts_01", i, 1)+rn;
			driver.findElement(By.name(listArray.get(i))).sendKeys(value);
		}
		
		driver.findElement(By.name("save_admin")).click();

		String expectedUserName = eLib.readDataFromExcelFile("Accounts_Tc_Accounts_01", 0, 1)+rn;
		
		String actualUserName = driver.findElement(By.xpath("//td[.='"+expectedUserName+"']")).getText();

		if (expectedUserName.equals(actualUserName)) {
			System.out.println(expectedUserName+" has been Successfully added");
		} else {
			System.out.println(expectedUserName+" has not been added");
		}

		driver.findElement(By.xpath("//a[text()=' Options']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		System.out.println("Logged out of the Application Successfully");
		driver.quit();
	}
}
