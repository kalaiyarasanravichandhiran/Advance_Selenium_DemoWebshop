package Com.DemoWebShop_GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(FrameWorkConstants.propertyFilePath); // used to locate the file where we can store
		Properties pro = new Properties(); // used to create the file data's
		pro.load(fis); // fetch and load the data
		String value = pro.getProperty(key); // get the data in string value
		return value;

	}

	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(FrameWorkConstants.excelFilepath);  //locate the file path
		Workbook wb = WorkbookFactory.create(fis);  //used to fetch the data from excel file
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue(); //get the data from excel file
		return value;

	}
}
