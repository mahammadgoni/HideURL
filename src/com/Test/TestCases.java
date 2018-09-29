package com.Test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pages.HomePage;
import com.Utils.BrowserSetUp;

public class TestCases extends BrowserSetUp{
	
	
	// Browser Set Up Method
	@BeforeClass
	public void setUp() throws InterruptedException, InvalidFormatException, IOException {

		openBrowser();

	}

	// Browser Close Method
	@AfterClass
	public void tearDown() {

//		quitAllBrowser();

	}
	
//	@Test
//	public void removeUrlTest() throws IOException, InterruptedException{
//		
//		System.out.println("Executing Url Remove Test Case");
//		
//		new HomePage(driver).removeUrl("email", "pass");
//		
//	}
	
	@Test
	public void newRemoveUrlTest() throws IOException, InterruptedException{
		
		System.out.println("Executing Url Remove Test Case");
		
		new HomePage(driver).newUrlRemoveConsole("email", "pass");
		
	}
	

}
