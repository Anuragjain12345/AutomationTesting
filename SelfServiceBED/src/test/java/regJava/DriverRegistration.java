package regJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverRegistration {
	
	public static WebDriver driver; 
	public static String browser;
	public static Properties prop = new Properties();
	public static String osType;
	public static String url;
	
	public void Login(String lan1) throws IOException {
		
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Regs.properties");
		
		prop.load(fis);
		browser = prop.getProperty("browser");
		osType = prop.getProperty("osType");
		url = prop.getProperty("myLogin");

		if (browser.equalsIgnoreCase("firefox")) {
			if (osType.equalsIgnoreCase("Windows")) { // Set Path for the executable file
				System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver23.exe");
				FirefoxProfile ffprofile = new FirefoxProfile();
				FirefoxOptions option = new FirefoxOptions();
				ffprofile.setPreference("intl.accept_languages", lan1);
				option.setProfile(ffprofile);
				driver = new FirefoxDriver(option);
				WebDriverWait wait = new WebDriverWait(driver, 500);
				driver.manage().window().maximize();
				driver.get(url);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='firstName']")));
			} else if (osType.equalsIgnoreCase("Linux")) {
				System.setProperty("webdriver.firefox.marionette", "src/main/resources/drivers/geckodriver");
				driver = new FirefoxDriver();
				WebDriverWait wait = new WebDriverWait(driver, 500);
				driver.manage().window().maximize();
				driver.get(url);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
			}
		}

		else if (browser.equalsIgnoreCase("chrome")) {

			if (osType.equalsIgnoreCase("Windows")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				WebDriverWait wait = new WebDriverWait(driver, 500);
				driver.manage().window().maximize();
				driver.get(url);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
			} else {
				throw new IllegalArgumentException("Could not find supported browser: " + browser);
				
			}
		}
	}

public void close() {
driver.close();
}
}
