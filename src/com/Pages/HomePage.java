package com.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.BaseSetup.BaseSetUp;

public class HomePage extends BaseSetUp{
	
//	Sing In Elelments
	
	String URL = "https://www.google.com/webmasters/tools/url-removal?hl=en&authuser=2&siteUrl=https://www.ipi-singapore.org/";
	
	By emailId = By.xpath("//*[@id='identifierId']");
	
	By nextBtn = By.xpath("//div[@id='identifierNext']");
	
	By pass = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
	
	By passNext = By.xpath("//div[@id='passwordNext']");
	
	By signInBtn = By.xpath("//*[@id='gb_70']");
	
	By logoutBtn = By.xpath("//*[@id='top1_Logout'][@class='tm-logout']");
	
	By tempHideBtn = By.xpath("//*[@id='create-removal_button']/div");
	
	By inputUrlBox = By.xpath("//input[@id='urlt']");
	
	By continueBtn = By.xpath("//input[@value='Continue']");
	
	By submitBtn = By.xpath("//input[@id='submit-button']");
	
	By status = By.xpath("//span[@class='status-message-text']");
	
	
	String home = System.getProperty("user.dir");
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	public void login(String UserName,String Pass) throws InterruptedException{
		
		System.out.println("Clicking on Sign in Button");
		
		waitForClickabilityOf(signInBtn);
		
		driver.findElement(signInBtn).click();
		
		Thread.sleep(2000);
		
		System.out.println("Entering Email id ");
		
		waitForClickabilityOf(emailId);
		
		driver.findElement(emailId).clear();
		
		driver.findElement(emailId).sendKeys(UserName);
		
		Thread.sleep(2000);
		
		System.out.println("Clicking on Next Button");
		
		waitForClickabilityOf(nextBtn);
		
		driver.findElement(nextBtn).click();
		
		Thread.sleep(2000);
				
		System.out.println("Entering Password");
				
		waitForClickabilityOf(pass);
		
		driver.findElement(pass).clear();
		
		driver.findElement(pass).sendKeys(Pass);
		
		Thread.sleep(2000);
		
		System.out.println("Clicking on Next Button");
		
		waitForClickabilityOf(passNext);
		
		driver.findElement(passNext).click();
		
		Thread.sleep(2000);
		
		driver.navigate().to(URL);
		
		Thread.sleep(2000);
		

		
	}
	
	@SuppressWarnings("resource")
	public HomePage removeUrl(String UserName,String Pass) throws IOException, InterruptedException{
		
		login(UserName, Pass);
		
		Thread.sleep(2000);
		
		File file = new File(home+"/TestData/ipi-path-urls.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet s  = wb.getSheetAt(0);
		
//		Workbook wb = new XSSFWorkbook(fis);
//		
//		Sheet s = wb.getSheet("URLs-for-Removal");
		
		int rowCount = s.getLastRowNum() - s.getFirstRowNum();
		
		for (int i = 0; i < rowCount+1; i++) {
			
			Row row = s.getRow(i);
			
			Cell cell  = row.getCell(0);
			
			String CellUrl = cell.getStringCellValue();
			
//			Command to Enter Url In that Box
			
			Thread.sleep(2000);
			
			System.out.println("Clicking On Temporarliy Button");
			
			waitForClickabilityOf(tempHideBtn);
			
			driver.findElement(tempHideBtn).click();
			
			Thread.sleep(2000);
			
			System.out.println("Entering the URl : "+CellUrl);
			
			waitForClickabilityOf(inputUrlBox);
			
			driver.findElement(inputUrlBox).sendKeys(CellUrl);
			
			Thread.sleep(2000);
			
			System.out.println("Clicking on Continue Button");
			
			waitForClickabilityOf(continueBtn);
			
			driver.findElement(continueBtn).click();
			
			Thread.sleep(2000);
			
			System.out.println("Clicking on Submit Button");
			
			waitForClickabilityOf(submitBtn);
			
			driver.findElement(submitBtn).click();
			
			Thread.sleep(2000);
			
			waitForClickabilityOf(status);
			
			String Message = driver.findElement(status).getText();
			
			System.out.println(Message);
			
			
			
		}
		
		System.out.println("Removed All Url");
		
		
		
		
		return new HomePage(driver);
		
	}
	

	
	
	
	

}
