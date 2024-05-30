package marathon3;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class CreateIndividualsMain {
	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * "Test Steps:
		1. Login to https://login.salesforce.com
		2. Click on the toggle menu button from the left corner
		3. Click View All and click Individuals from App Launcher
		4. Click on the Dropdown icon in the Individuals tab
		5. Click on New Individual
		6. Enter the Last Name as 'Kumar'
		7.Click save and verify Individuals Name"

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
		//click new
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Kumar");
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		System.out.println("New Individual Kumar is Saved Successfully... ");
		
		//driver.close();
	}

}
