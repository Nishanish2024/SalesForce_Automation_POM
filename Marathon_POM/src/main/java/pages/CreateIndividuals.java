package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiedMethod;

public class CreateIndividuals extends ProjectSpecifiedMethod {
	
	public CreateIndividuals(ChromeDriver driver) {
		this.driver =driver;
	}
	
	public CreateIndividuals enterLastName() {
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Kumar");
		return this;
	}
	
	public viewIndividualsPage clickSaveButton() {
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		System.out.println("New Individual Kumar is Saved Successfully... ");
		return new viewIndividualsPage(driver);
	}
}
