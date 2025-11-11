package testNGBasics;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider ()
	public String[][] getData() throws IOException {
		String[][] excelData = ReadExcel.getExcelData();


		return excelData;
	}

}