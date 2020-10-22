package com.SampleMaven.FaceBookAuto.TestScripts;

import org.testng.annotations.Test;

import com.SampleMaven.FaceBookAuto.Helper.Excel.ExcelUDF;

import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DataReadFromExcel {
	public static WebDriver driver;
	  @Test (priority=1)
	  public void SheetCountAndNames() throws BiffException, IOException {
		  String FileAddress ="C:\\Users\\Pragna\\Desktop\\Practice_Items\\MyTestData.xls";
			
			///sheet Count  
			int sheetC  = ExcelUDF.fnSheetCount(FileAddress);
			System.out.println(sheetC);
			System.out.println(ExcelUDF.fnSheetCount(FileAddress));	
			
			////display sheet names
			String[]  mySheets = ExcelUDF.fnSheetNames(FileAddress);
			System.out.println(mySheets.length);
			for(int i=0; i<mySheets.length; i++)
			{
				System.out.println(mySheets[i]);
			}
			
	  }
	  @Test (priority=2)
	  public void SheetInformation() throws BiffException, IOException, InterruptedException {
		  
		  String FileAddress ="C:\\Users\\Pragna\\Desktop\\Practice_Items\\MyTestData.xls";
	  
			////Excelsheet name  
			String SheetName= "Sheet4";
			
			//Row Count
			System.out.println(ExcelUDF.fnRowCount(FileAddress, SheetName));
			
			//Column Count
			System.out.println(ExcelUDF.fnColCount(FileAddress, SheetName));
			
	  }
			
	  @Test (priority=3)
	  public void FBRegistration() throws BiffException, IOException, InterruptedException {
		  String FileAddress ="C:\\Users\\Pragna\\Desktop\\Practice_Items\\MyTestData.xls";
		  
			////Excelsheet name  
			String SheetName= "Sheet4";
			////create an account
			driver.findElement(By.linkText("Create New Account")).click();
			
			Thread.sleep(2000);
			WebElement fname  = driver.findElement(By.name("firstname"));
			
			////read from excel  
			String  myFName  = ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 0);
			
			fname.sendKeys(myFName);
			
			//Identify the last name
			WebElement lname=driver.findElement(By.name("lastname"));
			
			//read from excel
			String myLName=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 1);
			lname.sendKeys(myLName);
			
			//email
			WebElement myRegemail=driver.findElement(By.name("reg_email__"));
			//read from excel
			String myEmail=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 2);
			myRegemail.sendKeys(myEmail);
			
			//reenter email
			WebElement myReenteremail=driver.findElement(By.name("reg_email_confirmation__"));
			//read from excel
			String myEmailRe=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 3);
			myReenteremail.sendKeys(myEmailRe);
			
			
			//Password
			WebElement myPassword=driver.findElement(By.name("reg_passwd__"));
			//read from excel
			String myPass=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 4);
			myPassword.sendKeys(myPass);
			
			//month
			WebElement mymonth=driver.findElement(By.id("month"));
			//convert to select
			Select myMonSelect=new Select(mymonth);
			//read from excel 
			String myExcelMon=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 5);
			myMonSelect.selectByVisibleText(myExcelMon);
			
			//Date day
			WebElement mydate=driver.findElement(By.name("birthday_day"));
			//convert to select
			Select mydaySelect=new Select(mydate);
			//read from excel 
			String myExcelDay=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 6);
			mydaySelect.selectByValue(myExcelDay);
			
			//Date Year
			WebElement myYear=driver.findElement(By.id("year"));
			//convert to select
			Select myYearSelect=new Select(myYear);
			//read from excel 
			String myExcelYear=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 7);
			myYearSelect.selectByValue(myExcelYear);
			
			//gender radio
			WebElement femaleRadio=driver.findElement(By.xpath("//input[@value='1']"));
			WebElement maleRadio=driver.findElement(By.xpath("//input[@value='2']"));
			WebElement customRadio=driver.findElement(By.xpath("//input[@value='-1']"));
			String genderRadio=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 8);
			if(genderRadio.equalsIgnoreCase("female"))
			{
				femaleRadio.click();
			}
			else if(genderRadio.equalsIgnoreCase("male"))
			{
				maleRadio.click();
			}
			else if(genderRadio.equalsIgnoreCase("custom"))
			{
				customRadio.click();
			}
			else
			{
				System.out.println("Gender value not valid");
			}
		  
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Execution start");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("Execution end");
	  }

	  @BeforeTest
	  public void launchBrowser() {
		//set browser path
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			//create browser instance
			driver=new ChromeDriver();
			//open test appl
			driver.get("http:\\www.facebook.com");
			//maximize
			driver.manage().window().maximize();
		  
	  }

	  @AfterTest
	  public void terminateBrowser() throws Exception{
		  Thread.sleep(3000);
		  driver.close();
		  driver.quit();
		 
	  }


}
