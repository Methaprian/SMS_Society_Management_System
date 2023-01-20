package accountsModule_SMS;

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

public class Tc_Accounts_01_Test {

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
		//driver.manage().window().maximize();
		driver.get(URL);
		wLib.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//	Properties File
		//		FileInputStream fisProperties = new FileInputStream("./src/test/resources/smscommondata.properties");
		//		Properties pobj = new Properties();
		//		pobj.load(fisProperties);
		//Get Data from properties file
		//				driver.get(pobj.getProperty("url"));
		//				String UserName = pobj.getProperty("username");
		//				String PassWord = pobj.getProperty("password");



		//	Excel File
//		FileInputStream fisExcel = new FileInputStream("./src/test/resources/SMSTestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fisExcel);
//		String sheetName = "Accounts_Tc_Accounts_01";
//		Sheet sheet = wb.getSheet(sheetName);

		//Random Number Generation
		//		Random randomNum = new Random();
		//		int rn = randomNum.nextInt(4500);
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

		//ArrayList to store the values that has to passed to the Path ----> NAME is taken as the key
		//Respective Values are taken in each index

		//		ArrayList<String> list = new ArrayList<String>();
		//		list.add("username");
		//		list.add("password");
		//		list.add("name");
		ArrayList<String> listArray = eLib.arrayList("Accounts_Tc_Accounts_01", 0);
		

		//Loop to pass all the Data from EXCEL to the Application
//		for(int i=0;i<=sheet.getLastRowNum();i++) {
//			String value = sheet.getRow(i).getCell(1).getStringCellValue()+rn;
//			driver.findElement(By.name(listArray.get(i))).sendKeys(value);
//			//System.out.println(value);
//			Thread.sleep(1000);
//		}
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
