package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiedMethod;

public class EditIndividuals extends ProjectSpecifiedMethod {
	
	public EditIndividuals(ChromeDriver driver) {
		this.driver =driver;
	}
	public EditIndividuals enterSalutation() {
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
		return this;
	}
	
	public EditIndividuals enterFirstName() {
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Ganesh");
		return this;
	}
	
	public viewIndividualsPage saveEditButton() throws InterruptedException {
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("Edited Successfully...");
		return new viewIndividualsPage(driver);
	}
}
