package org.testng.test.sample;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		return driver=new ChromeDriver();

	}
	public static void timee(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.MILLISECONDS);
		
	}
	public static void max() {
		driver.manage().window().maximize();

	}
	public static String urlInput(String a) {
		driver.get(a);
		return a;

	}
	public static WebElement mouseTo(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e);
		return e;		

	}
	public static String url() {
		return driver.getCurrentUrl();

	}
	public static void title() {
		driver.getTitle();

	}
	
	public static String getAttributeVal(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
		

	}
	public static String sendKey(WebElement e, String val) {
		e.sendKeys(val);
		return val;

	}
	public static void refresh() {
		driver.navigate().refresh();

	}
	
	public static void scrnSht() throws IOException {
		Date d=new Date();
		int fname = d.getSeconds();
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src=tk.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\HomePC\\eclipse-workspace\\SampleTest\\ScrnSht\\"+fname+".png");
		FileUtils.copyFile(src, dest);
	}
	public static int dropDown(int a) {
		Select s= (Select)driver;
		s.deselectByIndex(a);
		return a;

	}
	
	public static void enter() {

		Robot r= (Robot)driver ;
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public static void down() {

		Robot r= (Robot)driver ;
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void excelData(int rw,int cel) throws IOException {

		File f=new File("C:\\Users\\HomePC\\eclipse-workspace\\ExcelData\\src\\test\\resources\\Loan Details.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fi);
		Sheet s = w.getSheet("ICICI 0005");
		
		Row r = s.getRow(rw);
		Cell c = r.getCell(cel);
		
		for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
			
			Row row = s.getRow(i);
			
			for(int j=0;j<r.getPhysicalNumberOfCells();j++) {
				
				Cell cell = row.getCell(j);
				System.out.println(cell);
			}
		}
	}
	
	public static String getExcel(String fname,String shet,int a, int b) throws IOException {
		
		
		File f=new File("C:\\Users\\HomePC\\eclipse-workspace\\ExcelData\\src\\test\\resources\\"+fname+".xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fi);
		Sheet sh = w.getSheet(shet);
		
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		
		int type = c.getCellType();
		
		String val=null;
		
		if(type==1) {
			val = c.getStringCellValue();
		}
		else {
			
			if(DateUtil.isCellDateFormatted(c)) {
				
				Date d = c.getDateCellValue();

				SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
				val = s.format(d);			
				
			}
			else {
				
				double num = c.getNumericCellValue();
				long l=(long)num;
				
				val = String.valueOf(l);
				
			}
		}
		return val;
		

	}
	public static void close() {
		driver.close();

	}
}
