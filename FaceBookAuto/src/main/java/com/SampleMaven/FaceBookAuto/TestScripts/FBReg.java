package com.SampleMaven.FaceBookAuto.TestScripts;


import org.testng.annotations.Test;

import com.SampleMaven.FaceBookAuto.Helper.Wait.WaitOption;
import com.SampleMaven.FaceBookAuto.TestBase.TestBase;
import com.SampleMaven.FaceBookAuto.pageObjects.FBHomePageObjects;
import com.aventstack.extentreports.Status;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FBReg extends TestBase{
	
	@Test(priority=1)
	  public void myFBRegistrationOne(Method method) throws Exception {
		  test  = extent.createTest(method.getName());
		  ////open app  
		  getApplicationURL("http://www.facebook.com");
		  ////Pagefactory Objects  
		 FBHomePageObjects myObj= new FBHomePageObjects(driver);
		  ///click on create acc
		  myObj.clickCreateNewAccount();
		  test.log(Status.INFO, "click on create new account");
		  
		  //Implicit wait funtionality
		  WaitOption.fnimplicit(driver);
		  
		  //verify first name
		  boolean status=myObj.verifyDisplayedObject(myObj.FirstNameOnFBReg);
		  
		  if(status) {
		  System.out.println("First name is dispalyed");
		  }
		  else {
			  System.out.println("First name is not displayed");
		  }
		  //enabled or not first name
		  status=myObj.verifyEnabledObject(myObj.FirstNameOnFBReg);
		  if(status) {
		  System.out.println("First name is enabled");
		  }
		  else {
			  System.out.println("First name not enabled");
		  }
		  ///enter first name  
		  myObj.enterFirstNameOnFBReg("Pragna");
		  //last name verify
		  status=myObj.verifyDisplayedObject(myObj.LastNameOnFBReg);
		  if(status) {
		  System.out.println("Last name is displayed");
		  }
		  else
		  {
			  System.out.println("Last name is not displayed");
		  }
		  //last name enabled or not
		  status=myObj.verifyEnabledObject(myObj.LastNameOnFBReg);
		  if(status) {
			  System.out.println("Last name is enabled");
		  }else {
			  System.out.println("Last name is not enabled");
		  }
		  myObj.enterLastNameOnFBReg("Tester");
		  myObj.enterEmailOnFBReg("sample12@gmail.com");
		  myObj.enterConfirmEmailonFBReg("sample12@gmail.com");
		  myObj.enterPasswordOnFBReg("password123");
		  
		  //verify select for day
		  status=myObj.verifySelectedObject(myObj.DayOnFBReg);
		  
		  if(status) {
			  System.out.println("Day is selected");
		  }else {
			  System.out.println("Day is not selected");
		  }
		  myObj.selectDayOnFBReg("14");
		  myObj.selectMonthOnFBReg("3");
		  myObj.selectYearOnFBReg("2001");
		  //radio button selected or not
		  status=myObj.verifySelectedObject(myObj.GenderFemaleOnFBReg);
		  System.out.println(status);
		  if(status==true) {
			  System.out.println("Female radio button is selected");
		  }else {
			  System.out.println("Female radio is not selected");
		  }
		  
		  //select female radio button
		  myObj.selectFemaleRadio();
		  
		  //radio button selected or not
		  status=myObj.verifySelectedObject(myObj.GenderFemaleOnFBReg);
		  if(status==true) {
			  System.out.println("Female radio button is selected");
		  }else {
			  System.out.println("Female radio is not selected");
		  }
		  
		  //male radio button 
		  		  
		  if((myObj.GenderMaleOnFBReg).isSelected()) {
			  System.out.println("Male radio button is selected");
		  }else {
			  System.out.println("Male radio is not selected");
		  }
		  //Thread funtionality
		  WaitOption.fnsmallwait();
			  
		  
	  }
	
	
	@Test(priority=2)
	  public void myFBRegistrationTwo(Method method) throws Exception {
		  test  = extent.createTest(method.getName());
		  ////open app  
		  getApplicationURL("http://www.facebook.com");
		  ////Pagefactory Objects  
		 FBHomePageObjects myObj= new FBHomePageObjects(driver);
		  ///click on create acc
		  myObj.clickCreateNewAccount();
		  test.log(Status.INFO, "click on create new account");
		  
		  //Implicit wait funtionality
		  WaitOption.fnimplicit(driver);
		  
		 
		  ///enter first name  
		  myObj.enterFirstNameOnFBReg("SampleTwo");
		  
		  myObj.enterLastNameOnFBReg("Testing2");
		  myObj.enterEmailOnFBReg("registration2@gmail.com");
		  myObj.enterConfirmEmailonFBReg("registration2@gmail.com");
		  myObj.enterPasswordOnFBReg("sample123");
		
		  myObj.selectDayOnFBReg("26");
		  myObj.selectMonthOnFBReg("8");
		  myObj.selectYearOnFBReg("2002");
		  
		  
		  //select female radio button
		  myObj.selectMaleRadio();
		  	  
		  
		  //Thread funtionality
		  WaitOption.fnsmallwait();
			  
		  
	  }
	
		  
	  @BeforeMethod(description="FBReg")
	  public void beforeMethod() {
		  test.info("execution start");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  test.info("execution end");
	  }


}
