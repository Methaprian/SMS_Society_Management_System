package practice_30_12_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldPopulation_Test {

	public static void main(String[] args) throws Throwable {
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);
		
		driver.get("https://www.worldometers.info/world-population/");
		
		String pop = driver.findElement(By.xpath("//h1[.=' Current World Population']/..//span[@class='rts-counter']")).getText();
		System.out.println("The Current World Population on \""+jLib.getSystemDate()+"\" is : "+pop);
		
		driver.quit();
	}
}