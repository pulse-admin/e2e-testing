package gov.ca.emsa.pulse.e2e_testing.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;

import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.USER_NAME;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.PASS_WORD;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.FIRST_NAME;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.PHONE_NUMBER;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.ADDRESS_LINE1;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.ADDRESS_LINE2;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.CITY;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.STATE;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.ZIP_CODE;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.COUNTRY;
import static gov.ca.emsa.pulse.e2e_testing.scriptbase.ApplicationConstant.SSN;

public class AcfRegPage {
	// HOME PAGE
	public AcfRegPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
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
	
	////////////////////////////////////////////////////

	public void goto_Pulse() {
		goto_Pulse.click();
	}

	public void send_UsrName() {
		usr_Name.clear();
		usr_Name.sendKeys(USER_NAME);
	}

	public void send_Password() {
		pass_Word.clear();
		pass_Word.sendKeys(PASS_WORD);
	}

	public void click_LoginButton() {
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
}
