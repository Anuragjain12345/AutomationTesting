package regJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Validate extends DriverRegistration {

	Properties prop = new Properties();

	public void inputfield(String username, String email, String error, String Field, String doc, String Validatedfield,
			String Actualerr) throws IOException, InterruptedException, InvalidFormatException {
		// Sending the keys to the input field on the registration form

		String small;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Regs.properties");
		prop.load(fis);
		small = prop.getProperty("SHORT_TIME");
		boolean scrsht = Boolean.parseBoolean(prop.getProperty("screenshot"));
		int small_time = Integer.parseInt(small);

		// WebDriverWait wait = new WebDriverWait(driver, 50);
		WebDriverWait waiterr = new WebDriverWait(driver, 15);
		WebDriverWait waitcon = new WebDriverWait(driver, 15);
		takepictureMyLogin src1 = new takepictureMyLogin();
		ScreenShotsMyLogin src2 = new ScreenShotsMyLogin();
		WebElement element_1 = driver.findElement(By.xpath("//input[@formcontrolname='" + Validatedfield + "']"));
		waiterr.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='" + Validatedfield + "']")));
		/*WebElement w1 = driver
				.findElement(By.xpath("//input[@placeholder='Username (e.g.,abcd1234 or user@email.com)']"));
		w1.click();
		Thread.sleep(small_time);
		w1.sendKeys(username);
		w1.sendKeys(Keys.TAB);*/
		WebElement w2 = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
		w2.click();
		Thread.sleep(small_time);
		w2.sendKeys(email);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element_1);
		// Capturing the Screenshots before clicking on Register
		if (scrsht) {
			src1.takeshots();
		}
		driver.findElement(By.xpath("//input[@formcontrolname='middleName']")).click();
		// Deciding whether the field validation is passed or not
		if (Field.equalsIgnoreCase("incorrect")) {
			try {
				//System.out.println("In Incorrect try block");
				waiterr.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Comprobar disponibilidad']")));
				if (driver.findElement(By.xpath("//span[text()='Comprobar disponibilidad']/parent::button")).isEnabled()) {
					driver.findElement(By.xpath("//span[text()='Comprobar disponibilidad']/parent::button")).click();
					waiterr.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//mat-error[@role='alert']/parent::div/mat-error[2]")));
					WebElement Actualerror1 = driver
							.findElement(By.xpath("//mat-error[@role='alert']/parent::div/mat-error[2]"));
					if (error.trim().equalsIgnoreCase((Actualerror1.getText()).trim())) {
						Reporter.log("Username is:" + username + ":Test Passed");
						if (scrsht) {
							src1.takeshots();
						}
					} else {
						Reporter.log("Username is:" + username + ":Test Failed");
						if (scrsht) {
							src1.takeshots();
						}
					}
				} else {
					//Reporter.log("In Incorrect try block's else");
					waiterr.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//mat-error[@role='alert']")));
					WebElement Actualerror = driver
							.findElement(By.xpath("//mat-error[@role='alert']"));
					if ((error.trim()).equalsIgnoreCase((Actualerror.getText()).trim())) {
						//System.out.println("In Incorrect try block's if ");
						Reporter.log("Username is:" + username + ":Test Passed");
						if (scrsht) {
							src1.takeshots();
						}

					} else {
						//System.out.println("In Incorrect try block's 2nd Else");
						Reporter.log("Username is:" + username + ":Test Failed");
						if (scrsht) {
							src1.takeshots();
						}
					}
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				//System.out.println("In Incorrect catch block");
				Reporter.log("Username is:" + username + ":Test Failed");
				if (scrsht) {
					src1.takeshots();
				}
			}
		} else if (Field.equalsIgnoreCase("correct"))

		{
			try {
				waiterr.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Comprobar disponibilidad")));
				boolean b = driver.findElement(By.xpath("//span[text()='Comprobar disponibilidad']/parent::button")).isEnabled();
				if(b) {
				driver.findElement(By.xpath("//span[text()='Comprobar disponibilidad']")).click();
				waitcon.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//span[text()='Nombre de usuario y dirección de correo electrónico válidos. Por favor proceda a completar otros detalles.']")));
				WebElement success = driver.findElement(By.xpath(
						"//span[text()='Nombre de usuario y dirección de correo electrónico válidos. Por favor proceda a completar otros detalles.']"));
				String message = success.getText();
				if (message.equalsIgnoreCase(
						"Nombre de usuario y dirección de correo electrónico válidos. Por favor proceda a completar otros detalles.']")) {
					Reporter.log("Username is:" + username + ":Test Passed");
					if (scrsht) {
						src1.takeshots();
					}
				}
			}else {
				Reporter.log("Username is:" + username + ":Test Failed");
				if (scrsht) {
					src1.takeshots();
				}
			}
			}catch (Exception e2) {
				if (scrsht) {
					src1.takeshots();
				}
				Reporter.log("Username is:" + username + ":Test Failed");
			}
		}
		try {
			WebElement Acterror = driver.findElement(By.xpath("//mat-error[@role='alert']"));
			String a = Acterror.getText();
			switch (Validatedfield) {
			case "email":
				src2.savetofile(doc, error, email, a);
				break;
			case "Username (e.g.,abcd1234 or user@email.com)":
				src2.savetofile(doc, error, username, a);
				break;
			}
		} catch (Exception e2) {
			switch (Validatedfield) {
			case "email":
				src2.savetofile(doc, error, email, Actualerr);
				break;
			case "Username (e.g.,abcd1234 or user@email.com)":
				src2.savetofile(doc, error, username, Actualerr);
				break;
			}
		}
		src2.deleteFiles();
		driver.navigate().refresh();
		waitcon.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@formcontrolname='email']")));

	}
}
