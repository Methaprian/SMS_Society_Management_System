package expensesModule_SMS;

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

public class Tc_Expenses_15_Test {

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
		//		String eAy1=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 2, 1);
		//		String eAy2=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 3, 1);
		//		String deadline=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 4, 1);
		String eSem=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 0, 7);

		//		WebDriverManager.chromedriver().setup();
		//		WebDriver driver = new ChromeDriver();
		//		driver.manage().window().maximize();
		//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		//		//Fetching details from Properties File
		//		FileInputStream fisProperties = new FileInputStream("./src/test/resources/smscommondata.properties");
		//		Properties pObj = new Properties();
		//		pObj.load(fisProperties);
		//		String URL = pObj.getProperty("url");	
		//		String USERNAME = pObj.getProperty("username");
		//		String PASSWORD = pObj.getProperty("password");


		//Fetching details from Excel File
		//		FileInputStream fisExcel = new FileInputStream("./src/test/resources/SMSTestData.xlsx");
		//		Workbook wb = WorkbookFactory.create(fisExcel);
		//		Sheet sheet = wb.getSheet("Accounts_Tc_Expenses_15");


		driver.get(URL);

		//Login Page
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();
		String DetailName=eLib.readDataFromExcelFile("Accounts_Tc_Expenses_15", 0, 1);

		driver.findElement(By.xpath("//a[text()=' Expenses']")).click();
		driver.findElement(By.xpath("//td[text()='"+DetailName+"']/..//a[text()=' Update']")).click();


		//		WebElement detailTextField = driver.findElement(By.name("detail"));
		//		detailTextField.clear();
		//		detailTextField.sendKeys(eDetail);
		//		WebElement priceTextField = driver.findElement(By.name("price"));
		//		priceTextField.clear();
		//		priceTextField.sendKeys(ePrice);
		//		WebElement ay1TextField = driver.findElement(By.name("ay1"));
		//		ay1TextField.clear();
		//		ay1TextField.sendKeys(eAy1);
		//		WebElement ay2TextField = driver.findElement(By.name("ay2"));
		//		ay2TextField.clear();
		//		ay2TextField.sendKeys(eAy2);

		HashMap<String, String> HashMapList = eLib.getList("Accounts_Tc_Expenses_15", 0, 1, 0);

		for (Entry<String, String> string : HashMapList.entrySet()) {
			WebElement ele = driver.findElement(By.name(string.getKey()));
			ele.clear();
			ele.sendKeys(string.getValue());
		}

		WebElement semDropdown = driver.findElement(By.name("sem"));
		//		Select select=new Select(semDropdown);
		//		select.selectByValue("1st");
		wLib.selectValue(semDropdown, eSem);

		//		WebElement deadLine = driver.findElement(By.name("deadline"));
		//		deadLine.clear();
		//		deadLine.sendKeys(deadline);

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
