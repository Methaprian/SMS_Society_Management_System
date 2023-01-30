package practice_package;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestions {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("Selenium");
		String suggest="Webdriver";
		
		List<WebElement> autoSuggesstionsList = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		List<String> toSort=new ArrayList<String>();
		for (WebElement ele : autoSuggesstionsList) {
			String eleSuggest = ele.getText();
			toSort.add(eleSuggest);
			System.out.println(eleSuggest);
			if (eleSuggest.equals(suggest)) {
				Collections.sort(toSort);
			}
			
		}
		System.out.println(toSort);
	}

}
