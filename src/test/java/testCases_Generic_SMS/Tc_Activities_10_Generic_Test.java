package testCases_Generic_SMS;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.FileUtility;
import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Activities_10_Generic_Test {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib =  new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);
		
		String URL=fLib.readDatafromPropertyFile("url");
		String USERNAME=fLib.readDatafromPropertyFile("username");
		String PASSWORD=fLib.readDatafromPropertyFile("password");
		
		driver.get(URL);
		
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();
		
		driver.findElement(By.xpath("//a[.=' Activities']")).click();
		driver.findElement(By.id("add_activity")).click();
		
		HashMap<String, String> hashmaplist = eLib.getList("Activities_Tc_Activities_10", 0, 1, 0);
		
		int rn=jLib.getRandomNo();
		for (Entry<String, String> entry : hashmaplist.entrySet()) {
			if (entry.getKey().equals("title")) {
				driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue()+rn);
			}else {
				driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
			}
		}
		driver.findElement(By.name("save_activity")).click();
		
		driver.findElement(By.xpath("//a[.=' Options']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		
		driver.quit();
	}

}
