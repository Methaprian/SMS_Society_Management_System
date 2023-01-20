package practice_30_12_2022;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip_AllBussNames_Test {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wLib = new WebDriverUtility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.maxWindow(driver);
		wLib.waitForPageLoad(driver);
		
		driver.get("https://www.makemytrip.com/");
		
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		Robot rbt=new Robot();
		
		WebElement busesLink = driver.findElement(By.xpath("//span[text()='Buses']"));
		wLib.eleToBeVisible(driver, busesLink);
		busesLink.click();
		Thread.sleep(1000);
		
		String fromCity = "Bangalore";
		String toCity="Mysuru";
		
		String travelDate = "Jan 31 2023";
		
		driver.findElement(By.id("fromCity")).click();
		WebElement from1stEle = driver.findElement(By.xpath("//input[@placeholder='From' and contains(@class,'react-autosuggest__input')]"));
		from1stEle.sendKeys(fromCity);
		wLib.eleToBeVisible(driver, from1stEle);
		rbt.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
		WebElement to1stEle = driver.findElement(By.xpath("//input[@placeholder='To' and contains(@class,'react-autosuggest__input')]"));
		to1stEle.sendKeys(toCity);
		wLib.eleToBeVisible(driver, to1stEle);
		rbt.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
		driver.findElement(By.xpath("//div[contains(@aria-label,'"+travelDate+"')]")).click();
		
		driver.findElement(By.id("search_button")).click();
		
		List<WebElement> busList = driver.findElements(By.xpath("//div[@style='width: 72vw;']//span[@class='latoBlack font22 blackText appendRight15']"));
		System.out.println("The list of Buses from \""+fromCity+"\" to \""+toCity+"\" on \""+travelDate+"\" are : ");
		for (WebElement busNames : busList) {
			System.out.println(busNames.getText());
		}
		driver.quit();
	}
}
