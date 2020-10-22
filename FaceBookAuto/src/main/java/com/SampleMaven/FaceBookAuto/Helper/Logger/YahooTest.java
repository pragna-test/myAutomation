package com.SampleMaven.FaceBookAuto.Helper.Logger;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.sql.Driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class YahooTest {
	public static Logger log=Logger.getLogger(YahooTest.class);
	public WebDriver driver;
	
  @Test
  public void yahooSignIn() throws InterruptedException {
	  	
			// TODO Auto-generated method stub
			
			//click sign in
			WebElement signinlink= driver.findElement(By.xpath("//a[@id='header-signin-link']/span"));
			signinlink.click();
			log.info("Sign In link clicked");
			Thread.sleep(4000);
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  log.info("Method started");
  }

  @AfterMethod
  public void afterMethod() {
	  log.info("Method ended");
  }

  @BeforeTest
  public void launchBrowser() {
	    //browser path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		//browser instance
		driver=new ChromeDriver();
		//test appl
		driver.get("http:\\www.yahoo.com");
		//maximize
		driver.manage().window().maximize();
		log.info("Yahoo page opened");
	  
  }

  @AfterTest
  public void termminateBrowser() {
	  //close and quit browser
	  driver.quit();
  }

}
