package com.TalentRecruit.utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.TalentRecruit.testCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter

{
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
    public void onStart(ITestContext testContext)
	
	{   
		System.out.print("On Test Start");
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date());
		String repName="TR-Test-Report-"+timeStamp+".html";
		htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extent=new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "Stage");
		extent.setSystemInfo("QA_USER", "Automation_User");
		
		htmlReporter.config().setDocumentTitle("TR Automation Test Project");
		htmlReporter.config().setReportName("TR Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		//htmlReporter.config().setLevel(logger.);
		
	}


   public void onTestSuccess (ITestResult tr)

   {   
	   System.out.print("On Test Success");
	   logger= extent.createTest(tr.getName());
	   logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	 //logger.log(Status.PASS, MarkupHelper.createLabel(tr.getThrowable().toString(), ExtentColor.GREEN));
	   
	
   }
	
   public void onTestFailure (ITestResult tr)

	{    
   	    System.out.print("On Test Failure");
		logger= extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		//logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getThrowable(), ExtentColor.RED));
		//
		//logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getThrowable().toString(), ExtentColor.RED));
		logger.log(Status.FAIL, tr.getThrowable());
		
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+BaseClass.timeStamp1+".png";
				
		File f =new File(screenshotpath);
		
		if (f.exists())
			
		{
			try 
			{
				logger.fail("Screenshot is below :" +logger.addScreenCaptureFromPath(screenshotpath));
				
			}
			
			catch (IOException e)
			
			{
				
				e.printStackTrace();
			}
			
			
		}
		
	}
	
   
   public void onTestSkip (ITestResult tr)

    {
	  System.out.print("On Test Skipped");
	  logger= extent.createTest(tr.getName());
	  logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	
	
    }


   public void onFinish (ITestContext textContext)

   {   
	System.out.print("On Test Finish");
	extent.flush();
   }

	

}
