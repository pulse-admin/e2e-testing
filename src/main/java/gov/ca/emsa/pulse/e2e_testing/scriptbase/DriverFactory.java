package gov.ca.emsa.pulse.e2e_testing.scriptbase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

	private DriverFactory(){
		 //Do not allow to initialize this class from outside
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance(){
		return instance;
		
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
			// thread local driver object for webdriver
	
	};
}
