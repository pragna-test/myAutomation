package com.SampleMaven.FaceBookAuto.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.SampleMaven.FaceBookAuto.Helper.Verification.ObjectVerification;

public class FBHomePageObjects {
	
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
	
	//Forgot password
	@FindBy(linkText="Forgotten account?")
	public WebElement ForgotAccountOnFBHome;
	
	//Instagram Link
	@FindBy(linkText="Instagram")
	public WebElement InstagramOnFBHome;
	
	//People Link
	@FindBy(linkText="People")
	public WebElement PeopleOnFBHome;
	
	////Registration Form Objects
	//First name
	@FindBy(name="firstname")
	public WebElement FirstNameOnFBReg;
	
	//LastName
	@FindBy(name="lastname")
	public WebElement LastNameOnFBReg;
	
	//Email
	@FindBy(name="reg_email__")
	public WebElement EmailOnFBReg;
	
	//Confirm Email
	@FindBy(name="reg_email_confirmation__")
	public WebElement ConfirmEmailOnFBReg;
	
	//Password
	@FindBy(name="reg_passwd__")
	public WebElement PasswordOnFBReg;
	
	//Day
	@FindBy(id="day")
	public WebElement DayOnFBReg;
	
	//Month
	@FindBy(id="month")
	public WebElement MonthOnFBReg;
	
	//Year
	@FindBy(id="year")
	public WebElement YearOnFBReg;
	
	//Gender Radio-female
	@FindBy(xpath="//input[@value='1']")
	public WebElement GenderFemaleOnFBReg;
	
	//Gender Radio-male
	@FindBy(xpath="//input[@value='2']")
	public WebElement GenderMaleOnFBReg;
	
	//Gender Radio-custom
	@FindBy(xpath="//input[@value='-1']")
	public WebElement GenderCustomOnFBReg;

	
	
	///page initialize  
	public FBHomePageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	////////develop methods
	
	///enter login email 
	public void enterLoginEmailOnFBHome(String LoginEmail)
	{
		LoginEmailOnFBHome.sendKeys(LoginEmail);
	}
	
	///clear login email 
	public void clearLoginEmailOnFBHome()
	{
		LoginEmailOnFBHome.clear();
	}
	//enter password
	public void enterLoginPasswordOnFBHome(String LoginPassword)
	{
		LoginPasswordOnFBHome.sendKeys(LoginPassword);
	}
	//clear password
	public void clearLoginPasswordOnFBHome()
	{
		LoginPasswordOnFBHome.clear();
	}
	//CLick on login button
	public void clickLoginButtonOnFBHome()
	{
		LoginButtonOnFBHome.click();
	}
	
	//click on create new account
	public void clickCreateNewAccount()
	{
		CreateNewAccountOnFBHome.click();
	}
	
	//ForgotAccount
	public void clickForgotAccount()
	{
		ForgotAccountOnFBHome.click();
	}
	
	//instagram click
	public void clickInstagram()
	{
		InstagramOnFBHome.click();
	}
	
	//People click
	public void clickPeople()
	{
		PeopleOnFBHome.click();
	}
	
	//methods for FBReg
	//first name onFBReg
	public void enterFirstNameOnFBReg(String FirstName)
	{
		FirstNameOnFBReg.sendKeys(FirstName);
	}
	
	public void clearFirstNameOnFBReg()
	{
		FirstNameOnFBReg.clear();
	}
	
	//last name
	public void enterLastNameOnFBReg(String LastName)
	{
		LastNameOnFBReg.sendKeys(LastName);
	}
	public void clearLastNameOnFBReg()
	{
		LastNameOnFBReg.clear();
	}
	
	//email 
	public void enterEmailOnFBReg(String RegEmail)
	{
		EmailOnFBReg.sendKeys(RegEmail);
	}
	
	public void clearEmailOnFBReg()
	{
		EmailOnFBReg.clear();
	}
	
