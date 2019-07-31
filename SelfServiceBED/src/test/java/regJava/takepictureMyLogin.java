package regJava;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class takepictureMyLogin extends DriverRegistration {
	public void takeshots() throws IOException, InterruptedException {
		String small;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Regs.properties");
		prop.load(fis);
		small = prop.getProperty("SHORT_TIME");
		int small_time = Integer.parseInt(small);
		ScreenShotsMyLogin src= new ScreenShotsMyLogin();
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		WebElement element_1 = driver.findElement(By.xpath("//div[text()='Detalles de registro']"));
		wait2.until(ExpectedConditions.visibilityOf(element_1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element_1); 
		src.screenShot(driver);
		Thread.sleep(small_time);
		WebElement element_2 = driver.findElement(By.xpath("//div[text()='Detalles personales']"));
		wait2.until(ExpectedConditions.visibilityOf(element_2));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element_2); 
		src.screenShot(driver);
		Thread.sleep(small_time);
		WebElement element_3 = driver.findElement(By.xpath("//div[text()='Detalles de la aplicación']"));
		wait2.until(ExpectedConditions.visibilityOf(element_3));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element_3); 
		src.screenShot(driver);
		Thread.sleep(small_time);
	}

}

