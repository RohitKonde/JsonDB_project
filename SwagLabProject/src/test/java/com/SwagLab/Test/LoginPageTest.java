package com.SwagLab.Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.SwagLab.Utility.ExcelUtil;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitle() {
		String acttitle = lpage.getAppTitle();
		Assert.assertTrue(acttitle.contains("Labs"));
	}

	@Test(priority = 2)
	public void loginpageCurrentUrl() {
		String url = lpage.getAppCurrentUrl();
		Assert.assertTrue(url.contains("saucedemo"));
	}

	@Test(priority = -3)
	public void loginTest() {
		// lpage.doLogin(PropertiesFile.getProp("un"), PropertiesFile.getProp("psw"));
		lpage.doLogin(ExcelUtil.getData(0, 0), ExcelUtil.getData(0, 1));
		String act = driver.getCurrentUrl();
		Assert.assertTrue(act.contains("inventory"));
	}
}
