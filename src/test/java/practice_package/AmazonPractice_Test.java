package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPractice_Test {

	public static void main(String[] args) throws Throwable {
		int count=0;
		FileInputStream fis = new FileInputStream("./src/test/resources/MultipleTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("AMAZON_LINKS");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.in/");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int count1 = links.size();
		System.out.println(count1);
		for (WebElement link : links) {
			Row row = sheetName.createRow(count);
			Cell cell = row.createCell(0);
			cell.setCellValue(link.getAttribute("href"));
			count++;
		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/MultipleTestData.xlsx");
		wb.write(fos);
		wb.close();
		System.out.println("The Links has been written into Excel");
	}

}
