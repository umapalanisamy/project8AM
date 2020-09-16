package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LibGlobal {

	public static WebDriver driver;

	// To launch Chrome browser
	public static WebDriver launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\umapa\\Desktop\\Frameworks\\FrameworkClass\\driver 85\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		return driver;
	}

	// To launch Opera browser
	public static void launch_Opera_Browser() {
		System.setProperty("webdriver.opera.driver",
				"C:\\Users\\umapa\\Desktop\\Frameworks\\FrameworkClass\\driver\\operadriver.exe");
		driver = new OperaDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	}

	// To launch IE browser
	public static void launch_IE_Browser() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\umapa\\Desktop\\Frameworks\\FrameworkClass\\driver\\chromedriver.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// To launch the URL
	public static void get_Url(String url) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	// To quit the browser
	public static void quit_Broswer() {
		driver.quit();
	}

	// To close the browser
	public void close_Browser() {
		driver.close();
	}

	// To get the url of the current Web Page
	public String get_CurrentUrl() {
		String currentUrlLink = driver.getCurrentUrl();
		return currentUrlLink;
	}

	// To get the title of the current web page
	public String get_Title() {
		String title = driver.getTitle();
		return title;
	}

	// To type the text
	public static void send_Keys(WebElement e, String value) {
		e.sendKeys(value);
	}

	// To click the button
	public static void btn_click(WebElement e) {
		e.click();
	}

	// To get the visible text of this element.
	public String get_Text(WebElement e) {
		String text = e.getText();
		return text;
	}

	// To get the value of the given attribute of the element
	public static String get_Attribute(WebElement e) {

		// attributeValue=getAttribute("attributrName") -
		String attributeValue = e.getAttribute("value");
		return attributeValue;

	}

	// To check if the element is currently selected or checked
	public boolean is_Selected(WebElement e) {
		boolean selected = e.isSelected();
		return selected;
	}

	// To check Is the element currently enabled or not
	public boolean is_Enabled(WebElement e) {
		boolean selected = e.isEnabled();
		return selected;
	}

	// To check Is this element displayed or not
	public boolean is_Displayed(WebElement e) {
		boolean selected = e.isDisplayed();
		return selected;
	}

	// Simple alert- Contains only Ok
	public void accept_Alert() {
		Alert a = driver.switchTo().alert();
		String textAlert = a.getText();
		System.out.println("Text presents in the alert message box is : " + textAlert);
		a.accept();

	}

	// Confirm Alert
	public void dismiss_Alert() {
		Alert a = driver.switchTo().alert();
		String textAlert = a.getText();
		System.out.println("Text presents in the alert message box is : " + textAlert);
		a.dismiss();
	}

	// Prompt Alert
	public void prompt_Alert_accept() {
		Alert a = driver.switchTo().alert();
		String textAlert = a.getText();
		System.out.println("Text presents in the alert message box is : " + textAlert);
		a.sendKeys("Automated Test");
		a.accept();
	}

	// To move cursor - Mouse Over Actions
	public void move_To_Element(WebElement e) {
		Actions acc = new Actions(driver);
		acc.moveToElement(e).perform();

	}

	// To perform Right click operation
	public void context_Click(WebElement e) {
		Actions acc = new Actions(driver);
		acc.contextClick(e).perform();
	}

	// To perform double click operation
	public void double_Click(WebElement e) {
		Actions acc = new Actions(driver);
		acc.doubleClick(e).perform();
	}

	// To drag and drop the values using mouse over actions
	public void drag_And_Drop(WebElement src, WebElement dest) {
		Actions acc = new Actions(driver);
		acc.dragAndDrop(src, dest).perform();

	}

	// To perform Down arrow key operation using Robot Class
	public void press_DownArrow(int count) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < count; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

	}

	// To perform TAB key operation using Robot Class
	public void press_Tab(int count) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < count; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
	}

	// To perform ENTER key operation using Robot Class
	public void press_Enter(int count) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i < count; i++) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	}

	// To perform scroll down
	public void scroll_Down(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0],scrollIntoView(true)", e);

	}

	// To perform scroll up
	public void scroll_Up(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0],scrollIntoView(false)", e);

	}

	// To take screen shot - Configure commons-io-2.4.jar
	public void screenShot() {

	}

	// Switch to frame by using frame id
	public void frameById(String frame_Id) {
		driver.switchTo().frame(frame_Id);
	}

	// Switch to frame by using frame name
	public void frameByName(String frame_Name) {
		driver.switchTo().frame(frame_Name);
	}

	// Switch to frame by using WebElement reference
	public void frameByWebElement(WebElement e) {
		driver.switchTo().frame(e);
	}

	// Switch to frame by using frame index
	public void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// Switch from frame to main window(To go back to main window)
	public void default_Content() {
		driver.switchTo().defaultContent();
	}

	// To go back to immediate parent
	public void parent_Frame() {
		driver.switchTo().parentFrame();
	}

	// Drop down Select by using Index
	public void ddn_Select_By_Index(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	// Drop down Select by using attribute value
	public void ddn_Select_By_Value(WebElement e, String attr_Value) {
		Select s = new Select(e);
		s.selectByValue(attr_Value);
	}

	// Drop down Select by using text
	public static void ddn_Select_By_VisibleText(WebElement e, String visible_Text) {
		Select s = new Select(e);
		s.selectByVisibleText(visible_Text);
	}

	// To print the all the options available in the drop down
	public void get_Options(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allOptions = s.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			WebElement element = allOptions.get(i);
			String text = element.getText();
			System.out.println(text);
		}
	}

	// To check multiple selection options is available in drop down or not
	public void is_Multiple(WebElement e) {
		Select s = new Select(e);
		boolean multiple = s.isMultiple();
		if (multiple == true) {
			System.out.println("Multiple Options selection is availble");
		} else {
			System.out.println("Multiple Options selection is not availble");
		}
	}

	// To select multiple options in the drop down using index
	public void select_Multiple_Options_By_Index(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allOptions = s.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			s.selectByIndex(i);
		}
	}

	// To select multiple options in the drop down using attribute value
	public void select_Multiple_Options_By_Value(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allOptions = s.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			// Each Option
			WebElement element = allOptions.get(i);
			// to get attribute value
			String name = element.getAttribute("value");
			s.selectByValue(name);
		}
	}

	// To select multiple options in the drop down using visible text
	public void select_Multiple_Options_By_Visible_Text(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allOptions = s.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			// Each Option
			WebElement element = allOptions.get(i);
			// to get text
			String text = element.getText();
			s.deselectByValue(text);
		}
	}

	// To get all the selected options in the drop down
	public void get_All_Selected_Options(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		System.out.println("Options selected in the drop down is :");
		for (WebElement element : allSelectedOptions) {
			String text = element.getText();
			System.out.println(text);
		}
	}

	// To get the first selected options in the drop down
	public void get_First_Selected_Option(WebElement e) {
		Select s = new Select(e);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println("First selected option in the drop down is :  " + text);
	}

	// To deselect the selected option by using index
	public void deselect_By_Index(WebElement e, int index) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		s.deselectByIndex(index);
		String text = options.get(index).getText();
		System.out.println("Deselected options is :  " + text);
	}

	// To deselect the selected option by using value
	public void deselect_By_Value(WebElement e, String attr_Value) {
		Select s = new Select(e);
		s.deselectByValue(attr_Value);
	}

	// To deselect the selected option by using text
	public void deselect_By_VisibleText(WebElement e, String visible_Text) {
		Select s = new Select(e);
		s.deselectByVisibleText(visible_Text);
	}

	// To deselect all the selected option
	public void deselect_All(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}

	// To get parent Window Id
	public void get_WindowHandle() {
		String parentWindowId = driver.getWindowHandle();
		System.out.println("parent Window ID is : " + parentWindowId);
	}

	// To get all the window id
	public void get_WindowHandles() {
		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println("All opened Window ID's are : ");
		for (String eachId : allWindowId) {
			System.out.println(eachId + "\n");
		}
		System.out.println("**************************************************** ");
	}

	// Switch window by using title
	public void switch_Window_By_Title(String title) {
		driver.switchTo().window(title);
	}

	// Switch window by using window id
	public void switch_Window_By_Window_Id(String window_Id) {
		driver.switchTo().window(window_Id);
	}

	// Switch window by using Url
	public void switch_Window_By_Url(String url) {
		driver.switchTo().window(url);
	}

	// Switch window by using index
	public void switch_Window_By_Window_Id(int index) {

		// To get all the window id
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		List<String> li = new LinkedList<String>();
		li.addAll(allWindows);

		driver.switchTo().window(li.get(index));
	}

	// Switch window by using count variable
	public void switch_Window_By_Window_Count() {
		int count = 0;
		// To get all the window id
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("All opended Window Id's are : " + allWindows);
		System.out.println(count);
		for (String eachWindow : allWindows) {
			if (count == 1) {
				driver.switchTo().window(eachWindow);
				break;
			}
			count++;
		}
	}

	// To insert value in the text by using java script
	public void js_Send_Keys_Set_Attribute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','uma@gmail.com')", e);
	}

	// To click the button by using java script
	public void js_Click(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);
	}

	// To get the attribute value by using java script
	public void js_Get_Attribute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript("return arguments[0].getAttribute('value')", e);
		System.out.println(text);
	}

	// To insert value in the text by using java script
	public void js_Send_Keys_Set_Attribute(String arg, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(arg, e);
	}

	// To click the button by using java script
	public static void js_Click(String arg, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(arg, e);
	}

	// To get the attribute value by using java script
	public static void js_Get_Attribute(String arg, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript(arg, e);
		System.out.println(text);
	}

	// To get data from excel
	public static String getData(int rowNo, int cellNo, String sheetName, String loc) throws IOException {
		String data = null;
		File excelLoc = new File(loc);
		FileInputStream stream = new FileInputStream(excelLoc);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row r = sheet.getRow(rowNo);
		Cell cell = r.getCell(cellNo);
		int type = cell.getCellType();
		if (type == 1) {
			data = cell.getStringCellValue();
		}
		if (type == 0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
				data = simpleDate.format(date);
			} else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				data = String.valueOf(l);
			}

		}
		return data;
	}

	// Booking Confirmation

	public static void updateData(int rowNo, int cellNo, String sheetName, String value) throws IOException {
		// File excelLoc = new
		// File("C:\\Users\\umapa\\Desktop\\Frameworks\\FrameworkClass\\Excel\\Adactin
		// Data.xlsx");
		// Workbook workbook = new XSSFWorkbook();
		// // Create sheet
		// Sheet s = workbook.createSheet(sheetName);
		// // Create Row
		// Row r = s.createRow(rowNo);
		// // Create Cell
		// Cell c = r.createCell(cellNo);
		// c.setCellValue(value);

		File excelLoc = new File("C:\\Users\\umapa\\Desktop\\Frameworks\\FrameworkClass\\Excel\\Adactin Data.xlsx");
		FileInputStream stream = new FileInputStream(excelLoc);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row r = sheet.getRow(rowNo);
//		Cell c = r.getCell(cellNo);
		 Cell c = r.createCell(cellNo);
		// String name = c.getStringCellValue();
		// if(name.equals("")) {
		c.setCellValue(value);
		// }
		FileOutputStream fOut = new FileOutputStream(excelLoc);
		workbook.write(fOut);

		System.out.println("Updated "+value+" on row number "+rowNo);

	}
	
	
	public static int getRowCount(String sheetName) throws IOException {
		
		File excelLoc = new File("C:\\Users\\umapa\\Desktop\\Frameworks\\FrameworkClass\\Excel\\Adactin Data.xlsx");
		FileInputStream stream = new FileInputStream(excelLoc);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();	
		return rowCount;
				
	}
	
	public static int getCellCount(String sheetName) throws IOException {
		
		File excelLoc = new File("C:\\Users\\umapa\\Desktop\\Frameworks\\FrameworkClass\\Excel\\Adactin Data.xlsx");
		FileInputStream stream = new FileInputStream(excelLoc);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row r = sheet.getRow(0);
		int cellsCount = r.getPhysicalNumberOfCells();
		return cellsCount;
				
	}


	public static void explicit_WebDriver_Wait(String url) {
		
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.urlContains(url));

	}
}
