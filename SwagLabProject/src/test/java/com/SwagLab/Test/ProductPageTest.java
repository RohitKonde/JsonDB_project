package com.SwagLab.Test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {
	@BeforeClass
	public void productpageSetup() {
		lpage.doLogin("standard_user", "secret_sauce");
	}

	@Test(priority = 1)
	public void productPageTitle() {
		String acttitle = ppage.productpageTitle();
		Assert.assertTrue(acttitle.contains("Swag"));
	}

	@Test(priority = 2)
	public void productPageCurrentUrl() {
		String actUrl = ppage.productpageUrl();
		Assert.assertTrue(actUrl.contains("inventory"));
	}

	@Test(priority = 3)
	public void TotalProduct() {
		List<WebElement> list = ppage.productCount();
		System.out.println("Total Product are:" + list.size());
	}

	@Test(priority = 4)
	public void SelectProduct() {
		ppage.addProduct();
	}

}
