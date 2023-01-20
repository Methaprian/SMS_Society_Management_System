package com.SM.SocialManagementSystem.GenericUtility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility extends FileUtility {
	
	/**
	 * @author METHAPRIAN S.K
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int rowNo, int cellNo) throws Throwable {
		FileInputStream fisExcel = new FileInputStream(IPathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String cellData=cell.getStringCellValue();
		return cellData;
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fisExcel = new FileInputStream(IPathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRowNo = sheet.getLastRowNum();
		return lastRowNo;
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * @param sheetName
	 * @param keyCell
	 * @param valueCell
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> getList(String sheetName, int keyCellNo, int valueCellNo, int loopStartIndex) throws Throwable {
		FileInputStream fisExcel = new FileInputStream(IPathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRowNo = sheet.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=loopStartIndex ; i<=lastRowNo ; i++) {
			String key = sheet.getRow(i).getCell(keyCellNo).getStringCellValue();
			String value = sheet.getRow(i).getCell(valueCellNo).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * @param sheetName
	 * @param loopStartIndex
	 * @return
	 * @throws Throwable
	 */
	public ArrayList<String> arrayList(String sheetName,int loopStartIndex) throws Throwable  {
		FileInputStream fisExcel = new FileInputStream(IPathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet(sheetName);
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=loopStartIndex; i<=sheet.getLastRowNum();i++) {
			list.add(sheet.getRow(i).getCell(0).getStringCellValue());
		}
		return list;
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - This method is used as read multiple Data from Excel.
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultiDataDP(String sheetName) throws Throwable {
		FileInputStream fisExcel = new FileInputStream(IPathConstants.excelPATH);
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				objArr[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return objArr;
	}
}
