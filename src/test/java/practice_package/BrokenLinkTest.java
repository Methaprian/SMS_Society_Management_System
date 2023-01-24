package practice_package;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkTest {

	
	ExcelUtility eLib=new ExcelUtility();
	@Test
	public void linkTest() throws Throwable {


		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		List<WebElement> linksList = driver.findElements(By.xpath("//a"));

		List<String> brokenLinks=new ArrayList<String>();

		for (int i = 0; i < linksList.size(); i++) {
			String link = linksList.get(i).getAttribute("href");
			URL url;
			int statusCode=0;

			try {
				url=new URL(link);
				URLConnection urlConnect = url.openConnection();
				HttpURLConnection httpUrlConnect=(HttpURLConnection)urlConnect;
				statusCode=httpUrlConnect.getResponseCode();
				
				if(statusCode>400) {
					brokenLinks.add(link+" ----> "+statusCode);
				}
			} catch (Exception e) {
				brokenLinks.add(link);
				continue;
			}
			
		System.out.println(link+" ----> "+statusCode);
		}
		//System.out.println(brokenLinks);
	}
}
