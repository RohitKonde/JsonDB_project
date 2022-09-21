package com.SwagLab.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo 
{
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@BeforeClass
	public void setupReport() 
	{
		spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\Reports\\testreport" + System.currentTimeMillis() + ".html");
		report = new ExtentReports();
		report.attachReporter(spark);
		test = report.createTest("ExtentReportDemo");
	}

	@Test
	public void testCase() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		if (driver.getTitle().equals("Googl")) {
			test.pass("Title is matched....Test Passed!");
		} else

		{
			test.fail("Title is not match....Test Fail!");
		}

		test.info("This is title validation test completed1");
	}

	@AfterClass
	public void closeReport() 
	{
		report.flush();
	}
}
