package com.SwagLab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddtocartPage {
	private WebDriver driver;

	// Initialization
	public AddtocartPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By removebtn = By.xpath("//button[@id='remove-sauce-labs-backpack']");
	private By continuebtn = By.xpath("//button[@id='continue-shopping']");
	private By checkoutbtn = By.xpath("//button[@id='checkout']");

	// Action
	public String getAddtocartPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void gotoRemove() {
		driver.findElement(removebtn).click();
	}

	public void gotoContinueshopping() {
		driver.findElement(continuebtn).click();
	}

	public void docheckout() {
		driver.findElement(checkoutbtn).click();
	}

}
