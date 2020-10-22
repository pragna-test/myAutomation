package com.SampleMaven.FaceBookAuto.Helper.Verification;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectVerification {
	
public static WebDriver driver;
	
	public ObjectVerification(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	///displayed method  
	public boolean  isDisplayed(WebElement myElement)
	{
		try
		{
			myElement.isDisplayed();
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;			
		}
	}
	
	////enabled method  
	public boolean  isEnabled(WebElement myElement)
	{
		try
		{
			myElement.isEnabled();
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;			
		}
		
	}
	
	///selected method 
	public boolean isSelected(WebElement myElement)
	{
		try
		{
			myElement.isSelected();
			return true;
		}
		catch (NoSuchElementException e)
		{
			//System.out.println(e.getMessage());
			return false;			
		}
	}
	

}
