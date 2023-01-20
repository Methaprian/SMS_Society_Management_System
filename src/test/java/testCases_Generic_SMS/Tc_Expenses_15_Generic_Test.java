package testCases_Generic_SMS;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.FileUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Expenses_15_Generic_Test {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib =  new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);

		String URL = fLib.readDatafromPropertyFile("url");	
		String USERNAME = fLib.readDatafromPropertyFile("username");
		String PASSWORD = fLib.readDatafromPropertyFile("password");

		String eDetail=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 0, 1);
		String ePrice = eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 1, 1);
		String eSem=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 0, 7);
		
		driver.get(URL);

		//Login Page
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();
		
		String DetailName=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 0, 1);

		driver.findElement(By.xpath("//a[text()=' Expenses']")).click();
		driver.findElement(By.xpath("//td[text()='"+DetailName+"']/..//a[text()=' Update']")).click();
		
		HashMap<String, String> HashMapList = eLib.getList("Accounts_Tc_Expenses_15", 0, 1, 0);

		for (Entry<String, String> string : HashMapList.entrySet()) {
			WebElement ele = driver.findElement(By.name(string.getKey()));
			ele.clear();
			ele.sendKeys(string.getValue());
		}

		WebElement semDropdown = driver.findElement(By.name("sem"));
		wLib.selectValue(semDropdown, eSem);
		
		driver.findElement(By.name("update_expenses")).click();

		String expectedPrice = ePrice;
		String actualPrice = driver.findElement(By.xpath("//td[.='"+eDetail+"']/..//td[.='"+ePrice+"']")).getText();

		driver.findElement(By.xpath("//a[text()=' Options']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();

		if (expectedPrice.equals(actualPrice)) {
			System.out.println("TestCase Pass : The Expenses has been updated.");
		} else {
			System.out.println("TestCase Fail : The Expenses has not been updated.");
		}
		driver.quit();
	}

}
