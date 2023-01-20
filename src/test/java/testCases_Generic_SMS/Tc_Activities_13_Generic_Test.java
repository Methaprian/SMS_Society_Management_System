package testCases_Generic_SMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.FileUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Activities_13_Generic_Test {

	public static void main(String[] args) throws Throwable {

		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);

		String URL=fLib.readDatafromPropertyFile("url");
		String USERNAME = fLib.readDatafromPropertyFile("username");
		String PASSWORD = fLib.readDatafromPropertyFile("password");

		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();

		WebElement activitiesLink = driver.findElement(By.xpath("//a[.=' Activities']"));
		wLib.clickOnEle(activitiesLink);

		String toSearch = eLib.readDataFromExcelFile("Activities_Tc_Activities_13", 0, 1);
		driver.findElement(By.xpath("//label[.='Search:']//input[@type='search']")).sendKeys(toSearch);

		try {
			WebElement searchedTitle = driver.findElement(By.xpath("//td[.='"+toSearch+"']"));
			if (searchedTitle.isDisplayed()) {
				driver.findElement(By.xpath("//td[.='"+toSearch+"']/..//a[.=' Delete']")).click();
				driver.findElement(By.xpath("//a[.=' Yes']")).click();
				System.out.println("Test Case Pass: Title Deleted");
			} 
		}catch (Exception e) {
			WebElement noRecordMsg = driver.findElement(By.xpath("//td[.='No matching records found']"));
			if(noRecordMsg.isDisplayed()){
				System.out.println("Test Case Fail: "+noRecordMsg.getText());
			}
		}
		driver.findElement(By.xpath("//a[.=' Options']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();

		driver.quit();
	}
}