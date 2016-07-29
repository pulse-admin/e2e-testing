package gov.ca.emsa.pulse.e2e_testing.tests;

import java.util.concurrent.Delayed;

import org.junit.Test;

import cucumber.api.java.en_old.Ac;
import gov.ca.emsa.pulse.e2e_testing.pages.AcfRegPage;
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
		pulse().acfRegPage().click_AcfEdit();
		pulse().acfRegPage().verify_EditAcfPage();
		pulse().acfRegPage().send_AcfInfo();
		pulse().acfRegPage().click_SaveAcfEdit();
		pulse().acfRegPage().send_Wrongdob();
		pulse().acfRegPage().submit_query();
		pulse().acfRegPage().query_DobError();
		pulse().acfRegPage().verify_QueryPage();
		pulse().acfRegPage().verify_QueryError();
		pulse().acfRegPage().delayFor(2000);
		pulse().acfRegPage().send_PatientQuery();
		pulse().acfRegPage().pList("Sam", 333);
		pulse().acfRegPage().delete_Button();
	}

}
