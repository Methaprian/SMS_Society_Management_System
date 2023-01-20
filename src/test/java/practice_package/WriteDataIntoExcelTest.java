package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("SMS_LOGIN");
		
		
		Row cr = sheet.createRow(0);
		Row cr1 = sheet.createRow(1);
		
		cr.createCell(0).setCellValue("Username");
		cr1.createCell(0).setCellValue("admin");
		
		
		cr.createCell(1).setCellValue("Password");
		cr1.createCell(1).setCellValue("admin");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		
	}

}
