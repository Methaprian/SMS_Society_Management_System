package activitiesModule_SMS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Activities_13_Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver/domain/Society_Management_System/admin/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("login")).click();
		
		
		driver.findElement(By.xpath("//a[.=' Activities']")).click();
		
		driver.findElement(By.xpath("//label[.='Search:']//input[@type='search']")).sendKeys("Carrom");
		
		driver.findElement(By.xpath("//td[.='Carrom']/..//a[.=' Delete']")).click();
		driver.findElement(By.xpath("//a[.=' Yes']")).click();
		
		driver.findElement(By.xpath("//label[.='Search:']//input[@type='search']")).sendKeys("Carrom");
		WebElement confirmMsg = driver.findElement(By.xpath("//td[.='No matching records found']"));
		
		if(confirmMsg.isDisplayed()) {
			System.out.println("Test Case Pass: The Activity has been Deleted Successfully.");
		}else {
			System.out.println("Test Case Fail: The Activity has not been Deleted");
		}
		
		driver.findElement(By.xpath("//a[.=' Options']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		
		driver.quit();
		
		
	}

}
