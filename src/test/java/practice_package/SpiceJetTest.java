package practice_package;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetTest {

	@Test
	public void spiceJet_Test() throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(3000);
		Robot rbt=new Robot();
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		
		//driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='From']/..//input[@type='text']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[text()='To']/..//input[@type='text']")).clear();
		driver.findElement(By.xpath("//div[text()='To']/..//input[@type='text']")).sendKeys("Madurai");
		
		
		String sDate="10";
		String sMonth="July";
		String sYear="2023";
		
		String date="25";
		String month="August";
		String year="2023";
		
		//Departure Date
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-"+sMonth+"-"+sYear+"']//div[text()='"+sDate+"']")).click();
		//Return Date
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-"+month+"-"+year+"']//div[text()='"+date+"']")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
	}
}
