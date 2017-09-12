import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriven_PutDataExcelGeneric {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub

		GetData g = new GetData();
		String s = g.getStringData("C:\\Users\\bewosaurabh\\Documents\\SetDataFile.xlsx", "Sheet1", 0, 0);
		g.setData("C:\\Users\\bewosaurabh\\Documents\\SetDataFile.xlsx", "Sheet1", 0, 0, "Successfully written data");
	}

}

class GetData {
	public String getStringData(String Path, String sheet, Integer row, Integer col)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream file = new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell c = r.getCell(col);
		String data = c.getStringCellValue();
		return data;
	}

	public double getNumericData(String Path, String sheet, Integer row, Integer col)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream file = new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(file);
		double numData = wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
		return numData;
	}

	public void setData(String Path, String sheet, Integer row, Integer col, String data)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		{
			FileInputStream file = new FileInputStream(Path);
			Workbook wb = WorkbookFactory.create(file);

			if (wb.getSheet(sheet).getRow(row).equals(null)) {

				wb.getSheet(sheet).createRow(row);

			}

			if (wb.getSheet(sheet).getRow(row).getCell(col).equals(null)) {

				wb.getSheet(sheet).getRow(row).createCell(col).setCellValue(data);
			} else {
				wb.getSheet(sheet).getRow(row).getCell(col).setCellValue(data);
			}

			FileOutputStream fos = new FileOutputStream(Path);
			wb.write(fos);
			wb.close();

		}

	}

}