import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriven_PutDataExcelSimple {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream("C:\\Users\\bewosaurabh\\Documents\\GetDataFile.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh	=  wb.getSheet("Sheet1");
		Row   r		=	sh.getRow(0);
		//r.getCell (<column number>)
		Cell c 		=	r.getCell(0);
		String oldData = c.getStringCellValue();
		System.out.println(oldData);
		String newData = "Hey there2!";
		
		//Doubt: Why are we not creating cell as 'r.createCell(0)' here?
		//Ans: Yahan cell value present thi isliy we didn't create a new cell. usi me overwrite kar diye
		//other wise we have to create a new cell first and then write data in it.
		c.setCellValue(newData);
		System.out.println(c.getStringCellValue());
	
	}

}
