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

public class ReadFieldName extends DriverRegistration {
	
	public void detectedlanguage() throws IOException, InterruptedException, InvalidFormatException{
		String path = System.getProperty("user.dir") + "/src/main/resources/Test_data_Fieldvalidation.xlsx";
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
	
	public void detectedfield() throws IOException, InterruptedException, InvalidFormatException{
		String path = System.getProperty("user.dir") + "/src/main/resources/Test_data_Fieldvalidation.xlsx";
		String sheetName = "FieldName";
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
			XSSFCell value = ExcelRow.getCell(0);
			read.Readinputdata(df.formatCellValue(value));
			
	}

}}


