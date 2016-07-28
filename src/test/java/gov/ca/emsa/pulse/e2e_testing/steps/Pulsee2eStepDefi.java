package gov.ca.emsa.pulse.e2e_testing.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.ca.emsa.pulse.e2e_testing.scriptbase.BaseCukes;

public class Pulsee2eStepDefi extends BaseCukes{

@Given("^As a user i open the driver$")
public void as_a_user_i_open_the_driver() throws Throwable {
	driver.manage().deleteAllCookies();
}

@When("^As a user i navigate to the \"([^\"]*)\"$")
public void as_a_user_i_navigate_to_the(String arg1) throws Throwable {
	driver.navigate().to(arg1);
	   String url = resources.getProperty("APP_URL");
	   driver.navigate().to(url);
}

@Then("^As a user i click on go to pulse$")
public void as_a_user_i_click_on_go_to_pulse() throws Throwable {
	pulse.acfRegPage().goto_Pulse();
}

@Then("^As a user i put username$")
public void as_a_user_i_put_username() throws Throwable {
	pulse.acfRegPage().send_UsrName();
}

@Then("^As a user i put password$")
public void as_a_user_i_put_password() throws Throwable {
	 pulse.acfRegPage().send_Password();
	   pulse.acfRegPage().click_LoginButton();
	   pulse.acfRegPage().accept_Alert();
}

@Given("^As a user i click on acf not found$")
public void as_a_user_i_click_on_acf_not_found() throws Throwable {
	pulse.acfRegPage().click_Acfnotfound();
}

@When("^Enter new acf show up$")
public void enter_new_acf_show_up() throws Throwable {
	pulse.acfRegPage().verify_Errormsg();
}

@Then("^I put name and all the user information$")
public void i_put_name_and_all_the_user_information() throws Throwable {
	pulse.acfRegPage().send_AcfInfo();
}

@Then("^I click on Submit$")
public void i_click_on_Submit() throws Throwable {
	 pulse.acfRegPage().click_Submit();
}

@Then("^I click on logout$")
public void i_click_on_logout() throws Throwable {
	 pulse.acfRegPage().click_Logout();
}

@Then("^I click on login as a existing acf$")
public void i_click_on_login_as_a_existing_acf() throws Throwable {
	pulse.GoToApplication();
	pulse.acfRegPage().select_ExistingUser();
	pulse.acfRegPage().click_Submit();
}

@Given("^As a user i click on edit acf information$")
public void as_a_user_i_click_on_edit_acf_information() throws Throwable {
	pulse.acfRegPage().click_AcfEdit();
}

@When("^Edit current acf show up$")
public void edit_current_acf_show_up() throws Throwable {
	pulse.acfRegPage().verify_EditAcfPage();
}

@Then("^I put patient information$")
public void i_put_patient_information() throws Throwable {
	pulse.acfRegPage().send_AcfInfo();
}

@Then("^I save all acf information$")
public void i_save_all_acf_information() throws Throwable {
	pulse.acfRegPage().click_SaveAcfEdit();
}

@Given("^As a user i want to put wrong order date of birth$")
public void as_a_user_i_want_to_put_wrong_order_date_of_birth() throws Throwable {
	pulse.acfRegPage().send_Wrongdob();
}

@When("^I try to send wrong date of birth information$")
public void i_try_to_send_wrong_date_of_birth_information() throws Throwable {
	
	pulse.acfRegPage().submit_query();
}

@Then("^I should get an invalid dob format error$")
public void i_should_get_an_invalid_dob_format_error() throws Throwable {
	pulse.acfRegPage().query_DobError();
	pulse.acfRegPage().clear_Dobfield();
}
//////////////////////////////////////////
 

@Given("^As a user i want to verify patient query page$")
public void as_a_user_i_want_to_verify_patient_query_page() throws Throwable {
	pulse.acfRegPage().verify_QueryPage();
}

@When("^I want to verify the error in the bottom$")
public void i_want_to_verify_the_error_in_the_bottom() throws Throwable {
	pulse.acfRegPage().verify_QueryError();
}

@Given("^I enter the patient firstname \"([^\"]*)\" to search$")
public void i_enter_the_patient_firstname_to_search(String firstname) throws Throwable {
	try {
		WebElement fName = driver.findElement(By.id("firstName"));
		fName.sendKeys(firstname);
	} catch (Exception e) {
		
	}
	
}

@Given("^I enter the patient lastname \"([^\"]*)\" to search$")
public void i_enter_the_patient_lastname_to_search(String lastname) throws Throwable {
	try {
		WebElement lName = driver.findElement(By.id("lastName"));
		   lName.sendKeys(lastname);
	} catch (Exception e) {
		
	}
	 
}

@Given("^I enter patient last four \"([^\"]*)\" to search$")
public void i_enter_patient_last_four_to_search(String ssn) throws Throwable {
	try {
		WebElement socialLastFour = driver.findElement(By.id("ssn"));
	    socialLastFour.sendKeys(ssn);
	} catch (Exception e) {
		// TODO: handle exception
	}
	 
}

@Then("^I click on search$")
public void i_click_on_search() throws Throwable {
	 pulse.acfRegPage().query_Search();
}

@Then("^I want to verify the result$")
public void i_want_to_verify_the_result() throws Throwable {
	pulse.acfRegPage().verify_QueryResult();
}
}