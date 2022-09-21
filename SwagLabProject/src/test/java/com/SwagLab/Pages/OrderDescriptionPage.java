package com.SwagLab.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDescriptionPage {
	private WebDriver driver;

	public OrderDescriptionPage(WebDriver driver) {
		this.driver = driver;
	}

	// locator
	private By finishbtn = By.xpath("//button[@id='finish']");
	private By text = By.xpath("//h2[@class='complete-header']");

	// Action
	public void doFinish() {
		driver.findElement(finishbtn).click();

	}

	public String getResultText() {
		return driver.findElement(text).getText();
	}

}
