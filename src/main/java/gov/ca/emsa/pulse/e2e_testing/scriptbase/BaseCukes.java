package gov.ca.emsa.pulse.e2e_testing.scriptbase;

import org.openqa.selenium.WebDriver;

public class BaseCukes {
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	protected ResourceFactory resources = ResourceFactory.getInstance();
	protected Application pulse = new Application(driver);

}
