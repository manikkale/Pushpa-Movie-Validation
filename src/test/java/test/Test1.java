package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Base;
import pojo.Browser;
import pom.Page1;
import pom.Page2;
import utility.Extent_report;

public class Test1 extends Base{
	ExtentReports extent;
	ExtentTest tests;
	Page1 test1;
	Page2 test;
	 String imdbDate;
	 String imdborgCountry;
	 String wikiDate;
	 String wikiorgCountry;
	
	@BeforeTest
	public void createReport() {
		extent=Extent_report.generateReports();
		 
	}
	@BeforeMethod
	public void browser() {
		driver=Browser.openBrowser("https://www.google.com/");
	}
	
	@AfterMethod
	public void captureResult(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			tests.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			tests.log(Status.FAIL, result.getName());
		}
		else {
			tests.log(Status.SKIP,result.getName());
		}
		driver.close();
	}
			@AfterTest
		public void flushReports() {
			extent.flush();
		}
	@Test(priority=1)
	public void extractDataIMDB()  {		
		tests=extent.createTest("extractDataIMDB");
		test1=new Page1(driver);
		test1.googleSearch();
		test1.searchName();
		test1.clickOnSearchbtn();
		test1.clickOnName();
		test1.scroll(driver);
		imdbDate=test1.extractDate();
		imdborgCountry=test1.extractCountry();		
	}
	@Test(priority=2)
	public void extractDataWIKI() {
		tests=extent.createTest("extractDataWIKI");
		 test=new Page2(driver);
		test.googleSearch();
		test.searchName();
		test.clickOnSearchbtn();
		wikiDate=test.extractDate();
		wikiorgCountry=test.extractCountry();
		}
	@Test(priority=3)
	public void compareDate() {
		tests=extent.createTest("compareDate");
		System.out.println(imdbDate);
		System.out.println(wikiDate);
        Assert.assertEquals(imdbDate, wikiDate,"failed-if both results are different");
		}
	@Test(priority=4)
	public void compareCountry() {
		tests=extent.createTest("compareCountry");
		System.out.println(imdborgCountry);
		System.out.println(wikiorgCountry);
		Assert.assertEquals(imdborgCountry, wikiorgCountry,"failed-if both results are different");
	}

}
