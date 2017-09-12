import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriven_GetDataExcel {

	public static void main(String[] args) throws  IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub

		//Getting Control over File
		FileInputStream fis = new FileInputStream("C:\\Users\\bewosaurabh\\Documents\\GetDataFile.xlsx");
		
		//does not create a workbook (an Excel file). It instantiates a class that represents a workbook.
		//What Workbook wb = WorkbookFactory.create(fis); does is:
		//Instantiating a Java object, which implements Workbook, 
		//from the content of the file read using the file input stream.
		//After that the Workbook object is then located in memory. 
		//And only after having access to this Workbook object we can use its methods.
		Workbook wb = WorkbookFactory.create(fis);
		
		//Getting Control over Sheet
		Sheet sh = wb.getSheet("Sheet1");

		//First Row Loaded
		Row r = sh.getRow(0);
		
		Cell c0 = r.getCell(0);
		String data0 = c0.getStringCellValue();
		Cell c1 = r.getCell(1);
		String data1 = c1.getStringCellValue();
		Cell c2 = r.getCell(2);
		String data2 = c2.getStringCellValue();
		
		System.out.print(data0);
		System.out.print("," + data1);
		System.out.println("," + data2);
		
		
		//Second Row Loaded
		Row r2 =sh.getRow(1);
		
		c0 = r2.getCell(0);
		data0 = c0.getStringCellValue();
		c1 = r2.getCell(1);
		data1 = c1.getStringCellValue();
		
		System.out.print(data0);
		System.out.println("," + data1);
		
	}

}
