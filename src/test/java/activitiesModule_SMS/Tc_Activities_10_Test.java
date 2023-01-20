package activitiesModule_SMS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_Activities_10_Test {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://rmgtestingserver/domain/Society_Management_System/admin/");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("login")).click();
		
		
		driver.findElement(By.xpath("//a[.=' Activities']")).click();
		driver.findElement(By.id("add_activity")).click();
		
		driver.findElement(By.name("title")).sendKeys("Carrom");
		driver.findElement(By.name("description")).sendKeys("This is a Carrom Championship Final Match");
		driver.findElement(By.name("start")).sendKeys("01/05/2023");
		driver.findElement(By.name("end")).sendKeys("01/05/2023");
		driver.findElement(By.name("save_activity")).click();
		
		System.out.println("Activity Created");
		
		driver.findElement(By.xpath("//a[.=' Options']")).click();
		driver.findElement(By.xpath("//a[.=' Logout']")).click();
		
		driver.quit();
	}

}
