package regJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
public class ScreenShotsMyLogin{
	

		public static int count = 1;
		String path = System.getProperty("user.dir") + "/src/main/resources/Screenshots_ES/";
		public void screenShot(WebDriver driver) throws IOException, InterruptedException {
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.simple()).takeScreenshot(driver);
			String filename = "Screenshot" + count;
			File dest = new File(path + filename + ".png");
			ImageIO.write(screenshot.getImage(), "PNG", dest);
			count++;
		}
		
		public void screenShotFullpage(WebDriver driver) throws IOException, InterruptedException {
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
			
			String filename = "Screenshot" + count;
			File dest = new File(path+ filename + ".png");
			ImageIO.write(screenshot.getImage(), "PNG", dest);
			count++;
		}
		
		

		public void savetofile(String fileName, String error, String val, String acc ) throws IOException, InvalidFormatException {
			XWPFDocument doc = new XWPFDocument();
			XWPFParagraph p = doc.createParagraph();
			XWPFRun title1 = p.createRun();
			title1.setText("Input Value:"+ val);
			XWPFRun r = p.createRun();
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
			Date today = new Date();
			String date = dateFormat.format(today);
			Path dir = Paths.get(path + fileName + "-" + date);
			Files.createDirectory(dir);
			for (int i = 1; i < count; i++) {
				File img = new File(path + "Screenshot" + i + ".png");
				String imgFile = img.getName();
				int imgFormat = getImageFormat(imgFile);
				r.addBreak();
				r.addPicture(new FileInputStream(img), imgFormat, imgFile, Units.toEMU(500), Units.toEMU(400));
				r.addBreak(BreakType.PAGE);
				img.deleteOnExit();
			}
			XWPFRun title = p.createRun();
			title.setBold(true);
			title.setUnderline(UnderlinePatterns.SINGLE);
			if((error==null || error.isEmpty())&&(acc==null || acc.isEmpty())) {
				title.setText("Expected Error:" + "No error found" );
			}else{
				title.setText("Expected Error: "+ error);
				title.addBreak();
				title.setText("Actual Error: "+ acc);
			}
			title.addBreak();
			
			FileOutputStream out = new FileOutputStream(dir + "\\" + fileName + "-Screenshots.docx");
			doc.write(out);
			out.flush();
			out.close();
			doc.close();
			System.gc();
				
		}
		
		
		public void deleteFiles() {
			for (int i = 1; i < count; i++) {
				File img = new File(path + "Screenshot" + i + ".png");
				boolean bool = img.delete();
				System.out.println("File deleted? " + bool);
			}
			count = 1;
		}

		private static int getImageFormat(String imgFile) {
			int format;
			if (imgFile.endsWith(".emf"))
				format = XWPFDocument.PICTURE_TYPE_EMF;
			else if (imgFile.endsWith(".wmf"))
				format = XWPFDocument.PICTURE_TYPE_WMF;
			else if (imgFile.endsWith(".pict"))
				format = XWPFDocument.PICTURE_TYPE_PICT;
			else if (imgFile.endsWith(".jpeg") || imgFile.endsWith(".jpg"))
				format = XWPFDocument.PICTURE_TYPE_JPEG;
			else if (imgFile.endsWith(".png"))
				format = XWPFDocument.PICTURE_TYPE_PNG;
			else if (imgFile.endsWith(".dib"))
				format = XWPFDocument.PICTURE_TYPE_DIB;
			else if (imgFile.endsWith(".gif"))
				format = XWPFDocument.PICTURE_TYPE_GIF;
			else if (imgFile.endsWith(".tiff"))
				format = XWPFDocument.PICTURE_TYPE_TIFF;
			else if (imgFile.endsWith(".eps"))
				format = XWPFDocument.PICTURE_TYPE_EPS;
			else if (imgFile.endsWith(".bmp"))
				format = XWPFDocument.PICTURE_TYPE_BMP;
			else if (imgFile.endsWith(".wpg"))
				format = XWPFDocument.PICTURE_TYPE_WPG;
			else {
				return 0;
			}
			return format;
		}
		
	}




