package testMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.Homepage;

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
		public Object[][]readData() throws FileNotFoundException, IOException{
			Object[][]testData=getExcelData(getProperty("excel"),"login");
			
			
			return testData;
			
			
		}
		
		
		
		
		
		
	@Test(dataProvider="testdata")
	public void bookingLogin(String first,String last,String mobilr,String city) throws FileNotFoundException, IOException {
		driver.get(getProperty("prod"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();
//		click(home.signIn);
//		setvalue(home.enterEmail,"bhukyamohan11@gmail.com");
//		click(home.submitEmail);
//		waitForElement(home.password);
//		
//		setvalue(home.password,"Bmohan@1506");
//	
		
	System.out.println(first+" "+last);
	
	}
	
}