package com.SampleMaven.FaceBookAuto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstagramPageObjects {
	
public static WebDriver driver;
	
	///////////Login Objects 
	
	////Login email 
	@FindBy(name="email")
	public WebElement LoginEmailOnFBHome;
	
	//Login Password
	@FindBy(name="pass")
	public WebElement LoginPasswordOnFBHome;
	
	//Login button
		@FindBy(name="login")
		public WebElement LoginButtonOnFBHome;
		
		//Create New account
		@FindBy(linkText="Create New Account")
		public WebElement CreateNewAccountOnFBHome;

}
