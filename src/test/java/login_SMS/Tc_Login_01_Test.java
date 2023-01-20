package login_SMS;

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

public class Tc_Login_01_Test {

	public static void main(String[] args) throws Throwable {

		
		FileUtility fLib =  new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);

//		//Fetch Data from the Propereties File
//		FileInputStream fisProperties = new FileInputStream("./src/test/resources/smscommondata.properties");
//		Properties pObj = new Properties();
//		pObj.load(fisProperties);
		
		String URL = fLib.readDatafromPropertyFile("url");
		String USERNAME = fLib.readDatafromPropertyFile("username");
		String PASSWORD = fLib.readDatafromPropertyFile("password");

		//Fetch Data from Excel Sheet
//		FileInputStream fisExcel = new FileInputStream("./src/test/resources/SMSTestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fisExcel);
//		Sheet sheet = wb.getSheet("Login_Tc_Login_01");

//		Random rn=new Random();
//		int random = rn.nextInt(999);
		
		int rn=jlib.getRandomNo();

//		String eSTUDENTID = sheet.getRow(0).getCell(1).getStringCellValue()+rn;
//		String eYEAR = sheet.getRow(5).getCell(1).getStringCellValue();
		
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

//		HashMap<String, String> map=new HashMap<String, String>();
//		for(int i=1 ; i<=sheet.getLastRowNum() ; i++) {
//			String key = sheet.getRow(i).getCell(0).getStringCellValue();
//			String value = sheet.getRow(i).getCell(1).getStringCellValue();
//			map.put(key, value);
//		}
		
		HashMap<String, String> map = eLib.getList("Login_Tc_Login_01", 0, 1, 1);
		
		for(Entry<String, String> set: map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}

		//Select from Dropdown
		WebElement yearDropDown = driver.findElement(By.name("year"));
//		Select select = new Select(yearDropDown);
//		select.selectByVisibleText(eYEAR);
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


