package testMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.Homepage;
import utils.ExcelUtils;

public class BirthdayTest extends BaseClass {
Homepage home= new Homepage(driver);

	//@Test
//	public void bookingLogin() throws FileNotFoundException, IOException {
//		driver.get(getProperty("prod"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
//		click(home.signIn);
//		setvalue(home.enterEmail,"qwerty");
//		click(home.submitEmail);
//		Assert.assertEquals(home.invaildEmail.isDisplayed(), true);
//		
		@DataProvider(name="testdata")
		public Object[][]readData(Method m) throws FileNotFoundException, IOException{
			Object[][]testData=ExcelUtils.getDataFromExcel(getProperty("excel"),"login",m.getName() );
			
			
			return testData;
		}
		
		@Test(dataProvider="testdata")
		public void facebook(HashMap<String,String>data) throws FileNotFoundException, IOException{
			Logger=repoter.createTest("Facebook create account");
			
		driver.get(getProperty("fb"));
		Logger.info("navigated to website"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		click(home.createAccount);
		waitForElement(home.firstname);
		setvalue(home.firstname,data.get("First"));
		setvalue(home.lastname,data.get("last"));
		setvalue(home.email,data.get("email"));
		setvalue(home.fbpassword,data.get("password"));
		
		
		
		}
		
	@Test(dataProvider="testdata")
	public void bookingLogin(HashMap<String,String>data) throws FileNotFoundException, IOException {
		Logger=repoter.createTest("Booking website login");
		driver.get(getProperty("prod"));
		Logger.info("navigated to website"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		click(home.signIn);
		setvalue(home.enterEmail,"bhukyamohan11@gmail.com");
		click(home.submitEmail);
		waitForElement(home.password);
		
		setvalue(home.password,"Bmohan@1506");
	
		
	//System.out.println(first+" "+last);
	
	}
	
}