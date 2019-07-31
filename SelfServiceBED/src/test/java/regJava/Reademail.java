package regJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class Reademail {
		
		public void detectedlanguage() throws IOException, InterruptedException, InvalidFormatException{
			String path = System.getProperty("user.dir") + "/src/main/resources/Test_Data_Email_UI.xlsx";
			String sheetName = "Language";
			DataFormatter df = new DataFormatter();
			Validatestep2 TC = new Validatestep2();
			DriverRegistration lan1=new DriverRegistration();
			ReadData read = new ReadData();
			FileInputStream ExcelFile = new FileInputStream(path);
			XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheetName);
			// Iterating all the rows in the sheet
			Iterator<Row> rows = ExcelWSheet.iterator();
			XSSFRow ExcelRow = (XSSFRow) rows.next();
			while (rows.hasNext()) {
				// Reading Excel data cell wise
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell lan = ExcelRow.getCell(0);
				lan1.Login(df.formatCellValue(lan));}
				
		}
		public void Userregistration() throws IOException, InvalidFormatException, InterruptedException {
		String path = System.getProperty("user.dir") + "/src/main/resources/Test_Data_Email_UI.xlsx";
		String sheetName = "Test_data_Email";
		DataFormatter df = new DataFormatter();
		Validate TC = new Validate();
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
			XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheetName);

			// Iterating all the rows in the sheet
			Iterator<Row> rows = ExcelWSheet.iterator();
			XSSFRow ExcelRow = (XSSFRow) rows.next();
			while (rows.hasNext()) {

				// Reading Excel data cell wise
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell Username = ExcelRow.getCell(0);
				XSSFCell Email = ExcelRow.getCell(1);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Acterror = ExcelRow.getCell(22);
				// Calling the function to validate the field
				TC.inputfield(df.formatCellValue(Username), df.formatCellValue(Email), df.formatCellValue(errormessage),
						df.formatCellValue(Fields), df.formatCellValue(Docname),df.formatCellValue(Fieldname),df.formatCellValue(Acterror));

			}
			ExcelWBook.close();
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

}


