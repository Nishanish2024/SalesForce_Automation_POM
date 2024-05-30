package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiedMethod;

public class DeleteIndividualPage extends ProjectSpecifiedMethod {

	public DeleteIndividualPage(ChromeDriver driver) {
		this.driver =driver;
	}
	public viewIndividualsPage confirmDeleteButton() {
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		 System.out.println(msg);
		 System.out.println("The record is deleted successfully....");
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Kumars",Keys.ENTER);
		
		return new viewIndividualsPage(driver);
	}
}
