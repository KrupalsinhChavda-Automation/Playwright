package testcases;

import utilities.ExcelReader;

public class ExcelReading {
	
	public static void main(String[] args) {
		
		ExcelReader excel = new  ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
		
		String sheetName = "test_suite";
		
		System.out.println(excel.getRowCount(sheetName));
		
		System.out.println(excel.getCellData(sheetName, 1, 1));
	}

}
