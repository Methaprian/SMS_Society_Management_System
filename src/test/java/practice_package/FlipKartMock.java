package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKartMock {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		Actions action =new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//div[text()='TVs & Appliances']")).click();
		WebElement tvIconLink = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
		action.moveToElement(tvIconLink, 0, 0).perform();
		driver.findElement(By.xpath("//a[text()='Window ACs']")).click();
		
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
//		for(;;) {
//			jse.executeScript("window.scrollBy(0,200)");
//			if(driver.findElement(By.xpath("//div[.='Hitachi 1.5 Ton 3 Star Window Inverter AC  - White']")).isDisplayed()) {
//				break;
//			}
//		}
		WebElement targetName = driver.findElement(By.xpath("//div[.='Hitachi 1.5 Ton 3 Star Window Inverter AC  - White']"));
		targetName.click();
		//System.out.println(targetName);
//		String targetPrice = driver.findElement(By.xpath("//div[.='Hitachi 1.5 Ton 3 Star Window Inverter AC  - White']/../..//div[@class='_30jeq3 _1_WHN1']")).getText();
//		System.out.println(targetPrice);
//		driver.quit();
	}
}
