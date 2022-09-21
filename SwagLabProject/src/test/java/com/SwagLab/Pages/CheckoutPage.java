package com.SwagLab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	private By fname = By.xpath("//input[@id='first-name']");
	private By lname = By.xpath("//input[@id='last-name']");
	private By pcode = By.xpath("//input[@id='postal-code']");
	private By continuebtn = By.xpath("//input[@id='continue']");
	private By cancelbtn = By.xpath("//button[@id='cancel']");

	// action
	public void docompletCheckout(String firstname, String lastname, String postalcode) {
		driver.findElement(fname).sendKeys(firstname);
		driver.findElement(lname).sendKeys(lastname);
		driver.findElement(pcode).sendKeys(postalcode);
		driver.findElement(continuebtn).click();
	}

	public void cancelProcess() {
		driver.findElement(cancelbtn).click();
	}

	public void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
