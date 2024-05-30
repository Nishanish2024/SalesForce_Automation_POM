package base;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecifiedMethod {
	
	public ChromeDriver driver;
		
	@BeforeMethod
	public void preCondition() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		driver = new ChromeDriver(option);

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@DataProvider(name="sendData")
	//To read excel data
	public static String[][] readExcelData(String fileName) throws IOException{
			//set the excel path
			XSSFWorkbook wb = new XSSFWorkbook("./ExcelData/SalesForce_CreateIndividual.xlsx") ; 
			//get the excel sheet
			XSSFSheet sheetAt = wb.getSheetAt(0);
			//get the count of how many rows
			int rowCount = sheetAt.getLastRowNum();
			System.out.println("no of rows: "+ rowCount);
			
			short columnCount = sheetAt.getRow(0).getLastCellNum();
			System.out.println("no of columns: "+ columnCount);
			
			String data[][] = new String[rowCount][columnCount];
			for(int i=1; i<= rowCount; i++) {
				XSSFRow row = sheetAt.getRow(i);
				for(int j=0; j< columnCount; j++) {
					XSSFCell cell = row.getCell(j);
					String cellValue = cell.getStringCellValue();
					System.out.println("cellValue: "+ cellValue);
					data[i-1][j]=cellValue;
				}
			}
			return data;
		}
/*
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
*/
}
