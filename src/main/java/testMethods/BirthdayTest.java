package testmethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.util.CellUtil;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.Homepage;
import utils.ExcelUtils;





public  class BirthdayTest extends BaseClass{
Homepage home= new Homepage(driver);
private static final org.apache.logging.log4j.Logger log =LogManager.getLogger(BirthdayTest.class);


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
		public Object[][] readData (Method m) throws FileNotFoundException, IOException {
			Object[][]testData=ExcelUtils.getDataFromExcel(getProperty("excel"),"login",m.getName());
			

			return testData;	
		}
			
				
		@Test(dataProvider="testdata")
		public void facebook(HashMap<String,String>data) throws FileNotFoundException, IOException{
			Logger=repoter.createTest("Facebook create account");
			
		driver.get(getProperty("fb"));
		Logger.info("navigated to website"+driver.getTitle());
		log.debug("navigated to Website"+driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		click(home.createAccount);
		waitForElement(home.firstname);
		setvalue(home.firstname,data.get("First"));
		setvalue(home.lastname,data.get("last"));
		setvalue(home.email,data.get("email"));
		setvalue(home.fbpassword,data.get("password"));
		//waitForElement(home.password);
		 log.debug("enterd account details");
		
		
		}
		

	@Test(dataProvider="testdata",enabled=true)
	public void bookingLogin(HashMap<String,String>data) throws FileNotFoundException, IOException {
		Logger=repoter.createTest("Booking website login");
		driver.get(getProperty("prod"));
		Logger.info("navigated to website"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		click(home.signIn);
		setvalue(home.enterEmail,"bhukyamohan11@gmail.com");
		click(home.submitEmail);
		//waitForElement(home.password);
		
		setvalue(home.password,"Bmohan@1506");





	
//@DataProvider(name= "testdata")
//public Object[][]readData(Method m) throws Exception{
//	
//	Object[][] testData=ExcelUtils.getDataFromExcel(getProperty("excel"), "login", m.getName());
//	return testData;
//	
//}
//public void facebook(HashMap<String,String>data) {
//	
//	Logger=repoter.createTest("Facebook create account");
//driver.get("fb");
//Logger.info("navigated to website"+driver.getTitle());
//click(home.createAccount);
//waitForElement(home.firstname);
//
//setvalue(home.firstname,data.get("first"));
//setvalue(home.lastname,data.get("last"));
//setvalue(home.email,data.get("email"));
//setvalue(home.fbpassword,data.get("password"));
////printElementText(home.hotelnames);


	
	
}
	








}










