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

public class Tc_Activities_20_Generic_Test {

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

		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();

		driver.findElement(By.xpath("//a[.=' Expenses']")).click();
		driver.findElement(By.id("add_expenses")).click();

		HashMap<String, String> map = eLib.getList("Login_Tc_Login_01", 0, 1, 0);

		for (Entry<String, String> string : map.entrySet()) {
			driver.findElement(By.name(string.getKey())).sendKeys(string.getValue());
		}

		String expectedDetailName = eLib.readDataFromExcelFile("Login_Tc_Login_01", 0, 1);
		WebElement semDropDown = driver.findElement(By.name("sem"));
		wLib.selectValue(semDropDown, eLib.readDataFromExcelFile("Login_Tc_Login_01", 0, 8));
		driver.findElement(By.name("save_expenses")).click();

		String actualDetailName = driver.findElement(By.xpath("//th[text()='Detail']/../../..//td[text()='"+expectedDetailName+"']")).getText();
		if (expectedDetailName.equalsIgnoreCase(actualDetailName)) {
			System.out.println("The Detail is Created.");
			WebElement detailToDelete = driver.findElement(By.xpath("//td[.='"+expectedDetailName+"']/..//a[.=' Delete']"));
			detailToDelete.click();
			driver.findElement(By.xpath("//a[.=' Yes']")).click();
			String detailName="";
			try {
				detailName = detailToDelete.getText();
			} catch (Exception e) {
			}
			if (detailName.isBlank()) {
				System.out.println("The Detail/Expense : \""+expectedDetailName+"\" is Deleted.");
				driver.findElement(By.xpath("//a[.=' Options']")).click();
				driver.findElement(By.xpath("//a[.=' Logout']")).click();
				if(driver.getCurrentUrl().contains("logout")) {
					System.out.println("TestCase Pass : Logged out Successfully.");
				}else {
					System.out.println("Test Case Failed : Logout Unsuccessful.");
				}

			}else {
				System.out.println("The Detail/Expense is not Deleted.");
			}
		}
		driver.quit();
	}
}