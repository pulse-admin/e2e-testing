package gov.ca.emsa.pulse.e2e_testing.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(glue = {"gov.ca.emsa.pulse.e2e_testing.steps"},
        features = "C:\\MyDevelopment\\ProjectFolder\\e2e-testing\\src\\test\\resources\\CucumberFeatute\\e2ePractice.feature",
        plugin = {"pretty", "html:target/cucumber-html-report"},
		tags={"@Step1,@Step2,@Step3"})
public class Pulsee2eRunner {

}
