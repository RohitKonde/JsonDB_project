package com.SwagLab.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	private WebDriver driver;

	// Initialization of driver
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// Identification

	private By productlist = By.xpath(
			"(//div[@id='inventory_container'])[2]//div//div[@class='inventory_item_label']//a//div[@class='inventory_item_name']");
	private By addproductbtn = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	private By cartlink = By.xpath("//a[@class='shopping_cart_link']");

	// Action
	public String productpageTitle() {
		return driver.getTitle();
	}

	public String productpageUrl() {
		return driver.getCurrentUrl();
	}

	public List<WebElement> productCount() {
		return driver.findElements(productlist);
	}

	public void addProduct() {
		driver.findElement(addproductbtn).click();
		driver.findElement(cartlink).click();
	}

}
