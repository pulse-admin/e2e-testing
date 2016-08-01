package gov.ca.emsa.pulse.e2e_testing.scriptbase;

import org.openqa.selenium.WebDriver;

import gov.ca.emsa.pulse.e2e_testing.pages.AcfRegPage;

public class Application {

	private WebDriver driver;
	private AcfRegPage acfPage;
	
	public Application(WebDriver driver){
		this.driver = driver;
		acfPage = new AcfRegPage(driver);
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	public AcfRegPage acfRegPage(){
		return acfPage;
		
	}
	
	public void GoToApplication(){
		driver.navigate().to(ResourceFactory.getInstance().getProperty("APP_URL").toString());
	}
}
