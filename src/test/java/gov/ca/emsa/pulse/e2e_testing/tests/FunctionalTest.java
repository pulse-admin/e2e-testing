package gov.ca.emsa.pulse.e2e_testing.tests;

import org.junit.Test;

import gov.ca.emsa.pulse.e2e_testing.scriptbase.ScriptBase;

public class FunctionalTest extends ScriptBase {

@Test
public void root_Accesss(){
	pulse().acfRegPage().getClass();
}
	
@Test
public void newAcf_Login(){
	
}

@Test
public void existingAcf_Login(){
	
}
}
