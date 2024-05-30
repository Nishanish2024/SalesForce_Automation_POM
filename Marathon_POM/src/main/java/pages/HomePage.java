package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiedMethod;

public class HomePage extends ProjectSpecifiedMethod{
	
	public HomePage(ChromeDriver driver) {
		this.driver =driver;
	}
	public HomePage appLauncher() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		return this;
	}
	
	public AppLaunchPage clickViewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		return new AppLaunchPage(driver);
	}
}
