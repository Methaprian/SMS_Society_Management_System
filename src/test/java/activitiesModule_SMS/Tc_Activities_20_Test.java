package activitiesModule_SMS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Activities_20_Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String URL = "http://rmgtestingserver/domain/Society_Management_System/admin/";
		String USERNAME = "admin";
		String PASSWORD = "admin";
		
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login")).click();
		
		driver.findElement(By.xpath("//a[.=' Expenses']")).click();
		driver.findElement(By.id("add_expenses")).click();
		
		String detailName = "Marriage";
		String price = "10000";
		String ay1 = "2021";
		String ay2 = "2022";
		String deadLine = "12/20/2022";
		String semVal="1st";
		
		driver.findElement(By.name("detail")).sendKeys(detailName);
		driver.findElement(By.name("price")).sendKeys(price);
		driver.findElement(By.name("ay")).sendKeys(ay1);
		driver.findElement(By.name("ay2")).sendKeys(ay2);
		driver.findElement(By.name("deadline")).sendKeys(deadLine);
		
		WebElement semDD = driver.findElement(By.name("sem"));
		Select sel = new Select(semDD);
		sel.selectByVisibleText(semVal);
		
		String expectedDetailName = detailName;
		String actualDetailName = driver.findElement(By.xpath("//th[text()='Detail']/../../..//td[text()='"+expectedDetailName+"']")).getText();
		
		if (expectedDetailName.equalsIgnoreCase(actualDetailName)) {
			System.out.println("The Detail is Created.");
			WebElement detailToDelete = driver.findElement(By.xpath("//td[.='"+expectedDetailName+"']/..//a[.=' Delete']"));
			detailToDelete.click();
			driver.findElement(By.xpath("//a[.=' Yes']")).click();
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
	}

}
