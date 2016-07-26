package gov.ca.emsa.pulse.e2e_testing.scriptbase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ResourceFactory {
	private static ResourceFactory instance = null;
	private Properties appProperties;

	private ResourceFactory() {
		appProperties = new Properties();
		try {
			appProperties.load(new FileInputStream(new File("C:\\MyDevelopment\\ProjectFolder\\e2e-testing\\src\\test\\resources\\config\\conf.properties")));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static ResourceFactory getInstance() {
		if (instance == null) {
			instance = new ResourceFactory();
		}
		return instance;
	}
	
	public <T> T getProperty(String key){
		Object value = appProperties.getProperty(key);
        return (T) value;
	}
	 
}
