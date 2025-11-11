package testNGBasics;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] getExcelData() throws IOException {
		String path = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(path + "\\excels\\datas.xlsx");
		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sheet = wk.getSheet("loginCredentials");
		int numberOfRows = sheet.getLastRowNum();// it will last edited with the value
		int numberOfColumns = sheet.getRow(0).getLastCellNum();
//		System.out.println(numberOfRows);
//		System.out.println(numberOfColumns);
		String[][] data = new String[numberOfRows][numberOfColumns];

		wk.close();
		
		for (int i = 1; i <= numberOfRows; i++) {  
		    XSSFRow currentRow = sheet.getRow(i);
		    for (int j = 0; j < numberOfColumns; j++) {
		        XSSFCell cell = currentRow.getCell(j);
		        DataFormatter dataFormatter = new DataFormatter();
		        String stringFormattedCellValue = dataFormatter.formatCellValue(cell);
//		        System.out.print(stringFormattedCellValue + "|");
				data[i-1][j] = stringFormattedCellValue;

		    }
//		    System.out.println();
		}
		return data;
		
	}
}