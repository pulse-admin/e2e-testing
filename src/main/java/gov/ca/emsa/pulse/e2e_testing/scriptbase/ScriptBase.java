package gov.ca.emsa.pulse.e2e_testing.scriptbase;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;



public class ScriptBase {
	
	protected WebDriver driver = null;
	private ThreadLocal<Application> threadApplication = null;

	
	@Before
	public void startUp() {
		driver = DriverFactory.getInstance().getDriver();
		threadApplication = new ThreadLocal<Application>() {

			@Override
			protected Application initialValue() {
				return new Application(DriverFactory.getInstance().getDriver());
			}
		};
	}

	public Application pulse() {
		return threadApplication.get();

	}

	@After
	public void tearDown() {
		//DriverFactory.getInstance().removeDriver();
	}
}
