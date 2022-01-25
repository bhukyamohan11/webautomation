package testmethods;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.Homepage;
import utils.ExcelUtils;

public class BirthdayTest extends BaseClass {
Homepage home= new Homepage(driver);




	
@DataProvider(name= "testdata")
public Object[][]readData(Method m) throws Exception{
	
	Object[][] testData=ExcelUtils.getDataFromExcel(getProperty("excel"), "login", m.getName());
	return testData;
	
}
public void facebook(HashMap<String,String>data) {
	
	Logger=repoter.createTest("Facebook create account");
driver.get("fb");
Logger.info("navigated to website"+driver.getTitle());
click(home.createAccount);
waitForElement(home.firstname);

setvalue(home.firstname,data.get("first"));
setvalue(home.lastname,data.get("last"));
setvalue(home.email,data.get("email"));
setvalue(home.fbpassword,data.get("password"));
//printElementText(home.hotelnames);


	
	
}
	








}






}



