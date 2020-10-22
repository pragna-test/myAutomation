package com.SampleMaven.FaceBookAuto.TestScripts;

import org.testng.annotations.Test;

import com.SampleMaven.FaceBookAuto.Helper.DataBase.DataBaseUDF;
import com.SampleMaven.FaceBookAuto.Helper.Excel.ExcelUDF;
import com.SampleMaven.FaceBookAuto.TestBase.TestBase;
import com.SampleMaven.FaceBookAuto.pageObjects.FBHomePageObjects;
import com.aventstack.extentreports.Status;

import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FBLogin extends TestBase{
	  @Test (priority=1)
	  //Data from Excel
	  public void FbLoginOne(Method method) throws InterruptedException, BiffException, IOException {
		  String FileAddress ="C:\\Users\\Pragna\\Desktop\\Practice_Items\\MyTestData.xls";
		  
			////Excelsheet name  
			String SheetName= "Sheet3";
		  //create test
		  test  = extent.createTest(method.getName());
		  ////open app  
		  getApplicationURL("http://www.facebook.com");
		  
		  //Page factory
		  FBHomePageObjects myobj=new FBHomePageObjects(driver);
		  
		  String loginemail=ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 0);
		  
		  //enter email and password
		 myobj.enterLoginEmailOnFBHome(loginemail);
		  
		  test.log(Status.INFO, "Email entered");
		  
		  myobj.enterLoginPasswordOnFBHome(ExcelUDF.fnReadFromExcel(FileAddress, SheetName, 1, 1));
		  test.log(Status.INFO, "Password entered");
		  Thread.sleep(2000);
		  
		  myobj.clearLoginEmailOnFBHome();
		  myobj.clearLoginPasswordOnFBHome();
		
		  
	  }
	  
	  @Test (priority=2, groups={"smoke"})
	  //Direct data
	  public void FbLoginTwo(Method method) throws InterruptedException {
		  //create test
		  test  = extent.createTest(method.getName());
		  ////open app  
		  getApplicationURL("http://www.facebook.com");
	///	  Assert.assertEquals(driver.getTitle(), "xyz");

		  
		  //Page factory
		  FBHomePageObjects myobj=new FBHomePageObjects(driver);
		  
		  //enter email and password
		  myobj.enterLoginEmailOnFBHome("abc123@abc.com");
		  test.log(Status.INFO, "Email entered");
		  myobj.enterLoginPasswordOnFBHome("Newpassword12");
		  test.log(Status.INFO, "Password entered");
		  Thread.sleep(2000);
		  
	  }
	  
	  @Test (priority=3)
	  //Data from Database
	  public void FbLoginThree(Method method) throws InterruptedException, ClassNotFoundException, SQLException {
		  //create test
		  test  = extent.createTest(method.getName());
		  ////open app  
		  getApplicationURL("http://www.facebook.com");
		//Page factory
		  FBHomePageObjects myobj=new FBHomePageObjects(driver);
		  
		  String DriverName="com.mysql.cj.jdbc.Driver";
		 // String DriverName="com.mysql.jdbc.Driver";
		//DB URL
			String dburl="JDBC:MYSQL://localhost:3306/facebookauto?useSSL=false";
			
			//Login details
			String username="root";
			String password="AdminPwd";
			//Sql statement
			String query="select * from fblogin";
			
			//Class.forName(DriverName);
			//create connection to DB
			Connection con=DataBaseUDF.fnConnection(DriverName, dburl, username, password);
				
			
			
			//execute the sql query and store the results in resultset
			ResultSet myrs2=DataBaseUDF.fnResultSet2(con, query);
			
		while(myrs2.next())
			{
				myobj.enterLoginEmailOnFBHome(myrs2.getString("loginemail"));
				  test.log(Status.INFO, "Email entered");
				  myobj.enterLoginPasswordOnFBHome(myrs2.getString("loginpassword"));
				  test.log(Status.INFO, "Password entered");
				  Thread.sleep(2000);
				  myobj.clearLoginEmailOnFBHome();
				  myobj.clearLoginPasswordOnFBHome();
				
			}
			
					  
		  
	  }
	  
	  
	  
	  @BeforeMethod(description="FbLogin")
	  public void beforeMethod() {
		  test.info(" my test execution start");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  test.info("execution end");
	  }

}
