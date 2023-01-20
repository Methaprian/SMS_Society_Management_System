package practice_package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDatafromExcelTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/MultipleTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("MULTIDATA");
		
		int count = sheet.getLastRowNum();
		
		for (int i = 0; i <=count ; i++) {
			int rcount = sheet.getLastRowNum();
			for(int j = 0 ; j <=rcount ; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}
	}

}
