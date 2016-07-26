package gov.ca.emsa.pulse.e2e_testing.tests;

import org.junit.Test;

import gov.ca.emsa.pulse.e2e_testing.scriptbase.ScriptBase;

public class FunctionalTest extends ScriptBase {

	@Test
	public void root_Accesss() {
		pulse().GoToApplication();
		pulse().acfRegPage().goto_Pulse();
		pulse().acfRegPage().send_UsrName();
		pulse().acfRegPage().send_Password();
		pulse().acfRegPage().click_LoginButton();
		pulse().acfRegPage().accept_Alert();	
		pulse().acfRegPage().click_Acfnotfound();
		pulse().acfRegPage().verify_Errormsg();
		pulse().acfRegPage().send_Name();
		pulse().acfRegPage().send_PhoneNum();
		pulse().acfRegPage().send_Address1();
		pulse().acfRegPage().send_Address2();
		pulse().acfRegPage().send_City();
		pulse().acfRegPage().send_State();
		pulse().acfRegPage().send_Zip();
		pulse().acfRegPage().send_Country();
		pulse().acfRegPage().click_Submit();
		pulse().acfRegPage().click_Logout();
		pulse().GoToApplication();
		pulse().acfRegPage().select_ExistingUser();
		pulse().acfRegPage().click_Submit();
	}
}
