package com.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetUp extends ReadAndWriteTestData{

	protected static WebDriver driver;

//  This Will Store the Project Home Address to Path
	
	String home = System.getProperty("user.dir");
	


	protected void openBrowser() throws InvalidFormatException, IOException {
		
		String URL = "https://www.google.com/webmasters/tools/home?hl=en";
		
		String BrowserName = "Chrome";
		
		String geckoPath =  "/Browser_Driver/geckodriver";
		
		String chromeDrPath =  "/Browser_Driver/chromedriver";
		
		if (BrowserName.equals("Chrome")) {

			System.out.println("===============================================");

			System.out.println("Opening the Chrome Browser");

			System.setProperty("webdriver.chrome.driver", home+chromeDrPath);
			
			ChromeOptions options = new ChromeOptions();

			// Code for disable the Logs

			System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");

			System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");

			options.addArguments("--log-level=3");

			options.addArguments("--silent");

			options.addArguments("disable-infobars");

			options.addArguments("--start-maximized");

			options.addArguments("--disable-logging");

			driver = new ChromeDriver(options);

			driver.manage().window().fullscreen();

			// driver.manage().window().maximize();
			
			driver.manage().timeouts().setScriptTimeout(500, TimeUnit.SECONDS);

			System.out.println("Opening the Url : " + URL);

			driver.get(URL);

		} else {

			System.out.println("===============================================");

			System.out.println("Opening the Firefox Browser");

			System.setProperty("webdriver.gecko.driver", home+geckoPath);

			// This code will store all unwanted Firefox warnings to a file

			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");

			driver = new FirefoxDriver();

			driver.manage().window().fullscreen();

			// driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			System.out.println("Opening the Url : " + URL);

			driver.get(URL);

		}

	}

	protected void closeBrowser() throws InterruptedException {

		System.out.println("Closing the Current Browser ");

		driver.close();
	}

	protected void quitAllBrowser() {

		System.out.println("    ");

		System.out.println("===============================================");

		System.out.println("Closing All the Browsers");

		driver.quit();

	}

	protected void methodSeparation() {

		System.out.println("    ");

		System.out.println("===============================================");

	}
	
	protected void logOut() throws InvalidFormatException, IOException{
		
		String e2mURL = "";
				
		try {
						
			driver.navigate().to(e2mURL);
			
			By logoutBtn = By.xpath("//*[@id and @onclick and @data-rel]");
			
			driver.findElement(logoutBtn).click();
			
		} catch (UnhandledAlertException e) {
			
	    	try {
	    		
		    	Alert alert  = driver.switchTo().alert();  
		    	
		    	String alertMessage = driver.switchTo().alert().getText();  
		    	
		    	System.out.println(alertMessage); 
		    	
	        	alert.accept();

	        	alert.dismiss();
	        	
				By logoutBtn = By.xpath("//*[@id and @onclick and @data-rel]");
	        	
				driver.findElement(logoutBtn).click();
		
			} catch (Exception a) {
				
				System.out.println(a.getMessage());
				
				
			}
			
		}

	}
		
	

}
