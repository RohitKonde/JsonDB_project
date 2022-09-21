package com.SwagLab.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddtocartPageTest extends BaseTest {
	@BeforeClass
	public void setuppage() {
		lpage.doLogin("standard_user", "secret_sauce");
		ppage.addProduct();
	}

	@Test(priority = 1)
	public void addtocartPageTest() {

		String title = apage.getAddtocartPageTitle();
		// Assert.assertTrue(title.contains("Cart")); OR
		System.out.println(title);
	}

	@Test(priority = 2)
	public void addtocartpageUrl() {
		String url = apage.getCurrentUrl();
		System.out.println(url);
	}

	@Test(priority = 3)
	public void docheckOut() {
		apage.docheckout();
	}

}
