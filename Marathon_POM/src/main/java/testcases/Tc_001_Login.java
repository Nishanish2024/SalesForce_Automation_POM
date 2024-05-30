package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecifiedMethod;
import pages.LoginPage;

public class Tc_001_Login extends ProjectSpecifiedMethod{
	
	public void runlogin() {
		LoginPage LP = new LoginPage(driver);
		LP.enterUserName()
		.enterPassword()
		.clickLogin();
	}
}
