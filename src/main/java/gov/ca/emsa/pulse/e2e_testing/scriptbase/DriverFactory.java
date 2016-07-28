package gov.ca.emsa.pulse.e2e_testing.scriptbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.REMOTE_URL;

import java.net.MalformedURLException;
import java.net.URL;


	public class DriverFactory {

	private DriverFactory(){
		 
	}
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance(){
		
		return instance;
		
	}

	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
		
		@Override
		protected WebDriver initialValue(){
			String driverName = ResourceFactory.getInstance().getProperty("DRIVER").toString();
			DesiredCapabilities caps = new DesiredCapabilities();
			
			if (driverName.toUpperCase().contentEquals("CHROME")){
			    ChromeDriverManager.getInstance().setup();
				return new ChromeDriver();
				
			}else if (driverName.toUpperCase().contentEquals("HTML")){
				return new HtmlUnitDriver();
				
			}else if(driverName.toUpperCase().contentEquals("FIREFOX")){
				return new FirefoxDriver();
			}
			else if(driverName.toUpperCase().contentEquals("RD-IE")){
				 	caps.setCapability("browser", "IE");
	                caps.setCapability("browser_version", "11.0");
	                caps.setCapability("os", "Windows");
	                caps.setCapability("os_version", "10");
	                caps.setCapability("resolution", "1280x1024");

	                caps.setCapability("browserstack.debug", "true");
	                
	               WebDriver driver = null;
	               
	              try {
	            	  driver = new RemoteWebDriver(new URL(REMOTE_URL), caps);
				} catch(MalformedURLException e) {
	                e.printStackTrace();
	            }
	              return driver;
			}
			else{
			return new FirefoxDriver();
			}
		}
		
	};
	
	public WebDriver getDriver(){
		return driver.get();
		
	}

	public void removeDriver(){
		driver.get().quit();
		driver.remove();
	}
}
