package regJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Validatestep2 extends DriverRegistration {

	Properties prop = new Properties();

	public void inputfield(String fieldname, String error, String Field, String doc, String Validatedfield,
			String Actualerr) throws IOException, InterruptedException, InvalidFormatException {
		// Sending the keys to the input field on the registration form

		String small;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Regs.properties");
		prop.load(fis);
		small = prop.getProperty("SHORT_TIME");
		boolean scrsht = Boolean.parseBoolean(prop.getProperty("screenshot"));
		System.out.println(scrsht);
		int small_time = Integer.parseInt(small);

		// WebDriverWait wait = new WebDriverWait(driver, 50);
		WebDriverWait waiterr = new WebDriverWait(driver, 3);
		WebDriverWait waitcon = new WebDriverWait(driver, 10);
		takepictureMyLogin src1 = new takepictureMyLogin();
		ScreenShotsMyLogin src2 = new ScreenShotsMyLogin();
		WebElement w1;
		switch (Validatedfield) {
		case "First Name":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='firstName']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Last Name":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='lastName']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Middle Name":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='middleName']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Phone Number":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='phone']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Mobile Number":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='mobile']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Company Name":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='company']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Street Address 1":
			w1 = driver.findElement(By.xpath("//textarea[@formcontrolname='address1']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Street Address 2":
			w1 = driver.findElement(By.xpath("//textarea[@formcontrolname='address2']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "City":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='city']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "State":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='state']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		case "Zip Code":
			w1 = driver.findElement(By.xpath("//input[@formcontrolname='zip']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w1);
			w1.click();
			Thread.sleep(1000);
			w1.sendKeys(fieldname);
			break;
		}
		if (scrsht) {
			src1.takeshots();
		}
		WebElement w2 = driver.findElement(By.xpath("//mat-select[@formcontrolname='constructionsegment']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", w2);
		waitcon.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-select[@formcontrolname='constructionsegment']")));
		w2.click();
		Thread.sleep(small_time);
		// Deciding whether the field validation is passed or not
		if (Field.equalsIgnoreCase("incorrect")) {
			try {
				waiterr.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-error[@role='alert']")));
				WebElement Actualerror = driver.findElement(By.xpath("//mat-error[@role='alert']"));
				String actualErrorText = new String(Actualerror.getText());
				String error1 = new String(error);
				// String[] actErrorArr=actualErrorText.split("\\s+");
				// String[] excError=error1.split("\\s+");
				if (error1.equalsIgnoreCase(actualErrorText)) {
					Reporter.log(Validatedfield + "is:" + fieldname + ":Test Passed");
					if (scrsht) {
						src1.takeshots();
					}
				} else {
					Reporter.log(Validatedfield + "is:" + fieldname + ":Test Failed");
					if (scrsht) {
						src1.takeshots();
					}
				}

			}

			catch (Exception e) {
				Reporter.log(Validatedfield + "is:" + fieldname + ":Test Failed");
				if (scrsht) {
					src1.takeshots();
				}
			}
		} else if (Field.equalsIgnoreCase("correct")) {
			try {
				List<WebElement> element1 = driver.findElements(By.xpath("//input[@aria-invalid='false']"));
				List<WebElement> element2 = driver.findElements(By.xpath("//textarea[@aria-invalid='false']"));
				if ((element1.size() + element2.size()) == 12) {
					Reporter.log(Validatedfield + "is:" + fieldname + ":Test Passed");
					if (scrsht) {
						src1.takeshots();
					}
				} else {
					Reporter.log(Validatedfield + "is:" + fieldname + ":Test Failed");
					if (scrsht) {
						src1.takeshots();
					}
				}
			} catch (Exception e2) {
				if (scrsht) {
					src1.takeshots();
				}
				Reporter.log(Validatedfield + "is:" + fieldname + ":Test Failed");
			}
		}
		try {
			WebElement Acterror = driver.findElement(By.xpath("//mat-error[@role='alert']"));
			String a = Acterror.getText();
			switch (Validatedfield) {
			case "First Name":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Last Name":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Middle Name":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Phone Number":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Mobile Number":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "City":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Company Name":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Street Address 1":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Street Address 2":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "State":
				src2.savetofile(doc, error, fieldname, a);
				break;
			case "Zip Code":
				src2.savetofile(doc, error, fieldname, a);
				break;
			}
		} catch (Exception e3) {
			switch (Validatedfield) {
			case "First Name":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Last Name":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Middle Name":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Phone Number":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Mobile Number":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "City":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Company Name":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Street Address 1":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Street Address 2":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "State":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			case "Zip Code":
				src2.savetofile(doc, error, fieldname, Actualerr);
				break;
			}
		}

		src2.deleteFiles();
		driver.navigate().refresh();
		waitcon.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@formcontrolname='email']")));

	}
}
