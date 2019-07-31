package regJava;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadData {

	public void Readinputdata(String read) throws IOException, InvalidFormatException, InterruptedException {
		String path = System.getProperty("user.dir") + "/src/main/resources/Test_data_Fieldvalidation.xlsx";
		String sheet1 = "Test_data_" + read + "";
		DataFormatter df = new DataFormatter();
		Validatestep2 TC = new Validatestep2();
		Validatestep3 TC1 = new Validatestep3();

		FileInputStream ExcelFile = new FileInputStream(path);
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet(sheet1);
		Iterator<Row> rows = ExcelWSheet.iterator();
		XSSFRow ExcelRow = (XSSFRow) rows.next();
		// Iterating all the rows in the sheet
		switch (read) {

		case "First Name":

			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell First = ExcelRow.getCell(2);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(First), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Last Name":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell Last = ExcelRow.getCell(4);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(Last), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Middle Name":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell middle = ExcelRow.getCell(3);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(middle), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Phone Number":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell phone = ExcelRow.getCell(6);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(phone), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Mobile Number":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell mobile = ExcelRow.getCell(5);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(mobile), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Company Name":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell company = ExcelRow.getCell(7);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(company), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Street Address 1":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell address1 = ExcelRow.getCell(8);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(address1), df.formatCellValue(errormessage),
						df.formatCellValue(Fields), df.formatCellValue(Docname), df.formatCellValue(Fieldname),
						df.formatCellValue(Actualerr));
			}
			break;
		case "Street Address 2":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell address2 = ExcelRow.getCell(9);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(address2), df.formatCellValue(errormessage),
						df.formatCellValue(Fields), df.formatCellValue(Docname), df.formatCellValue(Fieldname),
						df.formatCellValue(Actualerr));
			}
			break;
		case "City":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell cit = ExcelRow.getCell(10);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(cit), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "State":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell stat = ExcelRow.getCell(11);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(stat), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Zip Code":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell zip = ExcelRow.getCell(13);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC.inputfield(df.formatCellValue(zip), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Contactname":

			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell coname = ExcelRow.getCell(15);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC1.inputfield(df.formatCellValue(coname), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		case "Contactemail":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell conemail = ExcelRow.getCell(16);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC1.inputfield(df.formatCellValue(conemail), df.formatCellValue(errormessage),
						df.formatCellValue(Fields), df.formatCellValue(Docname), df.formatCellValue(Fieldname),
						df.formatCellValue(Actualerr));
			}
			break;
		case "Justification":
			while (rows.hasNext()) {
				ExcelRow = (XSSFRow) rows.next();
				XSSFCell justi = ExcelRow.getCell(17);
				XSSFCell errormessage = ExcelRow.getCell(18);
				XSSFCell Fields = ExcelRow.getCell(19);
				XSSFCell Docname = ExcelRow.getCell(20);
				XSSFCell Fieldname = ExcelRow.getCell(21);
				XSSFCell Actualerr = ExcelRow.getCell(22);
				TC1.inputfield(df.formatCellValue(justi), df.formatCellValue(errormessage), df.formatCellValue(Fields),
						df.formatCellValue(Docname), df.formatCellValue(Fieldname), df.formatCellValue(Actualerr));
			}
			break;
		}

	}
}
