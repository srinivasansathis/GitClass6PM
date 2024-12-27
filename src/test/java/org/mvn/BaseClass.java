package org.mvn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browserLaunch() {
		driver = new ChromeDriver();
		return driver;

	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void windowMaxmize() {
		driver.manage().window().maximize();

	}

	public static void type(WebElement ele, String Data) {
		ele.sendKeys(Data);
	}

	public static void btnClick(WebElement ele) {
		ele.click();
	}

	public static void quitBrowser() {
		driver.close();
	}

	public static String getTextEle(WebElement ele) {
		String text = ele.getText();
		return text;

	}

	public String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static String attribute(WebElement ele) {
		String attribute = ele.getAttribute("value");
		return attribute;
	}

	public void threadSleep(Long sec) throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(sec));
	}

	public void move(WebElement ele) {
		Actions acc = new Actions(driver);
		acc.moveToElement(ele).perform();
	}

	public void dragandDrop(WebElement src, WebElement dest) {
		Actions acc = new Actions(driver);
		acc.dragAndDrop(src, dest).perform();
	}

	public void rightClick(WebElement ele) {
		Actions acc = new Actions(driver);
		acc.contextClick().perform();
	}

	public void doubleClick(WebElement ele) {
		Actions acc = new Actions(driver);
		acc.doubleClick().perform();
	}

	public void accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void dismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public void screenShot(String path) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
	}

	public void js(String val, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].setAttribute('value','" + val + "')", ele);
	}

	public String jsGetAttribute(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object getAttribute = js.executeAsyncScript("return argurments[0].getAttribute('value')", ele);
		String s = (String) getAttribute;
		return s;
	}

	public void click(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click()", ele);
	}

	public void scrollUp(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ele);
	}

	public void scrollDown(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollIntoView(true)", ele);
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public void backward() {
		driver.navigate().back();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public boolean isEnable(WebElement ele) {
		boolean enabled = ele.isEnabled();
		return enabled;
	}

	public boolean isDisplay(WebElement ele) {
		boolean displayed = ele.isDisplayed();
		return displayed;
	}

	public boolean isSelect(WebElement ele) {
		boolean selected = ele.isSelected();
		return selected;
	}

	public static void selectIndex(WebElement ele, int val) {
		Select s = new Select(ele);
		s.selectByIndex(val);
	}

	public static void selectValue(WebElement ele, String val) {
		Select s = new Select(ele);
		s.selectByValue(val);
	}

	public static void selectVisibleText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	public static void deSelect(WebElement ele) {
		Select s = new Select(ele);
		s.deselectAll();
	}

	public List<WebElement> getOptions(WebElement ele) {
		Select s = new Select(ele);
		List<WebElement> list = s.getOptions();
		return list;
	}

	public boolean isMultiple(WebElement ele) {
		Select s = new Select(ele);
		boolean b = s.isMultiple();
		return b;
	}

	public void frameIndex(int val) {
		driver.switchTo().frame(val);
	}

	public static String excelRead(String sheetName, int rowNo, int cellNo) throws IOException {
		String value = null;
		File excelLoc = new File("D:\\Users\\Vasan\\eclipse-workspace\\Maven16\\Files\\Data.xlsx");
		FileInputStream fin = new FileInputStream(excelLoc);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				java.util.Date date = cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				value = sdf.format(date);

			} else {
				Long l = (long) cell.getNumericCellValue();
				value = String.valueOf(l);
			}

		default:
			break;
		}
		return value;
	}

	public void frameName(String name) {
		driver.switchTo().frame(name);
	}

	public void frameElement(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	public void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public void implicitWait(long sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public static void excelupdate(String sheetName, int rowNo, int cellNo, String value) throws IOException {
		File excelLoc = new File("D:\\Users\\Vasan\\eclipse-workspace\\Maven16\\Files\\Data.xlsx");
		FileInputStream fin = new FileInputStream(excelLoc);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		cell.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(excelLoc);
		book.write(fout);

	}

	public static void dateAndTime() {
		java.util.Date d = new java.util.Date();
		System.out.println(d);

	}

}
