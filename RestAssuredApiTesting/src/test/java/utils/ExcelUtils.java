package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, int sheetNo){
		try {
			wb = new XSSFWorkbook(excelPath);
			sheet = wb.getSheetAt(sheetNo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void getReaddata()
	{
		try 
		{
			DataFormatter formatter = new DataFormatter();
			Object valueObject =  formatter.formatCellValue(sheet.getRow(2).getCell(2));
			System.out.println(valueObject);
		} catch (Exception e){
			System.out.println("Issue in Getread data "+e.getMessage());
		}
	}
	
	public  void getrowcount()
	{
		try {
			int count=sheet.getPhysicalNumberOfRows();
			System.out.println(count);
		} catch (Exception e) {
			System.out.println("Issue in Getrow count "+e.getMessage());
		}
	}
}
