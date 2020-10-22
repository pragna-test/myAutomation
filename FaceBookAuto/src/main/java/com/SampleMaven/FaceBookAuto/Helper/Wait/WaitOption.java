package com.SampleMaven.FaceBookAuto.Helper.Wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WaitOption {
	
	public static WebDriver driver;
	
	public static void fnimplicit(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void fnsmallwait() throws InterruptedException
	{
		Thread.sleep(5000);
	}

}
