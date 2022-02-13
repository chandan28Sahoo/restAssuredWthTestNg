package utils;

public class ExcelUtilTest {
	public static void main(String[] args) {
		
		String sheetName = "./dataForExcel/Data_sheet.xlsx";
		ExcelUtils excelUtils = new ExcelUtils(sheetName,2);
		excelUtils.getrowcount();
		excelUtils.getReaddata();
		
	}
}