	//confirm email
	public void enterConfirmEmailonFBReg(String ConfirmEmail)
	{
		ConfirmEmailOnFBReg.sendKeys(ConfirmEmail);
	}
	
	public void clearConfirmEmailOnFBReg()
	{
		ConfirmEmailOnFBReg.clear();
	}
	
	//password
	public void enterPasswordOnFBReg(String RegPassword)
	{
		PasswordOnFBReg.sendKeys(RegPassword);
	}
	
	public void clearPasswordOnFBReg()
	{
		PasswordOnFBReg.clear();
	}
	
	//Day
	public void selectDayOnFBReg(String day)
	{
		Select daySelect=new Select(DayOnFBReg);
		daySelect.selectByValue(day);
	}
	
	//month
	public void selectMonthOnFBReg(String month)
	{
		Select monthSelect=new Select(MonthOnFBReg);
		monthSelect.selectByValue(month);
	}
	
	//year
	public void selectYearOnFBReg(String year)
	{
		Select yearSelect=new Select(YearOnFBReg);
		yearSelect.selectByValue(year);
	}
	
	//Gender female radio
	public void selectFemaleRadio()
	{
		GenderFemaleOnFBReg.click();
	}
	
	//male radio
	public void selectMaleRadio()
	{
		GenderMaleOnFBReg.click();
	}
	
	//custom radio
	public void selectCustomRadio()
	{
		GenderCustomOnFBReg.click();
	}
	
	public void selectGenderRadio(String genderRadio)
	{
		if (genderRadio.equalsIgnoreCase("female"))
		{
			GenderFemaleOnFBReg.click();
		}
		else if(genderRadio.equalsIgnoreCase("male"))
		{
			GenderMaleOnFBReg.click();
		}
		else if(genderRadio.equalsIgnoreCase("custom"))
		{
			GenderCustomOnFBReg.click();
		}
		else
		{
			System.out.println("Gender radio not valid");
		}
	}
	
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
	
	
	
	
	//////////login objects verification  
	/////login email  exist or not   
	/*public boolean verifyDisplayedLoginEmailOnFBHome()
	{
		boolean  status = new ObjectVerification(myDriver).isDisplayed(LoginEmailOnFBHome);
		
		 return  status;
	}
	
	///login email enabled or not  
	public boolean  verifyEnabledLoginEmailOnFBHome()
	{
		boolean status  = new ObjectVerification(myDriver).isEnabled(LoginEmailOnFBHome);
		return status;
	}
	
	/////login Pwd  exist or not   
	public boolean verifyDisplayedLoginPwdOnFBHome()
	{
		boolean  status = new ObjectVerification(myDriver).isDisplayed(LoginPasswordOnFBHome);
		
		 return  status;
	}
	
	///login pwd enabled or not  
	public boolean  verifyEnabledLoginPwdOnFBHome()
	{
		boolean status  = new ObjectVerification(myDriver).isEnabled(LoginPasswordOnFBHome);
		return status;
	}*/
	//display method common for all objects
	
	public boolean verifyDisplayedObject(WebElement myElement)
	{
		boolean  status = new ObjectVerification(driver).isDisplayed(myElement);
		
		 return  status;
	}
	
	//enable method common for all objects
	public boolean verifyEnabledObject(WebElement myElement)
	{
		boolean status = new ObjectVerification(driver).isEnabled(myElement);
		return status;
	}
	
	//select method common for all objects
	public boolean verifySelectedObject(WebElement myElement)
	{
		boolean status=new ObjectVerification(driver).isSelected(myElement);
		return status;
	}

	///login process
	public void loginProcess(String LoginEmail, String LoginPassword)
	{
		this.enterLoginEmailOnFBHome(LoginEmail);
		this.enterLoginPasswordOnFBHome(LoginPassword);
		this.clickLoginButtonOnFBHome();
		
	}
	
	
	
	
	
	//////script  
	/////Registration
	public void  fbRegistration()
	{
		FirstNameOnFBReg.sendKeys("test");
	}

}
