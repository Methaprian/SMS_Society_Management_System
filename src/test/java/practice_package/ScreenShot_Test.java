package practice_package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot_Test {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String fs = "FailedScript-"+new JavaUtility().getSystemDate();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ErrorShots/"+ fs +".png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot taken : "+fs);
		driver.quit();
	}

}
