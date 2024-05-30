package marathon3;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class EditIndividualsMain {
	public static void main(String[] args) throws InterruptedException {
		/*
		 * "Test Steps:
1. Login to https://login.salesforce.com
2. Click on the toggle menu button from the left corner
3. Click View All and click Individuals from App Launcher 
4. Click on the Individuals tab 
5. Search the Individuals 'Kumar'
6. Click on the Dropdown icon and Select Edit
7.Select Salutation as 'Mr'
8.Enter the first name as 'Ganesh'.
9. Click on Save and Verify the first name as 'Ganesh'"

		 */
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("ranjini.r@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$4321");
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//searching for individuals
		WebElement searchIndiv = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input"));
		searchIndiv.sendKeys("individuals");
		
		//All Items
	
		Actions action = new Actions(driver);	
		WebElement allItems = driver.findElement(By.xpath("(//span[@class='slds-accordion__summary-content'])[2]"));
		action.moveToElement(allItems).perform();
		
		//click Individuals
		driver.findElement(By.xpath("//mark[text()='Individuals']/parent::p")).click();
		Thread.sleep(3000);
		
		//--------------EDIT---------------
		//Search for individual ='Kumar'
		WebElement name =driver.findElement(By.xpath("//input[@name='Individual-search-input']"));
		name.sendKeys("Kumars");
		name.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		//.sendKeys("Kumars",Keys.ENTER);
		WebElement ele = driver.findElement(By.xpath("//div[@class='forceVirtualActionMarker forceVirtualAction']/a[@role='button']"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click();", edit);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[text()='Mr.']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'firstName')]")).sendKeys("Ganesh");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(2000);
		System.out.println("Edited Successfully...");
		String msg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
	   //Verify the first name as 'Ganesh'
	}


}
