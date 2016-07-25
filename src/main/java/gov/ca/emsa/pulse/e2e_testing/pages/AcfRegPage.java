package gov.ca.emsa.pulse.e2e_testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AcfRegPage {
//HOME PAGE
	public AcfRegPage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}
	private WebDriver driver = null;
	private int TimeoutValue = 20;
}
