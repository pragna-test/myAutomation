package com.SampleMaven.FaceBookAuto.TestBase;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.SampleMaven.FaceBookAuto.Utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestBase {
	public static WebDriver driver;
	
	public static ExtentReports extent;
	public static ExtentTest test;
  
  @BeforeMethod
  public void beforeMethod(Method method) 
  {
	  test.log(Status.INFO,method.getName() +" from test base start execution");	  
  }

  @AfterMethod
  public void afterMethod(ITestResult result) throws Exception {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  test.log(Status.FAIL, "Test is Failed " +  result.getName());
		  test.log(Status.FAIL, "Error msg is  " +result.getThrowable());
		  
		  ///screen shot with method name 
		  String ScreenPath  = fnScreenShot(driver, result.getName());
		  
		  test.addScreenCaptureFromPath(ScreenPath);
		  
	  }
	  else if(result.getStatus()==ITestResult.SKIP)
	  {
		  test.log(Status.SKIP, "Test is Skipped " + result.getName());
	  }
	  else if(result.getStatus()==ITestResult.SUCCESS)
	  {
		  test.log(Status.PASS, "Test is passed " + result.getName());
	  } 
	  
	  extent.flush();
  }

  @BeforeClass(alwaysRun=true)
  public void beforeClass() 
  {	  
	  test = extent.createTest(getClass().getSimpleName());
	  /// create browsers and app info
	  setUpBrowser();
	  
	  
  }

  @AfterClass
  public void terminateBrowser() throws Exception {
	  
	  ///close driver 
	  driver.close();
	  
	  //quit driver  
	  driver.quit();
	  Thread.sleep(1000);
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  extent = ExtentManager.getInstance();
  }

  @AfterSuite
  public void afterSuite() {
	  
  }
  
  
  /////////setBrowser
  public static void setUpBrowser()
  {
	  ///set browser path  
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
	  ///create browser instance  
	   driver = new ChromeDriver();
	  
  }
  
  ////call driver wth app
  public static  void getApplicationURL(String appURL)
  {
	  driver.get(appURL);
  }
  
  public static String fnScreenShot(WebDriver driver, String FileName) throws Exception {
		// TODO Auto-generated method stub
		///file name 
		 String  DateName  = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 /// convert  webdriver  to screen shot 
		 TakesScreenshot capScrren  = ((TakesScreenshot) driver);
		 File  ImageSourceFile = capScrren.getScreenshotAs(OutputType.FILE);
		 
		 ////identify the path 
		 
		 String  imagePath  =  System.getProperty("user.dir")+"/Screenshots/"+ FileName+"_"+DateName+".png";
		 
		 /////image path convert to file  
		  File ImageDestFile  =  new File(imagePath);
		  FileUtils.copyFile(ImageSourceFile, ImageDestFile);
		  return imagePath;
	}

}
