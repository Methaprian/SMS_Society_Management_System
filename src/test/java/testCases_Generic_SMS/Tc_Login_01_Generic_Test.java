package testCases_Generic_SMS;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.FileUtility;
import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Login_01_Generic_Test {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib =  new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);

		String URL = fLib.readDatafromPropertyFile("url");
		String USERNAME = fLib.readDatafromPropertyFile("username");
		String PASSWORD = fLib.readDatafromPropertyFile("password");

		int rn=jlib.getRandomNo();

		String eSTUDENTID = eLib.readDataFromExcelFile("Login_Tc_Login_01", 0, 1)+rn;
		String eYEAR = eLib.readDataFromExcelFile("Login_Tc_Login_01", 5, 1);

		//Pass the URL of the Application
		driver.get(URL);
		//Enter the Username
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		//Enter the Password
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		//Click on Login
		driver.findElement(By.id("login")).click();
		//Click on Accounts Link
		driver.findElement(By.xpath("//a[text()=' Accounts']")).click();
		//Click on Student Sub-Link
		driver.findElement(By.xpath("//a[text()=' Student']")).click();
		//Click on Add Student Button
		driver.findElement(By.id("add_student")).click();

		driver.findElement(By.name("student_id")).sendKeys(eSTUDENTID);

		HashMap<String, String> map = eLib.getList("Login_Tc_Login_01", 0, 1, 1);

		for(Entry<String, String> set: map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}

		//Select from Dropdown
		WebElement yearDropDown = driver.findElement(By.name("year"));

		wLib.selectVisText(eYEAR, yearDropDown);
		//Click on Save Button
		driver.findElement(By.name("save_student")).click();

		//Click on Transactions link
		driver.findElement(By.xpath("//a[text()=' Transaction']")).click();

		//Enter the Student ID in the Search Box
		driver.findElement(By.id("search")).sendKeys(eSTUDENTID);
		//click on Search Button
		driver.findElement(By.id("btn_search")).click();

		String expectedStudentID = eSTUDENTID;
		String actualStudentID = driver.findElement(By.xpath("//label[text()='Student ID:']/../..//label[text()='"+eSTUDENTID+"']")).getText();

		if (expectedStudentID.equals(actualStudentID)) {
			System.out.println("TestCase Pass: The Data Flow between the Student Module and Transactions Module is present and it is Verified.");
		} else {
			System.out.println("TestCase Fail: The Data Flow between the Student Module and Transactions Module is not present and it is Verified.");

		}
		driver.quit();
	}

}
