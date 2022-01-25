package base;

		import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
	import java.util.Properties;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Loggers;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v96.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org .openqa.selenium.TakesScreenshot;
		public class BaseClass {

			
			
			public static WebDriver driver;
			public static WebDriverWait wait;
			public static ExtentReports repoter;
			public static ExtentTest Logger;
			public static ExtentSparkReporter sparkReporter;
			public static String filepath;
			static {
          System.setProperty("webdriver.chrome.driver", "E:\\webautomation2\\src\\test\\resources\\drivers\\chromedriver.exe");
				
          ChromeOptions options=new ChromeOptions();
          options.addArguments("start-maximized");
          options.addArguments("--incognito");
          options.addArguments("disable-popup-blocking");
          options.addArguments("disable-notification");
          options.addArguments("disable-inforbars");
          
				driver = new ChromeDriver();	
			
			} 
			@BeforeTest
			public void setup() {
				filepath= "Reports/statusReport.html";
				sparkReporter = new ExtentSparkReporter(filepath);
				repoter=new ExtentReports();
				
				repoter.attachReporter(sparkReporter);
				
			}
			
			
			
				public void scrollToElement(WebElement e) {
					((JavascriptExecutor)driver).executeScript("arguments[0].ScrollIntoView(true);",e);
					
					
				}
				
				public static  String[][] getExcelData(String filename,String sheet) throws IOException{
					FileInputStream fis= new FileInputStream(filename);
					XSSFWorkbook wb= new XSSFWorkbook(fis);
					XSSFSheet sh= wb.getSheet(sheet);
					
					int rows= sh.getLastRowNum();
					int cols=sh.getRow(0).getLastCellNum();
					String[][]data=new String[rows][cols];
					
					for(int i=1;i<=rows;i++) {
						for (int j=0; j<cols;j++) {
							
						
					Cell c = sh.getRow(i).getCell(j);
					
							
					DataFormatter dataFormatter = new DataFormatter();
					String value = dataFormatter.formatCellValue(c);
					data[i-1][j]=value;
					
					
						
						}		
					}
					
					return data;
				}
	          
				public void waitForElement(WebElement e) {
					
					wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
					wait.until(ExpectedConditions.visibilityOf(e));
					
				}
				
				
				
				
			public void screenShot() throws IOException {
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			String date= dateFormat.format(new Date());
			
				File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 
				
				FileUtils.copyFile(f, new File("./screenshots/"+date+".png"));
				
			}
			
			
			
			
			public void screenShot(String status,String name) throws IOException {
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				
				String date= dateFormat.format(new Date());
				
					File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					 
					if(status.equalsIgnoreCase("FAILURE")) {
					FileUtils.copyFile(f, new File("./Failurescreenshots/"+date+".png"));
					}
					else if(status.equalsIgnoreCase("success")) {
						
						FileUtils.copyFile(f, new File("./Successscreenshots/"+date+".png"));
					}
			}
			
			@AfterMethod
			public void aftermethod(ITestResult result) throws IOException {
				if(ITestResult.FAILURE==result.getStatus()) {
					screenShot("FAILURE",result.getName());
					Logger.fail("testcase"+result.getName()+"is faild !!!");
				}
				else {
					screenShot("SUCESS",result.getName());
					Logger.info("navigated to website"+driver.getTitle());
				}
				
	
			}
			public String getProperty(String key) throws FileNotFoundException, IOException  {
				Properties prop = new Properties();
				
				
				File f =new File("src/test/resources/application.properties");
				prop.load(new FileInputStream(f));
				return prop.getProperty(key); 
				

				
			}
			
			
			
		public void click(WebElement element) {
			
			element.click();
		
		}

		public void setvalue(WebElement e,String value)	{
			
		}



			public static void switchToFrame(WebElement frame) {
				
				
				
				
				driver.switchTo().frame(frame);
				
			}
			
			public static void defaultcontent() {
				driver.switchTo().defaultContent();
			
			}
			public static void selectElementByvalue(WebElement day,String value) {
				
				Select select = new Select(day);
				
				select.selectByValue(value);
			}
			
			
		public static void selectElementByText(WebElement day,String Text) {
				
				Select select = new Select(day);
				
				select.selectByValue(Text);
			}
			
			public void dragAndDrop(WebElement drag,WebElement drop) {
				
				
				Actions action=new Actions(driver);
				action.dragAndDrop(drag, drop).perform();
			}
			
			public void moveAndclick(WebElement e1,WebElement e2) {
				Actions action = new Actions(driver);
				action.sendKeys(e2,"cakes").perform();
				action.click().build().perform();
					
			}
			
			public void scrollToAnElement(WebElement ele) {
				
				((JavascriptExecutor)driver).executeScript("arguments[0].ScrollIntoView()");
				
				
			}

			
			public void switchTochildwindowcloseparent(String parent) {
				
				Set<String>windows=driver.getWindowHandles();
				{
					for( String window:windows){
					 {
						if(!window.equals(parent));
						driver.switchTo().window(window);
						driver.switchTo().window(parent);
						driver.close();
						driver.switchTo().window(window);
						
					 }
					} 
						
				}
				}
			
			public void newMethod() {
				System.out.println("Git demo");
			}

            @AfterTest(alwaysRun=true)
			public void closeDriver() {
				
            	repoter.flush();
				driver.close();
			}
			
			
			
			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
		}		
			
			
			
			
			
			
			
			
			
			
			
			





		
	


