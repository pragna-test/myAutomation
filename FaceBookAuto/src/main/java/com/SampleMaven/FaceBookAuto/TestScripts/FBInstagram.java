package com.SampleMaven.FaceBookAuto.TestScripts;

import org.testng.annotations.Test;

import com.SampleMaven.FaceBookAuto.TestBase.TestBase;
import com.aventstack.extentreports.Status;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FBInstagram extends TestBase{
	 @Test
	  public void fbInstagram(Method method) throws InterruptedException {
		  test  = extent.createTest(method.getName());
		  getApplicationURL("http://www.facebook.com");
		  Thread.sleep(3000);
			WebElement instalink=driver.findElement(By.linkText("Instagram"));
			instalink.click();
			System.out.println("instagram link clicked");
			test.log(Status.INFO, "Instagram link clicked");
			
			Thread.sleep(2500);
			
			//Capture title and url
			
			String Instatitle=driver.getTitle();
			System.out.println(Instatitle);
			
			String instaurl=driver.getCurrentUrl();
			System.out.println(instaurl);
			
					
			//Back
			driver.navigate().back();
			System.out.println("browser back clicked");
			Thread.sleep(2000);
			//Capture title and url
			String FbHomeTitle=driver.getTitle();
			System.out.println(FbHomeTitle);
			
			String FBurl=driver.getCurrentUrl();
			System.out.println(FBurl);
		  
	  }
	  @BeforeMethod(description="FbLogin")
	  public void beforeMethod() {
		  test.info("execution start");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  test.info("execution end");
	  }

}
