package gov.ca.emsa.pulse.e2e_testing.steps;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;

import gov.ca.emsa.pulse.e2e_testing.scriptbase.DriverFactory;

public class BeforeAfterSteps {

	@Before
	public void before_Steps() throws Exception{
		DriverFactory.getInstance().getDriver().manage().deleteAllCookies();
		DriverFactory.getInstance().getDriver().manage().window().getSize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
	}
	
	@After
	public void after_Steps()throws Exception{
		DriverFactory.getInstance().getDriver().close();
		DriverFactory.getInstance().getDriver().quit();
		DriverFactory.getInstance().removeDriver();
	}
}
