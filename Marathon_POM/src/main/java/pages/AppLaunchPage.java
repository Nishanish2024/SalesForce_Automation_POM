package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.ProjectSpecifiedMethod;

public class AppLaunchPage extends ProjectSpecifiedMethod {
	
	public AppLaunchPage(ChromeDriver driver) {
		this.driver =driver;
	}
	
	public AppLaunchPage searchIndividual() {
		//searching for individuals
		WebElement searchIndiv = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input"));
		searchIndiv.sendKeys("individuals");
		return this;
	}
	
	public AppLaunchPage clickAllItems() {
		Actions action = new Actions(driver);	
		WebElement allItems = driver.findElement(By.xpath("(//span[@class='slds-accordion__summary-content'])[2]"));
		action.moveToElement(allItems).perform();	
		return this;
	}
	
	public viewIndividualsPage clickIndividual() {
		driver.findElement(By.xpath("//mark[text()='Individuals']/parent::p")).click();
		return new viewIndividualsPage(driver);
	}
}
