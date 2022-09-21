package com.SwagLab.Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserProvider {
	public static WebDriver driver;

	public static WebDriver browserSetup(String bname, String url) {
		if (bname.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (bname.equalsIgnoreCase("firefox"))

		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		return driver;

	}

}
