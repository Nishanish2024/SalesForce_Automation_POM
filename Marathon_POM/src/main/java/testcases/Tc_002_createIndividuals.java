package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.LoginPage;

public class Tc_002_createIndividuals extends ProjectSpecifiedMethod {
	
	@Test
	public void runCreateIndividual() {
		new LoginPage(driver)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.appLauncher()
		.clickViewAll()
		.searchIndividual()
		.clickAllItems()
		.clickIndividual()
		.clickNewIndividual()
		.enterLastName()
		.clickSaveButton();
	}
	
	@DataProvider (name= "sendData")
	public String[][] fetchData() throws IOException{
		
		return readExcelData("SalesForce_CreateIndividual");	
	}
	
}
