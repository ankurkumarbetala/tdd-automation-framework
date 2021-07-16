package com.framework.core.components;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.framework.core.helpers.Configs;

public class DataProviderUtils {
	
	//JUNit class can be used instead of Data Provider Class//Eren recommeded// parametirized tests 

	@DataProvider(name = "ExcelDataProvider")
	public static Object[][] getDataFromExcel(Method methodName) throws Exception {
		File excelWorkbook = new File(System.getProperty("user.dir")
				/* + Configs.testResourceFolder */	+ "//src//test//resources//testData//TestDataSheet.xlsx");
		Workbook wb = new XSSFWorkbook(excelWorkbook); // C:\Users\Ankur\eclipse-workspace\tdd-automation-framework\src\test\resources\testData
		Sheet sheet = wb.getSheet( System.getProperty("envName").toUpperCase());
		String testName = methodName.getName() ;

		int totalRows = sheet.getPhysicalNumberOfRows();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
		Row headingRow = sheet.getRow(0);
		List<List<String>> listsOfList = new ArrayList<List<String>>();
		for (int i = 1; i < totalRows; i++) {// To fetch all the rows

			Row currentRow = sheet.getRow(i);
			String rowTestName = currentRow.getCell(0).getStringCellValue();

			int indexForColumns = getIndexForColumn(headingRow, "FetchValuesFor");
			String FetchValuesFor = currentRow.getCell(indexForColumns).getStringCellValue();
			String[] arrOfColumns = FetchValuesFor.split(",");
			List<String> colsList = new ArrayList<String>();
			if (rowTestName.equalsIgnoreCase(testName)) {
				for (int k = 0; k < arrOfColumns.length; k++) {
					int colIndex = getIndexForColumn(headingRow, arrOfColumns[k]);
					colsList.add(currentRow.getCell(colIndex).getStringCellValue());

				}

				listsOfList.add(colsList);

			}

		}
		//System.out.println(listsOfList);

		Object testSet[][] = new Object[listsOfList.size()][listsOfList.get(0).size()];

		for (int i = 0; i < listsOfList.size(); i++) {// rows
			List<String> testRow = listsOfList.get(i); // columns
			System.out.println(testRow);
			for (int j = 0; j < testRow.size(); j++) {
				testSet[i][j] = testRow.get(j);
			}
		}

		return testSet;
	}

	public static int getIndexForColumn(Row row, String columnName) {
		for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
			if (row.getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
	//	new DataProviderUtils().getDataFromExcel("loginScenario");
	}

}
