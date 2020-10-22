package com.SampleMaven.FaceBookAuto.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
		public static  ExtentReports extent;
		public static ExtentReports  getInstance()
		{
			if(extent ==null)
			{
				return  CreateInstance("/test-output/MultipleClassesReport.html");		
			}
			else
			{
				return extent;
			}
		}
		
		
		
		public static ExtentReports CreateInstance(String FilehtmlName)
		{
			 ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+FilehtmlName);
			  htmlReport.config().setDocumentTitle("FB Automation HTML Report " );
			  htmlReport.config().setReportName("Functional Testing");
			  htmlReport.config().setTheme(Theme.DARK);
			 
			  
			  ///extent  report  
			  extent = new ExtentReports();
			  extent.attachReporter(htmlReport);
			 
			  
			  ////additional information
			  extent.setSystemInfo("HostName", "LocalHost");
			  extent.setSystemInfo("OSName", "Windows10");
			  extent.setSystemInfo("BrowserName", "Chrome");
			  extent.setSystemInfo("UserName", "Pragna");
			  extent.setSystemInfo("TesterName", "Pragna");
			  
			
			
			return extent;
		}
		
		

	


}
