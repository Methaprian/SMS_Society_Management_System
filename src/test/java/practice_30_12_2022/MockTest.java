package practice_30_12_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockTest {

	public static void main(String[] args) {
		
		WebDriverUtility wLib=new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);
		
		driver.get("https://olympics.com/en/");
		
		List<WebElement> atheleteNames = driver.findElements(By.xpath("//h2[text()='athletes']/../../..//a[@class='featured-athlete__name d-flex text-body']"));
		
		for (WebElement atheleteName : atheleteNames) {
			System.out.println(atheleteName.getText());
		}
		driver.quit();
	}

}
