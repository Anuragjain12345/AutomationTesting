package regTest;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import regJava.DriverRegistration;
import regJava.ReadFieldName;

public class ValidationStep2 {
	DriverRegistration obj1 = new DriverRegistration();
	ReadFieldName name = new ReadFieldName();
  @Test
  public void email() {
	  
	  try {
		name.detectedfield();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  @BeforeClass
  public void beforeMethod() throws IOException, InvalidFormatException, InterruptedException {
	  name.detectedlanguage();
  }

  @AfterClass
  public void afterClass() {
	  obj1.close();
  }
}
