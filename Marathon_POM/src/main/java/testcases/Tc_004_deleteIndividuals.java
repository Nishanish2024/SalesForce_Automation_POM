package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.LoginPage;

public class Tc_004_deleteIndividuals  extends ProjectSpecifiedMethod{
	
	@Test
	public void runDelete() throws InterruptedException {
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
		.chooseDeleteDropdown()
		.confirmDeleteButton();
	}
}
