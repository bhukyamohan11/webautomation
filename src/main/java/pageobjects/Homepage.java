package pageobjects;
		
		import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
		public class Homepage {
		public WebDriver driver;

				
				public Homepage(WebDriver driver) {
					
					this.driver= driver;
					PageFactory.initElements(driver, this);
					
					
				}
				
				@FindBy(xpath="//span[normalize-space()='Sign in']")
				public WebElement signIn;
				
				@FindBy(name="username")
				public WebElement enterEmail;
				
				@FindBy(xpath="//button[@type='submit']")
						public WebElement submitEmail;
				
				//@FindBy(xpath="//div[@id='username-note']")
				//public WebElement invaildEmail;

				@FindBy(className="password")
				public WebElement password;
						
				

			


	}


