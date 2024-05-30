package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecifiedMethod;

public class viewIndividualsPage extends ProjectSpecifiedMethod{
	
	public viewIndividualsPage(ChromeDriver driver) {
		this.driver =driver;
	}
	
	public CreateIndividuals clickNewIndividual() {
		driver.findElement(By.xpath("//div[@title='New']")).click();
		return new CreateIndividuals(driver);	
	}
	
	public viewIndividualsPage enterIndividualName() throws InterruptedException{
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys("Kumars");
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	
	public EditIndividuals chooseEditDropdown() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
		return new EditIndividuals(driver);
	}
	
	public DeleteIndividualPage chooseDeleteDropdown() throws InterruptedException {
		WebElement pop = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", pop);
		Thread.sleep(2000);
		WebElement delete = driver.findElement(By.xpath("//a[@role='menuitem']/div[@title='Delete']"));
		driver.executeScript("arguments[0].click();", delete);
		
		return new DeleteIndividualPage(driver);
	}

}
