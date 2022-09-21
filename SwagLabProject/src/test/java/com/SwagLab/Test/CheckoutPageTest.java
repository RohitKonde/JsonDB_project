package com.SwagLab.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.SwagLab.Utility.ExcelUtil;
import com.SwagLab.Utility.PropertiesFile;

public class CheckoutPageTest extends BaseTest {
	@BeforeClass
	public void pageSetup() {
		lpage.doLogin(ExcelUtil.getData(0, 0), ExcelUtil.getData(0, 1));
		test.pass("Login Test is Passed");
		check.wait(2000);
		ppage.addProduct();
		test.pass("product added to cart successfully");
		check.wait(2000);
		apage.docheckout();
		test.pass("Checkout process started");
		check.wait(2000);
	}

	@Test(priority = 1)
	public void docompleteCheckout() {
		check.docompletCheckout(PropertiesFile.getProp("fname"), PropertiesFile.getProp("lname"),
				PropertiesFile.getProp("zipcode"));
	}

	@Test(priority = 2)
	public void gotoDescription() {
		order.doFinish();
	}

	@Test(priority = 3)
	public void resultTest() {
		String text = order.getResultText();
		System.out.println(text);
		test.pass("Checkout process Completed");
	}

}
