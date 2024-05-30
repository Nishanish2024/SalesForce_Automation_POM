package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.LoginPage;

public class Tc_003_editIndividuals extends ProjectSpecifiedMethod{
	
	@Test
	public void runEditIndividual() throws InterruptedException {
		new LoginPage(driver)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.appLauncher()
		.clickViewAll()
		.searchIndividual()
		.clickAllItems()
		.clickIndividual()
		.enterIndividualName()
		.chooseEditDropdown()
		.enterSalutation()
		.enterFirstName()
		.saveEditButton();
	}
	
}
