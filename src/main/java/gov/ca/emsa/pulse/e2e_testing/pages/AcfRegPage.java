package gov.ca.emsa.pulse.e2e_testing.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;

import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.USER_NAME;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.PASS_WORD;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.FIRST_NAME;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.LAST_NAME;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.PHONE_NUMBER;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.ADDRESS_LINE1;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.ADDRESS_LINE2;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.CITY;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.STATE;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.ZIP_CODE;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.COUNTRY;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.DOB;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.SSN;

public class AcfRegPage  {
	public AcfRegPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}
	public void delayFor(int secInMili) {
        try {
            Thread.sleep(secInMili);
        } catch (InterruptedException e) {
        }
    }
	public void highlight(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 2px solid yellow;");
            delayFor(200);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(200);
        }
    }

	private WebDriver driver = null;
	private int TimeoutValue = 30;

	@FindBy(how = How.CSS, using = ".btn.btn-default.btn-block")
	private WebElement goto_Pulse;

	@FindBy(how = How.NAME, using = "j_username")
	private WebElement usr_Name;

	@FindBy(how = How.NAME, using = "j_password")
	private WebElement pass_Word;

	@FindBy(how = How.XPATH, using = "//*[@type='submit']")
	private WebElement login_Button;

	@FindBy(how = How.ID, using = "createNewAcf")
	private WebElement check_Box;

	@FindBy(how = How.CSS, using = ".text-danger.form-control-static.ng-scope")
	private WebElement error_msg;

	@FindBy(how = How.ID, using = "acfName")
	private WebElement name_Box;

	@FindBy(how = How.ID, using = "acfPhoneNumber")
	private WebElement phone_Box;

	@FindBy(how = How.ID, using = "acfStreet1")
	private WebElement address1_Box;

	@FindBy(how = How.ID, using = "acfStreet2")
	private WebElement address2_Box;

	@FindBy(how = How.ID, using = "acfCity")
	private WebElement city_Box;

	@FindBy(how = How.ID, using = "acfState")
	private WebElement state_Box;

	@FindBy(how = How.ID, using = "acfZip")
	private WebElement zip_Box;

	@FindBy(how = How.ID, using = "acfCountry")
	private WebElement country_Box;
	
	@FindBy(how = How.ID, using = "acfSubmit")
	private WebElement submit_Button;
	
	@FindBy(how = How.CSS, using = ".btn.btn-default.navbar-btn")
	private WebElement logout_button;
	
	@FindBy(how = How.ID, using = "selectAcf")
	private WebElement existing_User;
	
	@FindBy(how = How.ID, using = "acfEdit")
	private WebElement save_AcfEdit;
	
	@FindBy(how = How.CSS, using = ".btn.btn-sm.pull-right.ng-scope")
	private WebElement acf_Edit;
	
	@FindBy(how = How.CSS, using = ".col-sm-12.ng-scope>h2")
	private WebElement verify_EditAcfShowed;
	
	@FindBy(how = How.ID, using = "dob")
	private WebElement wrong_Dob;
	
	@FindBy(how = How.ID, using = "queryFormSubmit")
	private WebElement query_SubmitButton;
	
	@FindBy(how = How.XPATH, using = "//li[contains(.,'')]//*/../..//li[contains(.,'')]")
	private List<WebElement> patientList;
	
	public void verify_onePatient(String name, Integer num){
		Map <String, Integer> patientList = new HashMap<>();
	}
	
	@FindBy(how = How.XPATH, using = "//li[contains(.,'Date of Birth is an invalid format (mm/dd/yyyy)')]")
	private WebElement dob_Error;
	
	@FindBy(how = How.XPATH, using = "//ul/li[contains(.,'At least one field must be filled out')]")
	private WebElement query_Error;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(.,'Patient Query')]")
	private WebElement patient_QueryPage;
	
	@FindBy(how = How.ID, using = "firstName")
	private WebElement query_Fname;
	
	@FindBy(how = How.ID, using = "lastName")
	private WebElement query_Lname;
	
	@FindBy(how = How.ID, using = "ssn")
	private WebElement query_SSN;
	
	@FindBy(how = How.XPATH, using = "//td[contains(.,'ACTIVE')]/../..//strong[contains(.,'SSN: ')]/../text()/..")
	private WebElement query_result;
	
	
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	public void goto_Pulse() {
		highlight(goto_Pulse);
		goto_Pulse.click();
	}

	public void send_UsrName() {
		highlight(usr_Name);
		usr_Name.clear();
		usr_Name.sendKeys(USER_NAME);
	}

	public void send_Password() {
		highlight(pass_Word);
		pass_Word.clear();
		pass_Word.sendKeys(PASS_WORD);
	}

	public void click_LoginButton() {
		highlight(login_Button);
		login_Button.click();
	}

	public void accept_Alert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void click_Acfnotfound() {
		if (!check_Box.isSelected()) {
			check_Box.click();
		}
	}

	public void verify_Errormsg() {
		Actions act = new Actions(driver);
		act.moveToElement(submit_Button).build().perform();
		String msg = error_msg.getText();
		String expected = "Field is required";
		System.out.println(msg);
		Assert.assertTrue("Text not found!", msg.contains(expected));
	}

	public void send_Name() {
		name_Box.clear();
		name_Box.sendKeys(FIRST_NAME);
	}

	public void send_PhoneNum() {
		phone_Box.clear();
		phone_Box.sendKeys(PHONE_NUMBER);
	}

	public void send_Address1() {
		address1_Box.clear();
		address1_Box.sendKeys(ADDRESS_LINE1);
	}

	public void send_Address2() {
		address2_Box.clear();
		address2_Box.sendKeys(ADDRESS_LINE2);
	}

	public void send_City() {
		city_Box.clear();
		city_Box.sendKeys(CITY);
	}

	public void send_State() {
		state_Box.clear();
		state_Box.sendKeys(STATE);
	}

	public void send_Zip() {
		zip_Box.clear();
		zip_Box.sendKeys(ZIP_CODE);
	}

	public void send_Country() {
		country_Box.clear();
		country_Box.sendKeys(COUNTRY);
	}

	public void click_Submit() {
		submit_Button.click();
	}

	public void click_Logout(){
		logout_button.click();
	}
	
	public void select_ExistingUser(){
		Select select = new Select(existing_User);
		select.selectByVisibleText("John");
		
	}
	
	
	public void click_AcfEdit(){
		acf_Edit.click();				
}

	
	public void verify_EditAcfPage(){
		String msg = verify_EditAcfShowed.getText();
		System.out.println(msg);
		Assert.assertEquals("Edit current ACF", msg);
	}
	
	public void click_SaveAcfEdit(){
		save_AcfEdit.click();
}
	public void send_Wrongdob(){
		wrong_Dob.clear();
		wrong_Dob.sendKeys(DOB);
		
}
	
	public void submit_query(){
		Actions act = new Actions(driver);
		act.moveToElement(query_SubmitButton).build().perform();
	}
	
	public void query_DobError(){
		String msg = dob_Error.getText();
		System.out.println(msg);
		Assert.assertEquals("Date of Birth is an invalid format (mm/dd/yyyy)", msg);
	}
	public void verify_QueryError(){
		String errormsg = query_Error.getText();
		System.out.println(errormsg);
		Assert.assertEquals("At least one field must be filled out", errormsg);
		
}
	
	public void send_AcfInfo(){
		send_Name();
		send_PhoneNum();
		send_Address1();
		send_Address2();
		send_City();
		send_State();
		send_Zip();
		send_Country();
	}
	
	public void send_PatientQuery(){
		//query_Fname.sendKeys(FIRST_NAME);
		//query_Lname.sendKeys(LAST_NAME);
	    wrong_Dob.clear();
	    query_SSN.sendKeys(SSN);
	}
	
	public void clear_Dobfield(){
		wrong_Dob.clear();
	}
	
	public void query_Search(){
		query_SubmitButton.click();
	}
	
	public void verify_QueryPage(){
		String msg = patient_QueryPage.getText();
		System.out.println(msg);
		Assert.assertEquals("Patient Query", msg);
	}
	
	public void verify_QueryResult(){
		String query = query_result.getText();
		System.out.println(query);
		Assert.assertEquals("SSN: 4563", query);
		
	}
}
