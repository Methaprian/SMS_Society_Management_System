package practice_30_12_2022;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicTest_Test {

	public static void main(String[] args) throws AWTException {
		
		WebDriverUtility wLib = new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.get("https://mictests.com/");
		driver.findElement(By.xpath("//button[.='Click here to allow access to microphone identifiers']")).click();
		
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement sevMicFoundText = driver.findElement(By.xpath("//li[contains(text(),'Several microphones were detected.')]"));
		wait.until(ExpectedConditions.visibilityOf(sevMicFoundText));
		
		driver.findElement(By.xpath("//button[.='Test my mic']")).click();
		
		WebElement successText = driver.findElement(By.xpath("//li[contains(.,'Testing was completed successfully and it seems your microphone works properly.')]"));
		if(wait.until(ExpectedConditions.visibilityOf(successText)).isDisplayed()) {
			System.out.println("Mic Test Pass");
			driver.quit();
		}else {
			System.out.println("Mic Test Failed");
		}
	}

}
