package com.utility;
import java.io.File;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pageobject.AboutUs;
import com.pageobject.FeesAndPayment;
import com.pageobject.GiftCards;
import com.pageobject.HomePage;
import com.pageobject.LoginPage;
import com.pageobject.SearchPage;
import com.pageobject.Shipping;
import com.pageobject.SofaPage;
import com.pageobject.StudyClass;
import com.reusable.DriverClass;
import com.reusable.HelperClass;


public class BaseClass
{
	public WebDriver driver;
	public ConfigClass co;
	public ExtentReports report;
	public ExtentTest log;
	public ExcelClass ex;
	public HomePage hp;
	public LoginPage lp;
	public SearchPage sp;
	public StudyClass sc;
	public FeesAndPayment fp;
	public SofaPage sb;
	public GiftCards gc;
	public AboutUs au;
	public Shipping sh;

	@BeforeSuite
	public void start() throws Exception
	{
		ex =new ExcelClass();
		co = new ConfigClass();
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Urban_"+HelperClass.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);	
		
	}
	

	@AfterMethod
	public void ssMethod(ITestResult result) throws Exception
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			log.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
			log.fail("Oops! The TestCase failed");
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			log.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
			log.pass("Hey! The Testcase is Passed");
		}
		report.flush();
	}
}
