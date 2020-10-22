package com.SampleMaven.FaceBookAuto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecoveryPageObjects {
	
public static WebDriver driver;
	
	///////////Login Objects 
	
	////Login email 
	@FindBy(name="email")
	public WebElement LoginEmailOnFBHome;
	
	//Login Password
	@FindBy(name="pass")
	public WebElement LoginPasswordOnFBHome;

}
