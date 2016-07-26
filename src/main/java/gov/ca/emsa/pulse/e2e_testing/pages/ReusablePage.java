package gov.ca.emsa.pulse.e2e_testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import gov.ca.emsa.pulse.e2e_testing.scriptbase.Application;
import gov.ca.emsa.pulse.e2e_testing.scriptbase.DriverFactory;
import gov.ca.emsa.pulse.e2e_testing.scriptbase.ResourceFactory;

public class ReusablePage {
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	protected ResourceFactory resources = ResourceFactory.getInstance();
	protected Application pulse = new Application(driver);

}
