package com.SwagLab.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.SwagLab.Pages.AddtocartPage;
import com.SwagLab.Pages.CheckoutPage;
import com.SwagLab.Pages.Loginpage;
import com.SwagLab.Pages.OrderDescriptionPage;
import com.SwagLab.Pages.ProductPage;
import com.SwagLab.Utility.BrowserProvider;
import com.SwagLab.Utility.ExcelUtil;
import com.SwagLab.Utility.PropertiesFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	public WebDriver driver;
	public Loginpage lpage;// LoginPage connected
	public ProductPage ppage;// productpage connected
	public AddtocartPage apage;// Addtocart page connected
	public CheckoutPage check;
	public OrderDescriptionPage order;
	public BrowserProvider bprovider;
	public PropertiesFile prop;
	public Properties p1;
	public ExcelUtil excel;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@BeforeTest
	public void setup() {
		prop = new PropertiesFile();

		driver = BrowserProvider.browserSetup(PropertiesFile.getProp("bname"), PropertiesFile.getProp("url"));
//	WebDriverManager.chromedriver().setup();
//	 driver=new ChromeDriver();
		excel = new ExcelUtil();
		lpage = new Loginpage(driver);// object created of login page
		ppage = new ProductPage(driver);// object created for Product page
		apage = new AddtocartPage(driver);
		check = new CheckoutPage(driver);
		order = new OrderDescriptionPage(driver);
		spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\Reports\\testreport" + System.currentTimeMillis() + ".html");
		report = new ExtentReports();
		report.attachReporter(spark);
		test = report.createTest("ExtentReportDemo");
//	driver.get("https://www.saucedemo.com/");
	}

	@AfterTest
	public void TearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		report.flush();
	}
}
