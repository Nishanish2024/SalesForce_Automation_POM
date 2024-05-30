package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiedMethod;

public class LoginPage extends ProjectSpecifiedMethod{
	
	public LoginPage(ChromeDriver driver) {
		this.driver =driver;
	}
	
	public LoginPage enterUserName() {
		driver.findElement(By.id("username")).sendKeys("ranjini.r@testleaf.com");
		return this;
	}
	
	public LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys("Testleaf$4321");
		return this;
	}
	
	public HomePage clickLogin() {
		driver.findElement(By.id("Login")).click();
		return new HomePage(driver);
	}
}
